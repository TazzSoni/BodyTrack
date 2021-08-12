package com.example.bodytrack.Model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bodytrack.DAO.AtividadeCrossRefDAO;
import com.example.bodytrack.DAO.AtividadeDAO;
import com.example.bodytrack.DAO.AtividadeSerieDAO;
import com.example.bodytrack.DAO.PessoaCrossRefDAO;
import com.example.bodytrack.DAO.PessoaDAO;
import com.example.bodytrack.DAO.PessoaSecaoDAO;
import com.example.bodytrack.DAO.PessoaTreinoDAO;
import com.example.bodytrack.DAO.SerieDAO;
import com.example.bodytrack.DAO.TreinoAtividadeDAO;
import com.example.bodytrack.DAO.TreinoCossRefDAO;
import com.example.bodytrack.DAO.TreinoDao;

@Database(entities = {Pessoa.class, Serie.class, Treino.class, Atividade.class, PessoaSecao.class,
        AtividadeSerieCrossRef.class, PessoaTreinoCrossRef.class, TreinoAtividadeCrossRef.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SerieDAO serieDao();

    public abstract PessoaDAO pessoaDao();

    public abstract PessoaCrossRefDAO pessoaCrossRefDAO();

    public abstract PessoaTreinoDAO pessoaTreinosDAO();

    public abstract PessoaSecaoDAO pessoaSecaoDAO();

    public abstract TreinoDao treinoDao();

    public abstract TreinoCossRefDAO treinoCrossRefDAO();

    public abstract TreinoAtividadeDAO treinoatividadesDAO();

    public abstract AtividadeDAO atividadeDAO();

    public abstract AtividadeCrossRefDAO atividadeCrossRefDAO();

    public abstract AtividadeSerieDAO atividadeSerieDAO();

}
