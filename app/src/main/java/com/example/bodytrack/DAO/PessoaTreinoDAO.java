package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bodytrack.Model.PessoaTreinos;

import java.util.List;

@Dao
public interface PessoaTreinoDAO {

    @Transaction
    @Query("SELECT * FROM Pessoa")
    public List<PessoaTreinos> getPessoaTreinos();
}
