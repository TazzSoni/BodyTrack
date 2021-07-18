package com.example.bodytrack.Model;

public class Serie {

    private long id;
    private int repeticao;
    private int peso;

    public Serie(int repeticao, int peso) {
        this.repeticao = repeticao;
        this.peso = peso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
