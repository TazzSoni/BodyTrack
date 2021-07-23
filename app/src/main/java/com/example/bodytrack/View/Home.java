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
import com.example.bodytrack.Model.PessoaTreinoCrossRef;
import com.example.bodytrack.Model.PessoaTreinos;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);
        Button cadastrartreino = findViewById(R.id.btCadastrarTreino);

        Treino treino = new Treino();
        treino.setNome("Treino 1");

        salvarTreino(treino);

        Pessoa pessoa = new Pessoa("Rodrigo", "rod", "123", 10, 10);

        salvarPessoa(pessoa);

        PessoaTreinoCrossRef pessoaTreinoCrossRef = new PessoaTreinoCrossRef();
        pessoaTreinoCrossRef.setLogin(pessoa.getLogin());
        pessoaTreinoCrossRef.setTreinoId(treino.getTreinoId());
        salvarPessoaCrossRef(pessoaTreinoCrossRef);


        ListView list = findViewById(R.id.listHome);
        List<PessoaTreinos> treinos = buscarPessoaTreinos();
        //list.setAdapter(new HomeAdapter(this, treinos));
        Toast.makeText(this, treinos.toString(), Toast.LENGTH_LONG).show();

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


    public void salvarPessoaCrossRef(PessoaTreinoCrossRef pessoaTreinoCrossRef){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            db.pessoaCrossRefDAO().insertAll(pessoaTreinoCrossRef);
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public List<PessoaTreinos> buscarPessoaTreinos(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        return db.pessoaTreinosDAO().getPessoaTreinos();
    }

}