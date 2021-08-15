package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bodytrack.Control.CadastroAtvAdapter;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.AtividadeSerieCrossRef;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;


public class CadastroAtividade extends AppCompatActivity {

    private Context context;
    List<Integer> seriess = new ArrayList<>();
    int LAUNCH_SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atividade);

        context = this;


        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);


        Button btCadastarSerie = findViewById(R.id.btCadastarSerie);
        Button btSalvarAtividade = findViewById(R.id.btSalvarAtividade);


        btCadastarSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(CadastroAtividade.this, CadastroSerie.class);
                startActivityForResult(it, LAUNCH_SECOND_ACTIVITY);
            }
        });
        btSalvarAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarAtividadeSerieCrossRef();
                seriess.clear();
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroAtividade.this, CadastroTreino.class);
                startActivity(it);
            }
        });
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroAtividade.this, MainActivity.class);
                startActivity(it);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == CadastroSerie.RESULT_OK) {
                seriess.add(Integer.parseInt(data.getStringExtra("resultSerie")));
                try {
                    List<Serie> series = new ArrayList<>();
                    for (Integer s : seriess) {
                        series.add(buscaSeries(s));
                    }

                    ListView list = findViewById(R.id.listCadastroAtividade);
                    list.setAdapter(new CadastroAtvAdapter(this, series));

                } catch (Exception e) {

                }
            }
            if (resultCode == CadastroSerie.RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }
    }

    public Serie buscaSeries(int id) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        return db.serieDao().getOne(id);
    }

    public void adicionarAtividadeSerieCrossRef() {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            Atividade atividade = new Atividade();
            EditText nome = (EditText) findViewById(R.id.taNomeAtividade);
            atividade.setNome(nome.getText().toString());
            long atividadeId = db.atividadeDAO().insertAll(atividade);

            for (Integer i : seriess) {
                AtividadeSerieCrossRef atividadeSerieCrossRef = new AtividadeSerieCrossRef();
                atividadeSerieCrossRef.setSerieId(i);
                atividadeSerieCrossRef.setAtividadeId(atividadeId);
                db.atividadeCrossRefDAO().insertAll(atividadeSerieCrossRef);
            }
            Intent it = new Intent(CadastroAtividade.this, CadastroTreino.class);


            String id = String.valueOf(atividadeId);
            Intent returnIntent = new Intent();
            returnIntent.putExtra("resultAtividade", id);
            setResult(CadastroSerie.RESULT_OK, returnIntent);
            finish();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Toast.makeText(this, "Erro ao gravar Atividade", Toast.LENGTH_LONG).show();
        }
    }

}