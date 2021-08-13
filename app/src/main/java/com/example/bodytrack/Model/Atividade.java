package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Atividade {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    private int atividadeId;

    @ColumnInfo(name = "nome")
    private String nome;

    @NotNull
    public int getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(@NotNull int atividadeId) {
        this.atividadeId = atividadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
