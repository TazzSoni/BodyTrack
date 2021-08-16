package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Serie;

import java.util.List;

@Dao
public interface AtividadeDAO {
    @Query("SELECT * FROM atividade")
    List<Atividade> getAll();

    @Query("SELECT * FROM atividade where atividadeId in (SELECT atividadeId FROM treinoatividadecrossref where treinoId = :treinoId)")
    List<Atividade> getAtividadesTreino(long treinoId);

    @Query("SELECT * FROM atividade where atividadeId = :atividadeId")
    Atividade getOne(long atividadeId);

    @Insert
    long insertAll(Atividade atividade);

    @Delete
    void delete(Atividade atividade);
}
