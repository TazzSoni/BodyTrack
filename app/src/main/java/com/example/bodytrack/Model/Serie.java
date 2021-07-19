package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Serie {

    @PrimaryKey
    private long id;

    @ColumnInfo (name = "repeticao")
    private int repeticao;

    @ColumnInfo (name = "peso")
    private int peso;

    public Serie(int repeticao, int peso) {
        this.repeticao = repeticao;
        this.peso = peso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
