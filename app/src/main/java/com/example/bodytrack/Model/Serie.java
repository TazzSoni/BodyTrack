package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Serie {

    @PrimaryKey (autoGenerate = true)
    private int numSerie;

    @ColumnInfo (name = "repeticao")
    private int repeticao;

    @ColumnInfo (name = "peso")
    private int peso;

    public Serie(int numSerie, int repeticao, int peso) {
        this.repeticao = repeticao;
        this.peso = peso;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
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
