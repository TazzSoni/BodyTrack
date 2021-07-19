package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodytrack.DAO.AppDatabase;
import com.example.bodytrack.Model.Pessoa;
import com.example.bodytrack.R;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    Toast toast;
    Pessoa pessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btVoltar = (Button) findViewById(R.id.btCadastrarVoltar);
        btVoltar.setOnClickListener(this);
        Button btCadastrar = (Button) findViewById(R.id.btCadastrarPessoa);
        btCadastrar.setOnClickListener(this);

    }

    public void salvarPessoa(Pessoa pessoa){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try{
            db.pessoaDao().insertAll(pessoa);
            Toast.makeText(this,"Fez",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(Cadastro.this, MainActivity.class);
        switch (view.getId()) {
            case R.id.btCadastrarVoltar:
                startActivity(it);
                break;
            case R.id.btCadastrarPessoa:
                EditText nome = (EditText) findViewById(R.id.taCadastroNome);
                EditText login = (EditText) findViewById(R.id.taCadastroLogin);
                EditText senha = (EditText) findViewById(R.id.taCadastroSenha);
                EditText confirmaSenha = (EditText) findViewById(R.id.taConfirmarSenha);
                EditText peso = (EditText) findViewById(R.id.taPeso);
                EditText altura = (EditText) findViewById(R.id.taAltura);
                if(TextUtils.isEmpty(senha.getText().toString())){
                    toast = Toast.makeText(this, "Senha não confere!!", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(TextUtils.isEmpty(confirmaSenha.getText().toString())){
                    toast = Toast.makeText(this, "Senha não confere!!", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(senha.getText().toString().equals(confirmaSenha.getText().toString())){
                    pessoa = new Pessoa(
                            nome.getText().toString(),
                            login.getText().toString(),
                            senha.getText().toString(),
                            Double.parseDouble(peso.getText().toString().replace(',', '.')),
                            Double.parseDouble(altura.getText().toString().replace(',', '.')));

                    salvarPessoa(pessoa);
                    startActivity(it);

                }else{
                    toast = Toast.makeText(this, "Senha não confere!!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            default:
                break;
        }
    }
}