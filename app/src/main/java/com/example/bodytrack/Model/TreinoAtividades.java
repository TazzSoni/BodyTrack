package com.example.bodytrack.Model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class TreinoAtividades {

    @Embedded
    public Treino treino;
    @Relation(
            parentColumn = "aitividadeId",
            entityColumn = "treinoId",
            associateBy = @Junction(TreinoAtividadeCrossRef.class)
    )
    public List<Atividade> atividades;

    @Override
    public String toString() {
        return "TreinoAtividade{" +
                "treino=" + treino +
                ", atividades=" + atividades +
                '}';
    }
}
