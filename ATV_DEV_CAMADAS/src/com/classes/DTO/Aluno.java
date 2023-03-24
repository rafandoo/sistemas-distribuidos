package com.classes.DTO;

public class Aluno extends Pessoa {

    // Atributos
    private String matricula;
    private String curso;
    private String email;
    private String telefone;
    private double nota1;
    private double nota2;
    private double nota3;

    // Construtores
    public Aluno() {

    }
    public Aluno(String nome) {
        super(nome);
    }

    public Aluno(String nome, String matricula, String curso, String email, String telefone, float nota1, float nota2, float nota3) {
        super(nome);
        this.matricula = matricula;
        this.curso = curso;
        this.email = email;
        this.telefone = telefone;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        if (curso.length() > 0) {
            this.curso = curso;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.length() > 0) {
            this.email = email;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone.length() > 0) {
            this.telefone = telefone;
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

    // toString
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Aluno [matricula=");
        builder.append(matricula);
        builder.append(", nome=");
        builder.append(getNome());
        builder.append(", curso=");
        builder.append(curso);
        builder.append(", email=");
        builder.append(email);
        builder.append(", telefone=");
        builder.append(telefone);
        builder.append(", nota1=");
        builder.append(nota1);
        builder.append(", nota2=");
        builder.append(nota2);
        builder.append(", nota3=");
        builder.append(nota3);
        builder.append("]");
        return builder.toString();
    }
}
