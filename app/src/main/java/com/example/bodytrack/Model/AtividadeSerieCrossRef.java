package com.example.bodytrack.Model;

import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

@Entity(primaryKeys = {"atividadeId", "serieId"})
public class AtividadeSerieCrossRef {

    @NotNull
    public long atividadeId;

    @NotNull
    public long serieId;

    @NotNull
    public long getAtividadeId() {
        return atividadeId;
    }
    
    public void setAtividadeId( @NotNull long atividadeId) {
        this.atividadeId = atividadeId;
    }

    @NotNull
    public long getSerieId() {
        return serieId;
    }

    public void setSerieId(@NotNull long serieId) {
        this.serieId = serieId;
    }
}
