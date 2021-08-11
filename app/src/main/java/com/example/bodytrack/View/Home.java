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

public class Home extends AppCompatActivity  {


    PessoaTreinoCrossRef pessoaTreinoCrossRef;
    Pessoa pessoaSecao;



    public void setPessoaSecao() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        try{
        String login = db.pessoaSecaoDAO().getAll().getLogin();
        this.pessoaSecao = db.pessoaDao().getOne(login);
        db.pessoaSecaoDAO().delete(db.pessoaSecaoDAO().getAll());
        }catch(Exception e){

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

//        Treino treino = new Treino();
//        treino.setTreinoId(0);
//        treino.setNome("Treino 1");
//        salvarTreino(treino);
//
//        Treino treino2 = new Treino();
//        treino2.setTreinoId(1);
//        treino2.setNome("Treino 2");
//        salvarTreino(treino2);
//
//        Treino treino3 = new Treino();
//        treino3.setTreinoId(2);
//        treino3.setNome("Treino 3");
//        salvarTreino(treino3);
//
//        try{
//        salvarPessoaCrossRef(pessoaSecao.getLogin(), treino.getTreinoId());
//        salvarPessoaCrossRef(pessoaSecao.getLogin(), treino2.getTreinoId());
//        salvarPessoaCrossRef(pessoaSecao.getLogin(), treino3.getTreinoId());
//        }catch(Exception e){
//
//        }

        try{
        ListView list = findViewById(R.id.listHome);
        List<PessoaTreinos> pessoasTreinos = buscarPessoaTreinos();
        List<Treino> treinos = pessoasTreinos.get(0).treinos;
        list.setAdapter(new HomeAdapter(this, treinos));
        }catch(Exception e){

        }

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
                //Create the bundle
                Bundle bundle = new Bundle();

                //Add your data to bundle
                try{
                bundle.putLong("data", pessoaTreinoCrossRef.getTreinoId());
                }catch(Exception e){
                    
                }

                //Add the bundle to the intent
                it.putExtras(bundle);
                startActivity(it);
            }
        });



    }
    public void salvarTreino(Treino treino){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            db.treinoDao().insertAll(treino);
        }
        catch (Exception e){
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void salvarPessoa(Pessoa pessoa){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            db.pessoaDao().insertAll(pessoa);
        }
        catch (Exception e){
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    public void salvarPessoaCrossRef(String login, long treinoId){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        pessoaTreinoCrossRef = new PessoaTreinoCrossRef();
        pessoaTreinoCrossRef.setLogin(login);
        pessoaTreinoCrossRef.setTreinoId(treinoId);
        try {
            db.pessoaCrossRefDAO().insertAll(pessoaTreinoCrossRef);
        }
        catch (Exception e){
            System.out.println("Erro  = "+e);
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public List<PessoaTreinos> buscarPessoaTreinos() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();

        return db.pessoaTreinosDAO().getPessoaTreinos();
    }

}