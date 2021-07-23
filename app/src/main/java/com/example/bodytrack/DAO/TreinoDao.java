package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodytrack.Model.Treino;

import java.util.List;

@Dao
public interface TreinoDao {
    @Query("SELECT * FROM treino")
    List<Treino> getAll();

    @Insert
    void insertAll(Treino... treino);

    @Delete
    void delete(Treino treino);
}
