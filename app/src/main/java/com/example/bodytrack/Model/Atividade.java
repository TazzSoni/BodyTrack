package com.example.bodytrack.Model;

import java.util.ArrayList;
import java.util.List;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Atividade {

    @PrimaryKey (autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nome")
    private String nome;

    @Ignore
    private List<Serie> series = null;

    public Atividade() {
    }

    @Ignore
    public Atividade(String nome, List<Serie> series) {
        this.nome = nome;
        this.series = series;
    }

    public void addSerie(Serie serie){
        this.series.add(serie);
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
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
