package com.example.bodytrack;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodytrack.Model.Serie;

import java.util.List;

@Dao
public interface SerieDAO {
    @Query("SELECT * FROM serie")
    List<Serie> getAll();

    @Insert
    void insertAll(Serie ... series);

    @Delete
    void delete(Serie serie);
}
