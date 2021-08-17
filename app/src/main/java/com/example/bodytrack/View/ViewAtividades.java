package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.bodytrack.Control.ViewAtividadeAdapter;
import com.example.bodytrack.Control.ViewTreinoAdapter;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewAtividades extends AppCompatActivity {

    private Context context;
    List<Integer> seriess = new ArrayList<>();
    TextView tituloAtividade;
    ListView list;
    TextView tituloNav;
    String treinoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_atividades);

        context = this;

        tituloAtividade = findViewById(R.id.taViewNomeAtividade);
        list = findViewById(R.id.listViewAtividade);
        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);
        tituloNav = findViewById(R.id.title_toolbar);
        tituloNav.setText("Visualização de Treino");

        treinoId = getIntent().getStringExtra("viewAtividadeIdTreino");
        long id = Long.parseLong(getIntent().getStringExtra("viewAtividadeId"));
        String nome = "Atividade - " + getIntent().getStringExtra("viewAtividadeNome");
        List<Serie> atividadesSeries = buscaListAtividades(id);
        tituloAtividade.setText(nome.toUpperCase(Locale.ROOT));
        try {
            list.setAdapter(new ViewAtividadeAdapter(this, atividadesSeries));
        } catch (Exception e) {

        }

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ViewAtividades.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewTreino.class);
                intent.putExtra("treinoIdVolta", treinoId);
                startActivity(intent);
                finish();
            }
        });
    }

    private List<Serie> buscaListAtividades(long atividadeId) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        return db.serieDao().getSeriesAtividade(atividadeId);
    }
}