package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bodytrack.Control.CadastroAtvAdapter;
import com.example.bodytrack.Control.CadastroTreinoAdapter;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;

public class CadastroTreino extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_treino);

        List<Atividade> atividades = new ArrayList<>();

        Atividade atividade1 = new Atividade();
        atividade1.setNome("Atividade 1");
        salvarAtividade(atividade1);
        Atividade atividade2 = new Atividade();
        atividade2.setNome("Atividade 2");
        salvarAtividade(atividade2);
        Atividade atividade3 = new Atividade();
        atividade3.setNome("Atividade 3");
        salvarAtividade(atividade3);

        atividades.add(atividade1);
        atividades.add(atividade2);
        atividades.add(atividade3);

        ListView list = findViewById(R.id.listCadastroTreino);
        list.setAdapter(new CadastroTreinoAdapter(this, atividades));

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

    public void salvarAtividade(Atividade atividade){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            db.atividadeDAO().insertAll(atividade);
        }
        catch (Exception e){
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}