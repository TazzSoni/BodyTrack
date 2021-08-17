package com.example.bodytrack.DAO;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Pessoa;
import com.example.bodytrack.Model.Serie;

import java.util.List;

@Dao
public interface SerieDAO {
    @Query("SELECT * FROM serie")
    List<Serie> getAll();

    @Query("SELECT * FROM serie where serieId = :serieId")
    Serie getOne(int serieId);

    @Query("SELECT * FROM serie where serieId in (SELECT serieId FROM atividadeseriecrossref where atividadeId = :atividadeId)")
    List<Serie> getSeriesAtividade(long atividadeId);

    @Insert()
    void insertAll(Serie... series);

    @Insert(onConflict = REPLACE)
    long insertOne(Serie serie);

    @Delete
    void delete(Serie serie);
}
