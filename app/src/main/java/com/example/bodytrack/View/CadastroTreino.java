package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bodytrack.R;

public class CadastroTreino extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_treino);

        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);
        TextView titulo = findViewById(R.id.title_toolbar);
        Button btCadastrarAtividade = findViewById(R.id.btCadastraAtividade);
        titulo.setText("Cadastro de treino");


        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroTreino.this, MainActivity.class);
                startActivity(it);
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroTreino.this, Home.class);
                startActivity(it);
            }
        });
        btCadastrarAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroTreino.this, CadastroAtividade.class);
                startActivity(it);
            }
        });
    }
}