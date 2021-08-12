package com.example.bodytrack.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.R;

public class CadastroSerie extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_serie);

        Button btSalvarSerie = findViewById(R.id.btSalvarSerie);


        btSalvarSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText peso = findViewById(R.id.taPesoo);
                EditText numSerie = findViewById(R.id.taSerie);
                EditText repeticao = findViewById(R.id.taRepeticoes);

                System.out.println("Aqui");
                System.out.println("Valor = "+peso.getText().toString());
                Serie serie  = new Serie();
                if(peso.getText().toString() == "" || numSerie.getText().toString() == ""|| repeticao.getText().toString() == ""){
                    Toast.makeText(context, "Preencha todos os Campos", Toast.LENGTH_LONG).show();
                }else{
                serie.setNumSerie(Integer.parseInt(numSerie.getText().toString()));
                serie.setPeso(Integer.parseInt(peso.getText().toString()));
                serie.setRepeticao(Integer.parseInt(repeticao.getText().toString()));
                }


                Intent it = new Intent(CadastroSerie.this, CadastroAtividade.class);
                startActivity(it);
            }
        });
    }

    public void salvarSerie(Serie serie){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bodytrack-db").allowMainThreadQueries().build();
        try {
            db.serieDao().insertAll(serie);
        }
        catch (Exception e){
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}