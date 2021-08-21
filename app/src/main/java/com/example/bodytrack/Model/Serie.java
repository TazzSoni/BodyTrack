package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

import org.jetbrains.annotations.NotNull;

@Entity
public class Serie {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    private int serieId;

    private int numSerie;

    private int repeticao;

    private int peso;

    private String checked = "-";

    public Serie() {
    }

    @NotNull
    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(@NotNull int serieId) {
        this.serieId = serieId;
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

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
