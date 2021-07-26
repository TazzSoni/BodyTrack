package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
public class Atividade {

    @PrimaryKey
    @NotNull
    private long atividadeId;

    @ColumnInfo(name = "nome")
    private String nome;

    @NotNull
    public long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(@NotNull long atividadeId) {
        this.atividadeId = atividadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
