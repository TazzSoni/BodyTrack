package com.example.bodytrack.Model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bodytrack.DAO.PessoaCrossRefDAO;
import com.example.bodytrack.DAO.PessoaDAO;
import com.example.bodytrack.DAO.PessoaTreinoDAO;
import com.example.bodytrack.DAO.SerieDAO;
import com.example.bodytrack.DAO.TreinoDao;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.Pessoa;

@Database(entities = {Pessoa.class, Serie.class, Treino.class, PessoaTreinoCrossRef.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SerieDAO serieDao();
    public abstract PessoaDAO pessoaDao();
    public abstract TreinoDao treinoDao();
    public abstract PessoaCrossRefDAO pessoaCrossRefDAO();
    public abstract PessoaTreinoDAO pessoaTreinosDAO();
}
