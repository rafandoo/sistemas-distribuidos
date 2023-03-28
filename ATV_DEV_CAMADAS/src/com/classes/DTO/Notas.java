package com.classes.DTO;

public class Notas {

    // Atributos
    private String matricula;
    private double nota1;
    private double nota2;
    private double nota3;

    // Construtores
    public Notas() {
    }

    public Notas(String matricula, double nota1, double nota2, double nota3) {
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula.length() > 0) {
            this.matricula = matricula;
        }
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        if (nota1 > 0) {
            this.nota1 = nota1;
        }
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        if (nota2 > 0) {
            this.nota2 = nota2;
        }
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        if (nota3 > 0) {
            this.nota3 = nota3;
        }
    }

    // to String
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Notas{matricula=").append(matricula);
        builder.append(", nota1=").append(nota1);
        builder.append(", nota2=").append(nota2);
        builder.append(", nota3=").append(nota3);
        builder.append('}');
        return builder.toString();
    }
}