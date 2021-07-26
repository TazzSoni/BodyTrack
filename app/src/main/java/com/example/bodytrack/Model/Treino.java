package com.example.bodytrack.Model;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

=======
=======
>>>>>>> Stashed changes
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.List;

@Entity
public class Treino {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    @PrimaryKey (autoGenerate = true)
    @NotNull
    private long treinoId;
    private String nome;
=======
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nome")
    private String nome;
=======
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nome")
    private String nome;
>>>>>>> Stashed changes

    private List<Atividade> atividades = new ArrayList<>();
>>>>>>> Stashed changes

    @NotNull
    public long getTreinoId() {
        return treinoId;
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public void setTreinoId(@NotNull long treinoId) {
        this.treinoId = treinoId;
=======
=======
>>>>>>> Stashed changes
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
>>>>>>> Stashed changes
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Treino{" +
                "treinoId=" + treinoId +
                ", nome='" + nome + '\'' +
                '}';
    }
}
