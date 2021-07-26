package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.TreinoAtividades;

import java.util.List;

@Dao
public interface TreinoAtividadeDAO {

    @Transaction
    @Query("SELECT * FROM Treino")
    public List<TreinoAtividades> getTreinoAtividades();

}
