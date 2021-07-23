package com.example.bodytrack.Model;

import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

@Entity(primaryKeys = {"login", "treinoId"})
public class PessoaTreinoCrossRef {

    @NotNull
    public String login;

    @NotNull
    public long treinoId;

    @NotNull
    public String getLogin() {
        return login;
    }

    public void setLogin( @NotNull String login) {
        this.login = login;
    }

    @NotNull
    public long getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(@NotNull long treinoId) {
        this.treinoId = treinoId;
    }
}
