package com.example.bodytrack.Model;

import java.util.ArrayList;
import java.util.List;

public class Treino {

    private String nome;
    private List<Atividade> atividades = new ArrayList<>();

    public Treino(String nome) {
        this.nome = nome;
    }

    public void addAtividade(Atividade atividade){
        this.atividades.add(atividade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}
