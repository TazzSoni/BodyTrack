package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Pessoa;
import com.example.bodytrack.Model.PessoaSecao;
import com.example.bodytrack.R;

import java.util.List;

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
        switch (view.getId()) {
            case R.id.btCadastrar:
                startActivity(it);
                break;
            case R.id.btLogin:

//                Intent ut = new Intent(MainActivity.this, Home.class);
//                startActivity(ut);
                EditText login = (EditText) findViewById(R.id.talogin);
                EditText senha = (EditText) findViewById(R.id.taSenha);
                logar(login.getText().toString(), senha.getText().toString());
                break;
        }
    }

    public void logar(String login, String senha) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        List<Pessoa> pessoas = db.pessoaDao().getAll();
        if (pessoas.size() > 0) {
            for (Pessoa p : pessoas) {
                if (p.getLogin().equals(login)) {
                    if (p.getSenha().equals(senha)) {
                        Intent home = new Intent(MainActivity.this, Home.class);
                        setPessoaSecao(p.getLogin());
                        startActivity(home);
                    } else {
                        Toast.makeText(this, "Senha incorreta", Toast.LENGTH_LONG).show();
                    }
                }
            }
        } else {
            Toast.makeText(this, "Sem pessoas cadastradas", Toast.LENGTH_LONG).show();
        }


    }

    private void setPessoaSecao(String login) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        PessoaSecao pessoaSecao = new PessoaSecao();
        pessoaSecao.setLogin(login);
        if (db.pessoaSecaoDAO().getList().size() > 0) {
            db.pessoaSecaoDAO().delete(db.pessoaSecaoDAO().getAll());
        }
        db.pessoaSecaoDAO().insertAll(pessoaSecao);
    }
}