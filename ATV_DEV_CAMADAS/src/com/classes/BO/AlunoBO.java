package com.classes.BO;

import com.classes.DAO.AlunoDAO;
import com.classes.DTO.Aluno;

import java.util.List;

public class AlunoBO {

    public void inserir (Aluno aluno) {
        if (aluno != null) {
            try {
                AlunoDAO.insereAluno(aluno);
            } catch (Exception e) {
                System.out.println("Erro ao inserir aluno: " + e.getMessage());
            }
        }
    }

    public void remover (String matricula) {
        if (matricula != null) {
            try {
                AlunoDAO.removeAluno(matricula);
            } catch (Exception e) {
                System.out.println("Erro ao remover aluno: " + e.getMessage());
            }
        }
    }

    public List<Aluno> listar() {
        try {
            return AlunoDAO.listarAlunos();
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
            return null;
        }
    }
}
