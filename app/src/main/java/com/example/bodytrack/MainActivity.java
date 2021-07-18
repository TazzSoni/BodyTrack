package com.example.bodytrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bodytrack.Model.Pessoa;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(this);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(MainActivity.this, Cadastro.class);
                startActivity(it);
        //Intent home = new Intent(MainActivity.this, Home.class);
        switch (view.getId()) {
            case R.id.btCadastrar:
                startActivity(it);
                break;
            case R.id.btLogin:
              //  startActivity(home);
                break;
        }
    }
}