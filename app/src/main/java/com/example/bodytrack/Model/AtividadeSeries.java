package com.example.bodytrack.Model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class AtividadeSeries {

    @Embedded
    public Atividade atividade;
    @Relation(
            parentColumn = "aitividadeId",
            entityColumn = "serieId",
            associateBy = @Junction(AtividadeSerieCrossRef.class)
    )
    public List<Serie> series;

    @Override
    public String toString() {
        return "AtividadeSerie{" +
                "atividade=" + atividade +
                ", series=" + series +
                '}';
    }
}
