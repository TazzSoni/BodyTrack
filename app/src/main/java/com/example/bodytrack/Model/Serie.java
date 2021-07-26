package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity
public class Serie {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    @PrimaryKey (autoGenerate = true)
    private long numSerie;

    private int repeticao;

=======
=======
>>>>>>> Stashed changes
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "repeticao")
    private int repeticao;

    @ColumnInfo(name = "peso")
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    private int peso;

    public Serie() {
    }

    public long getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(long numSerie) {
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
