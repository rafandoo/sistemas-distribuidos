package com.classes.DTO;

public class Pessoa {

    // Atributos
    private String nome;

    // Construtor
    public Pessoa() {

    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pessoa [nome=");
        builder.append(nome);
        builder.append("]");
        return builder.toString();
    }
}
