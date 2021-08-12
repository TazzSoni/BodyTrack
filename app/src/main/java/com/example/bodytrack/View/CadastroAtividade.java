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
import com.example.bodytrack.Model.PessoaTreinos;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.TreinoAtividadeCrossRef;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;


public class CadastroAtividade extends AppCompatActivity {

    private Context context;
    List<Integer> seriess = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atividade);

        context = this;

        try {
            List<Serie> series = new ArrayList<Serie>();
            for (Integer s : seriess) {
                series.add(buscaSeries(s));
            }

            ListView list = findViewById(R.id.listCadastroAtividade);
            list.setAdapter(new CadastroAtvAdapter(this, series));

        } catch (Exception e) {

        }

        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);


        Button btCadastarSerie = findViewById(R.id.btCadastarSerie);
        Button btSalvarSerie = findViewById(R.id.btSalvarAtividade);

        if (setBundle() > 0) {
            seriess.add(setBundle());
        }

        btCadastarSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroAtividade.this, CadastroSerie.class);
                startActivity(it);
            }
        });
        btSalvarSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarAtividadeSerieCrossRef();
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

    public int setBundle() {
        try {
            Bundle bundle = getIntent().getExtras();
            int l = bundle.getInt("idSerieToPass");
            return l;
        } catch (Exception e) {

        }
        return -1;
    }

    public Serie adicionaSerie(int id) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        return db.serieDao().getOne(id);
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
            //Passar data para CadastroAtividade

            //Create the bundle
            Bundle bundle = new Bundle();

            //Add your data to bundle
            bundle.putInt("idAtividadeToPass", atividade.getAtividadeId());

            //Add the bundle to the intent
            it.putExtras(bundle);

            //Fire that second activity
            startActivity(it);
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao gravar série", Toast.LENGTH_LONG).show();
        }
    }

}