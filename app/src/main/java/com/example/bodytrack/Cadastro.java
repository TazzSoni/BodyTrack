package com.example.bodytrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodytrack.Model.Pessoa;

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

    @Override
    public void onClick(View view) {
        Intent it = new Intent(Cadastro.this, MainActivity.class);
        switch (view.getId()) {
            case R.id.btCadastrarVoltar:
                startActivity(it);
                break;
            case R.id.btCadastrarPessoa:
                EditText nome = (EditText) findViewById(R.id.taCadastroNome);
                EditText login = (EditText) findViewById(R.id.taLogin);
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

                    toast = Toast.makeText(this, pessoa.toString(), Toast.LENGTH_SHORT);
                    startActivity(it);
                    toast.show();

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