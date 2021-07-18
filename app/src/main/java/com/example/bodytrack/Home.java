package com.example.bodytrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView voltar = findViewById(R.id.left_arrow);
        ImageView sair = findViewById(R.id.right_arrow);

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

    }

   }