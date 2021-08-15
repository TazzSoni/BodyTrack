package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bodytrack.Control.CadastroAtvAdapter;
import com.example.bodytrack.Control.CadastroTreinoAdapter;
import com.example.bodytrack.Control.HomeAdapter;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Pessoa;
import com.example.bodytrack.Model.PessoaSecao;
import com.example.bodytrack.Model.PessoaTreinoCrossRef;
import com.example.bodytrack.Model.PessoaTreinos;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {


    PessoaTreinoCrossRef pessoaTreinoCrossRef;
    Pessoa pessoaSecao;
    ListView list;
    List<Treino> treinos = new ArrayList<>();
    List<Integer> treinoss = new ArrayList<>();


    public void setPessoaSecao() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        try {
            String login = db.pessoaSecaoDAO().getAll().getLogin();
            this.pessoaSecao = db.pessoaDao().getOne(login);
            db.pessoaSecaoDAO().delete(db.pessoaSecaoDAO().getAll());
        } catch (Exception e) {

        }
    }

    public Pessoa getPessoaSecao() {
        return pessoaSecao;
    }

    public PessoaTreinoCrossRef getPessoaTreinoCrossRef() {
        return pessoaTreinoCrossRef;
    }

    public void setPessoaTreinoCrossRef(PessoaTreinoCrossRef pessoaTreinoCrossRef) {
        this.pessoaTreinoCrossRef = pessoaTreinoCrossRef;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);
        Button cadastrartreino = findViewById(R.id.btCadastrarTreino);

        setPessoaSecao();

        try {
            list = findViewById(R.id.listHome);
            List<PessoaTreinos> pessoasTreinos = buscarPessoaTreinos();
            List<Treino> treinos = pessoasTreinos.get(0).treinos;
            list.setAdapter(new HomeAdapter(this, treinos));
        } catch (Exception e) {

        }

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });
        cadastrartreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, CadastroTreino.class);

                startActivityForResult(it, 1);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int treinoId = Integer.parseInt(data.getStringExtra("resultTreino"));
        if (requestCode == 1) {
            if (resultCode == CadastroSerie.RESULT_OK) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

                treinoss.add(treinoId);

                PessoaTreinoCrossRef pessoaTreinoCrossRef = new PessoaTreinoCrossRef();
                pessoaTreinoCrossRef.setTreinoId(treinoId);
                pessoaTreinoCrossRef.setLogin(pessoaSecao.getLogin());
                db.pessoaCrossRefDAO().insertAll(pessoaTreinoCrossRef);
            }
            if (resultCode == CadastroSerie.RESULT_CANCELED) {
                // Write your code if there's no result
            }
            buscaListTreinos();
            list.setAdapter(new HomeAdapter(this, treinos));
        }
    }

    private void buscaListTreinos() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        for (Integer i : treinoss) {
            treinos.add(db.treinoDao().getOne(new Long(i)));
        }
    }

    public void salvarTreino(Treino treino) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            db.treinoDao().insertAll(treino);
        } catch (Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void salvarPessoa(Pessoa pessoa) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            db.pessoaDao().insertAll(pessoa);
        } catch (Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    public void salvarPessoaCrossRef(String login, long treinoId) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        pessoaTreinoCrossRef = new PessoaTreinoCrossRef();
        pessoaTreinoCrossRef.setLogin(login);
        pessoaTreinoCrossRef.setTreinoId(treinoId);
        try {
            db.pessoaCrossRefDAO().insertAll(pessoaTreinoCrossRef);
        } catch (Exception e) {
            System.out.println("Erro  = " + e);
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public List<PessoaTreinos> buscarPessoaTreinos() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        return db.pessoaTreinosDAO().getPessoaTreinos();
    }

}