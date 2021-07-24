package com.example.bodytrack.Model;

import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

@Entity(primaryKeys = {"atividadeId", "treinoId"})
public class TreinoAtividadeCrossRef {

    @NotNull
    public long atividadeId;

    @NotNull
    public long treinoId;

    @NotNull
    public long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId( @NotNull long atividadeId) {
        this.atividadeId = atividadeId;
    }

    @NotNull
    public long getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(@NotNull long treinoId) {
        this.treinoId = treinoId;
    }
}
