package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.bodytrack.Model.AtividadeSerieCrossRef;

@Dao
public interface AtividadeCrossRefDAO {
    @Insert
    void insertAll(AtividadeSerieCrossRef... AtividadeSerieCrossRef);
}
