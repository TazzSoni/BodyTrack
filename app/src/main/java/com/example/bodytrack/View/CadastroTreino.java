package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodytrack.Control.CadastroTreinoAdapter;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.Model.TreinoAtividadeCrossRef;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;

public class CadastroTreino extends AppCompatActivity {

    TreinoAtividadeCrossRef treinoAtividadeCrossRef;
    List<Atividade> atividades = new ArrayList<>();
    List<Integer> atividadess = new ArrayList<>();
    ListView list;
    BaseAdapter adapter;

    int LAUNCH_SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_treino);

        list = findViewById(R.id.listCadastroTreino);

        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);
        TextView titulo = findViewById(R.id.title_toolbar);
        Button btCadastrarAtividade = findViewById(R.id.btCadastraAtividade);
        Button btSalvarTreino = findViewById(R.id.btSalvarTreino);
        titulo.setText("Cadastro de treino");

        try {
            adapter = new CadastroTreinoAdapter(this, atividades);
            list.setAdapter(adapter);
        } catch (Exception e) {

        }


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
                startActivityForResult(it, LAUNCH_SECOND_ACTIVITY);
            }
        });
        btSalvarTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroTreino.this, Home.class);
                salvarTreino();
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == CadastroSerie.RESULT_OK) {
                atividadess.add(Integer.parseInt(data.getStringExtra("resultAtividade")));
            }
            if (resultCode == CadastroSerie.RESULT_CANCELED) {
                // Write your code if there's no result
            }
            buscaListAtividades();
            adapter.notifyDataSetChanged();

        }
    }

    private void buscaListAtividades() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        atividades.clear();
        for (Integer i : atividadess) {
            atividades.add(db.atividadeDAO().getOne(new Long(i)));
        }
    }

    private Atividade buscaListAtividade(int id) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        return db.atividadeDAO().getOne(id);
    }

    public void salvarTreino() {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        Treino treino = new Treino();
        EditText nome = (EditText) findViewById(R.id.taNomeTreino);
        treino.setNome(nome.getText().toString());
        long treinoId = db.treinoDao().insertOne(treino);

        for (Integer i : atividadess) {
            TreinoAtividadeCrossRef treinoAtividadeCrossRef = new TreinoAtividadeCrossRef();
            treinoAtividadeCrossRef.setAtividadeId(i);
            treinoAtividadeCrossRef.setTreinoId(treinoId);
            db.treinoCrossRefDAO().insertAll(treinoAtividadeCrossRef);
        }
        Intent it = new Intent(CadastroTreino.this, Home.class);

        String id = String.valueOf(treinoId);
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resultTreino", id);
        setResult(CadastroTreino.RESULT_OK, returnIntent);
        finish();

    }
}