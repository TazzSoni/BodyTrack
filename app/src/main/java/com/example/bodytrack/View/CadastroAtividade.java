package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.bodytrack.Control.CadastroAtvAdapter;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;


public class CadastroAtividade extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atividade);

        context = this;
        List<Serie> series = new ArrayList<Serie>();
        Atividade atividade = new Atividade();
        atividade.setNome("Atividade 1");

        Serie serie1 = new Serie();
        serie1.setPeso(10);
        serie1.setRepeticao(10);
        Serie serie2 = new Serie();
        serie2.setRepeticao(10);
        serie2.setPeso(10);

        series.add(serie1);
        series.add(serie2);

        ListView list = findViewById(R.id.listCadastroAtividade);
        list.setAdapter(new CadastroAtvAdapter(this, series));


        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroAtividade.this, MainActivity.class);
                startActivity(it);
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroAtividade.this, CadastroTreino.class);
                startActivity(it);
            }
        });

    }

}