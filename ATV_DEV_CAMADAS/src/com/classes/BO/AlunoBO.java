package com.classes.BO;

import com.classes.DAO.AlunoDAO;
import com.classes.DTO.Aluno;

import java.util.List;

public class AlunoBO {

    public void inserir(Aluno aluno) {
        AlunoDAO.insereAluno(aluno);
    }

    public void remover(String matricula) {
        AlunoDAO.removeAluno(matricula);
    }

    public List<Aluno> listar() {
        return AlunoDAO.listarAlunos();
    }

    public Aluno buscar(String matricula) {
        return AlunoDAO.buscarAluno(matricula);
    }
}
