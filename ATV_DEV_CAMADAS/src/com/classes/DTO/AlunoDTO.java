package com.classes.DTO;

public class AlunoDTO {

    // Atributos
    private String matricula;
    private String nome;
    private String curso;
    private String email;
    private String telefone;

    // Construtores
    public AlunoDTO() {
    }

    public AlunoDTO(String nome, String matricula, String curso, String email, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.email = email;
        this.telefone = telefone;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
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

    // toString
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Aluno [matricula=");
        builder.append(matricula);
        builder.append(", nome=");
        builder.append(nome);
        builder.append(", curso=");
        builder.append(curso);
        builder.append(", email=");
        builder.append(email);
        builder.append(", telefone=");
        builder.append(telefone);
        builder.append("]");
        return builder.toString();
    }
}
