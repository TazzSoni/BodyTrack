package com.example.bodytrack;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bodytrack.Model.Serie;

@Database(entities = {Serie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SerieDAO serieDao();
}
