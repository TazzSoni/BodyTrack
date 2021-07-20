package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Atividade {

    @PrimaryKey (autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nome")
    private String nome;

    @Ignore
    private List<Serie> series;

    @Ignore
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

    public List<Serie> getSeries() {
        //TODO consulta no banco
        return series;
    }
}
