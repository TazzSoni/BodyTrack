package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.AtividadeSeries;
import com.example.bodytrack.Model.Serie;

import java.util.List;

@Dao
public interface AtividadeSerieDAO {

    @Transaction
    @Query("SELECT * FROM Atividade")
    public List<AtividadeSeries> getAtividadeSeries();

    @Transaction
    @Query("SELECT * FROM serie where serieId = (select serieId from atividadeseriecrossref )")
    public List<Serie> getSeriesAtividade();
}
