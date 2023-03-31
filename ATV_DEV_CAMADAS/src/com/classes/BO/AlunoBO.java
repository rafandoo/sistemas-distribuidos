package com.classes.BO;

import com.classes.DAO.AlunoDAO;
import com.classes.DTO.AlunoDTO;

import java.util.List;

public class AlunoBO {

    public void inserir(AlunoDTO alunoDTO) {
        AlunoDAO.insereAluno(alunoDTO);
    }

    public void remover(String matricula) {
        AlunoDAO.removeAluno(matricula);
    }

    public List<AlunoDTO> listar() {
        return AlunoDAO.listarAlunos();
    }

    public AlunoDTO buscar(String matricula) {
        return AlunoDAO.buscarAluno(matricula);
    }
}
