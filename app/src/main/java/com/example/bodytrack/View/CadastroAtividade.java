package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bodytrack.Control.CadastroAtvAdapter;
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
        series.add(new Serie(1,8,20));
        series.add(new Serie(2,10,20));


        ListView list = findViewById(R.id.listCadastroAtividade);
        list.setAdapter(new CadastroAtvAdapter(this, series));
    }
}