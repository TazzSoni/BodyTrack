package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.AtividadeSerie;

import java.util.List;

@Dao
public interface AtividadeDAO {
    @Query("SELECT * FROM atividade")
    List<Atividade> getAll();

    @Transaction
    @Query("SELECT * FROM atividade")
    List<AtividadeSerie> getAtividadeComSeries();

    @Insert
    void insertAll(Atividade ... atividades);

    @Delete
    void delete(Atividade atividade);
}
