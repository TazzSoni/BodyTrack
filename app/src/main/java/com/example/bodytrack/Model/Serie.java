package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {@ForeignKey(entity = Atividade.class,
        parentColumns = "id",
        childColumns = "atividadeId",
        onDelete = ForeignKey.CASCADE)
})
public class Serie {

    @PrimaryKey (autoGenerate = true)
    private long numSerie;

    private int repeticao;

    private int peso;

    @ColumnInfo(index = true)
    private Atividade atividade;

    @Ignore
    public Serie(int repeticao, int peso, Atividade atividade) {
        super();
        this.repeticao = repeticao;
        this.peso = peso;
        this.atividade = atividade;
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
