package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pessoa {

    @ColumnInfo (name = "nome")
    private String nome;

    @PrimaryKey
    private String login;

    @ColumnInfo (name = "senha")
    private String senha;

    @ColumnInfo (name = "peso")
    private double peso;

    @ColumnInfo (name = "altura")
    private double altura;

    public Pessoa(String nome,String login, String senha, double peso, double altura) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
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
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
