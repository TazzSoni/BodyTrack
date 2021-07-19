package com.example.bodytrack.Model;

import java.util.ArrayList;
import java.util.List;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Atividade {

    @PrimaryKey (autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nome")
    private String nome;


    public Atividade(String nome) {
        this.nome = nome;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
