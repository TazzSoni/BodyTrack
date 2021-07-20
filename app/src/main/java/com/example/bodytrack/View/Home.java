package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.bodytrack.Control.CadastroAtvAdapter;
import com.example.bodytrack.Control.HomeAdapter;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);
        Button cadastrartreino = findViewById(R.id.btCadastrarTreino);

        List<Treino> treinos = new ArrayList<Treino>();
        Treino treino = new Treino("Treino 1");
        Treino treino2 = new Treino("Treino 2");
        Treino treino3 = new Treino("Treino 3");


        treinos.add(treino);
        treinos.add(treino2);
        treinos.add(treino3);

        ListView list = findViewById(R.id.listHome);
        list.setAdapter(new HomeAdapter(this, treinos));

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, MainActivity.class);
                startActivity(it);
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, MainActivity.class);
                startActivity(it);
            }
        });
        cadastrartreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, CadastroTreino.class);
                startActivity(it);
            }
        });

    }

   }