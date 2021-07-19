package com.example.bodytrack.Model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class AtividadeSerie {

    @Embedded
    public Atividade atividade;
    @Relation(
            parentColumn = "id",
            entityColumn = "atividadeId",
            entity = Serie.class
    )
    private List<Serie> series ;

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
