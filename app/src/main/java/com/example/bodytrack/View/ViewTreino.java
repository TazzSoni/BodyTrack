package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bodytrack.Control.ViewTreinoAdapter;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.PessoaTreinoCrossRef;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewTreino extends AppCompatActivity {

    TextView tituloNav;
    TextView tituloTreino;
    ListView list;
    List<Atividade> atividades = new ArrayList<>();
    long id;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        setContentView(R.layout.activity_treino);

        list = findViewById(R.id.listViewTreino);

        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);
        tituloNav = findViewById(R.id.title_toolbar);
        tituloNav.setText("Visualização de Treino");
        tituloTreino = findViewById(R.id.taViewNomeTreino);

        try {
            id = Long.parseLong(getIntent().getStringExtra("treinoId"));
            String nome = getIntent().getStringExtra("treinoNome");
            atividades = buscaListAtividades(id);
            tituloTreino.setText(nome.toUpperCase(Locale.ROOT));
            list.setAdapter(new ViewTreinoAdapter(this, atividades));
        } catch (Exception e) {

        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long iId) {
                Intent intent = new Intent(context, ViewAtividades.class);
                Atividade a = (Atividade) parent.getItemAtPosition(position);
                String atividadeId = String.valueOf(a.getAtividadeId());
                intent.putExtra("viewAtividadeId", atividadeId);
                intent.putExtra("viewAtividadeNome", a.getNome());
                intent.putExtra("viewAtividadeIdTreino", id);
                startActivity(intent);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            long id = Long.parseLong(getIntent().getStringExtra("treinoIdVolta"));
            List<Atividade> treinoAtividades1 = buscaListAtividades(id);
            list.setAdapter(new ViewTreinoAdapter(this, treinoAtividades1));
        } catch (Exception e) {

        }
    }

    private List<Atividade> buscaListAtividades(long treinoId) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {

        } catch (Exception e) {

        }

        return db.atividadeDAO().getAtividadesTreino(treinoId);
    }

}