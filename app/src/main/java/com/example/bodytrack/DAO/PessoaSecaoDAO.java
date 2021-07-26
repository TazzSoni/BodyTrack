package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodytrack.Model.PessoaSecao;

import java.util.List;

@Dao
public interface PessoaSecaoDAO {
    @Query("SELECT * FROM PessoaSecao")
    PessoaSecao getAll();

    @Query("SELECT * FROM PessoaSecao")
    List<PessoaSecao> getList();

    @Insert
    void insertAll(PessoaSecao... pessoaSecao);

    @Delete
    void delete(PessoaSecao pessoaSecao);
}
