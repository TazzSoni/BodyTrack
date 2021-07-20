package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bodytrack.Control.CadastroAtvAdapter;
import com.example.bodytrack.DAO.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.AtividadeSerie;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.R;

import java.util.ArrayList;
import java.util.List;


public class CadastroAtividade extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atividade);

        context = this;
        List<Serie> series = new ArrayList<Serie>();
        Atividade atividade = new Atividade("Atividade 1");
        series.add(new Serie(8,20, atividade));
        series.add(new Serie(10,20, atividade));

        ListView list = findViewById(R.id.listCadastroAtividade);
        list.setAdapter(new CadastroAtvAdapter(this, series));

        salvarSerie(series);
    }

    public void salvarSerie(List<Serie> series){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try{
            for(Serie serie : series){
                db.serieDao().insertAll(serie);
            }
            Toast.makeText(this,"Fez",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}