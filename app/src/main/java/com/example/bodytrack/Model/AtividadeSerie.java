package com.example.bodytrack.Model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity
public class AtividadeSerie {

    @Embedded
    public Atividade atividade;
    @Relation(
            parentColumn = "id",
            entityColumn = "numSerie",
            entity = Serie.class
    )
    public List<Serie> series ;

    public AtividadeSerie(Atividade atividade, List<Serie> series) {
        this.atividade = atividade;
        this.series = series;
    }
}
