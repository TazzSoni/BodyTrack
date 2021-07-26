package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bodytrack.Model.AtividadeSeries;

import java.util.List;

@Dao
public interface AtividadeSerieDAO {

    @Transaction
    @Query("SELECT * FROM Atividade")
    public List<AtividadeSeries> getAtividadeSeries();
}
