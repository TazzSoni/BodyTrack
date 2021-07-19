package com.example.bodytrack.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bodytrack.Model.AtividadeSerie;

import java.util.List;

public interface AtividadeSerieDAO {

    @Transaction
    @Query("SELECT * FROM atividade")
    List<AtividadeSerie> getAtividadeComSeries();

    @Insert
    void insertAll(AtividadeSerie... AtividadeSerie);

    @Delete
    void delete(AtividadeSerie AtividadeSerie);

}
