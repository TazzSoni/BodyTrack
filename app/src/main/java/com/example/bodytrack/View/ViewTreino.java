package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bodytrack.Control.CadastroAtvAdapter;
import com.example.bodytrack.Control.CadastroTreinoAdapter;
import com.example.bodytrack.Control.HomeAdapter;
import com.example.bodytrack.Control.ViewTreinoAdapter;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.PessoaTreinos;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.Model.TreinoAtividades;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;

public class ViewTreino extends AppCompatActivity {

    TextView titulo;
    ListView list;
    List<Atividade> atividades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);

        list = findViewById(R.id.listViewTreino);

        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);
        titulo = findViewById(R.id.title_toolbar);
        titulo.setText("ViewTreino");


        //buscaListAtividades();
        long id = Long.parseLong(getIntent().getStringExtra("treinoId"));
        List<Atividade> treinoAtividades1 = buscaListAtividades1(id);
        try {
            // List<Atividade> atividades = treinoAtividades1.get(0).atividades;
            list.setAdapter(new ViewTreinoAdapter(this, treinoAtividades1));
        } catch (Exception e) {

        }

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ViewTreino.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ViewTreino.this, Home.class);
                startActivity(it);
                finish();
            }
        });
    }

    private void buscaListAtividades() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();


        int id = Integer.parseInt(getIntent().getStringExtra("treinoId"));
        List<TreinoAtividades> treinoAtividades = db.treinoatividadesDAO().getTreinoAtividades();
        for (TreinoAtividades t : treinoAtividades) {
            if (t.treino.getTreinoId() == id) {
                list.setAdapter(new CadastroTreinoAdapter(this, t.atividades));
            }
        }

    }

    private List<Atividade> buscaListAtividades1(long treinoId) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        return db.atividadeDAO().getAtividadesTreino(treinoId);
    }

}