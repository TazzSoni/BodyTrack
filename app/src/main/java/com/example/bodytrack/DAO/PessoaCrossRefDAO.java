package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.bodytrack.Model.PessoaTreinoCrossRef;

@Dao
public interface PessoaCrossRefDAO {

    @Insert
    void insertAll(PessoaTreinoCrossRef... pessoaTreinoCrossRef);
}
