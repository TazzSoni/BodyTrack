package com.example.bodytrack.Model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class PessoaTreinos {

    @Embedded
    public Pessoa pessoa;
    @Relation(
            parentColumn = "login",
            entityColumn = "treinoId",
            associateBy = @Junction(PessoaTreinoCrossRef.class)
    )
    public List<Treino> treinos;

    @Override
    public String toString() {
        return "PessoaTreinos{" +
                "pessoa=" + pessoa +
                ", treinos=" + treinos +
                '}';
    }
}
