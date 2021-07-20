package com.example.bodytrack.DAO;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bodytrack.Model.AtividadeSerie;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.Pessoa;

@Database(entities = {Pessoa.class, Serie.class, AtividadeSerie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SerieDAO serieDao();
    public abstract PessoaDAO pessoaDao();
    public abstract AtividadeSerieDAO atividadeSerieDao();
}
