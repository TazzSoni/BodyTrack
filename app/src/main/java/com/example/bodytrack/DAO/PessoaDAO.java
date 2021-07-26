package com.example.bodytrack.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodytrack.Model.Pessoa;

import java.util.List;

@Dao
public interface PessoaDAO {
    @Query("SELECT * FROM pessoa")
    List<Pessoa> getAll();

    @Query("SELECT * FROM pessoa where login = :login")
    Pessoa getOne(String login);

    @Insert
    void insertAll(Pessoa... pessoas);

    @Delete
    void delete(Pessoa pessoa);
}
