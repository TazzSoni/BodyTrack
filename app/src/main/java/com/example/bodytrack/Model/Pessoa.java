package com.example.bodytrack.Model;

public class Pessoa {

    private String nome;
    private String senha;

    public Pessoa(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome='" + nome + '\'' +
                ", Senha='" + senha + '\'' +
                '}';
    }
}
