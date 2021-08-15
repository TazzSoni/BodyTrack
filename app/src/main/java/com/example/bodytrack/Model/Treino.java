package com.example.bodytrack.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Treino {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    private long treinoId;

    private String nome;

    @NotNull
    public long getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(@NotNull long treinoId) {
        this.treinoId = treinoId;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ViewTreino{" +
                "treinoId=" + treinoId +
                ", nome='" + nome + '\'' +
                '}';
    }
}
