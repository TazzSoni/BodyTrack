package com.example.bodytrack;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodytrack.Model.Atividade;

import java.util.List;

@Dao
public interface AtividadeDAO {
    @Query("SELECT * FROM atividade")
    List<Atividade> getAll();

    @Insert
    void insertAll(Atividade ... atividades);

    @Delete
    void delete(Atividade atividade);
}
