package com.example.bodytrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodytrack.Model.Pessoa;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

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
                EditText senha = (EditText) findViewById(R.id.taCadastroSenha);
                pessoa = new Pessoa(nome.getText().toString(), senha.getText().toString());
                Toast toast = Toast.makeText(this, pessoa.toString(), Toast.LENGTH_SHORT);
                startActivity(it);
                toast.show();
                break;
            default:
                break;
        }
    }
}