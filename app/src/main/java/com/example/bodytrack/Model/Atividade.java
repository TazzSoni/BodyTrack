package com.example.bodytrack.Model;

import java.util.ArrayList;
import java.util.List;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Atividade {

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "nome")
    private String nome;

    private List<Serie> series = new ArrayList<>();

    public Atividade(String nome) {
        this.nome = nome;
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
