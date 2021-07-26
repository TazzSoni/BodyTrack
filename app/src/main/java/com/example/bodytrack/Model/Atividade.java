package com.example.bodytrack.Model;

<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import java.util.List;

<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Atividade {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nome")
    private String nome;

<<<<<<< Updated upstream
=======
    private List<Serie> series = new ArrayList<>();

    public Atividade(String nome) {
        this.nome = nome;
    }

    public void addSerie(Serie serie) {
        this.series.add(serie);
    }

>>>>>>> Stashed changes
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
