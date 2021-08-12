package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodytrack.Control.CadastroAtvAdapter;
import com.example.bodytrack.Control.CadastroTreinoAdapter;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.PessoaTreinoCrossRef;
import com.example.bodytrack.Model.PessoaTreinos;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.Model.TreinoAtividadeCrossRef;
import com.example.bodytrack.Model.TreinoAtividades;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;

public class CadastroTreino extends AppCompatActivity {

    TreinoAtividadeCrossRef treinoAtividadeCrossRef;

    //Get the bundle
    // Bundle bundle = getIntent().getExtras();

    //Extract the data…
    long treinoId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_treino);

//
//        Atividade atividade1 = new Atividade();
//        atividade1.setAtividadeId(0);
//        atividade1.setNome("Atividade 1");
//        salvarAtividade(atividade1);
//        Atividade atividade2 = new Atividade();
//        atividade2.setAtividadeId(1);
//        atividade2.setNome("Atividade 2");
//        salvarAtividade(atividade2);
//        Atividade atividade3 = new Atividade();
//        atividade3.setAtividadeId(2);
//        atividade3.setNome("Atividade 3");
//        salvarAtividade(atividade3);
//
//        salvarTreinoCrossRef(treinoId, atividade1.getAtividadeId());
//        salvarTreinoCrossRef(treinoId, atividade2.getAtividadeId());
//        salvarTreinoCrossRef(treinoId, atividade3.getAtividadeId());

        ListView list = findViewById(R.id.listCadastroTreino);
        List<TreinoAtividades> treinoAtividades = buscaListAtividades();
        try {
            List<Atividade> atividades = treinoAtividades.get(0).atividades;
            list.setAdapter(new CadastroTreinoAdapter(this, atividades));
        } catch (Exception e) {

        }

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

    private List<TreinoAtividades> buscaListAtividades() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        return db.treinoatividadesDAO().getTreinoAtividades();
    }

    private Atividade buscaListAtividade(int id) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        return db.atividadeDAO().getOne(id);
    }


    public void salvarAtividade(Atividade atividade) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            db.atividadeDAO().insertAll(atividade);
        } catch (Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void salvarTreinoCrossRef(long treinoId, long atividadeId) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        treinoAtividadeCrossRef = new TreinoAtividadeCrossRef();
        treinoAtividadeCrossRef.setTreinoId(treinoId);
        treinoAtividadeCrossRef.setAtividadeId(atividadeId);
        try {
            db.treinoCrossRefDAO().insertAll(treinoAtividadeCrossRef);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void salvarTreino(int atividadeId) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        if (setBundle() > 0) {
            Treino treino = new Treino();
            EditText nome = findViewById(R.id.taNomeTreino);
            treino.setNome(nome.getText().toString());

            salvarTreinoCrossRef(treino.getTreinoId(), setBundle());
        }
    }

    public int setBundle() {
        try {
            Bundle bundle = getIntent().getExtras();
            int l = bundle.getInt("idAtividadeToPass");
            return l;
        } catch (Exception e) {

        }
        return -1;
    }
}