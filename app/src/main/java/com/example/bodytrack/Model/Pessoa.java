package com.example.bodytrack.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Pessoa {


    @ColumnInfo(name = "nome")
    private String nome;

    @PrimaryKey
    @NotNull
    private String login;

    @ColumnInfo(name = "senha")
    private String senha;

    @ColumnInfo(name = "peso")
    private double peso;

    @ColumnInfo(name = "altura")
    private double altura;

    public Pessoa() {

    }

    public Pessoa(String nome, String login, String senha, double peso, double altura) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.peso = peso;
        this.altura = altura;
    }

    @NotNull
    public String getLogin() {
        return login;
    }

    public void setLogin(@NotNull String login) {
        this.login = login;
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

    public boolean verificarPeso() {

        if (this.getPeso() < 300) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarAltura() {

        if (this.getAltura() < 2.30) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificaNome() {

        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(this.getNome());
        // boolean b = m.matches();
        boolean b = m.find();
        if (b == true) {
            //System.out.println("There is a special character in my string ");
            return false;
        } else {
            //System.out.println("There is no special char.");
            return true;
        }
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
