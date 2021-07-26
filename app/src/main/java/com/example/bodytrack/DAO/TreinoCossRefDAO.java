package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.bodytrack.Model.TreinoAtividadeCrossRef;

@Dao
public interface TreinoCossRefDAO {
    @Insert
    void insertAll(TreinoAtividadeCrossRef... treinoAtividadeCrossRef);
}
