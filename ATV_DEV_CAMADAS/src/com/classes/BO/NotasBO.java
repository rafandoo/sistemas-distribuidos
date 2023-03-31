package com.classes.BO;

import com.classes.DAO.NotasDAO;
import com.classes.DTO.NotasDTO;

public class NotasBO {

    public void inserir(NotasDTO nota) {
        NotasDAO.insereNotas(nota);
    }

    public void remover(String matricula) {
        NotasDAO.deletarNotas(matricula);
    }

    public NotasDTO buscar(String matricula) {
        return NotasDAO.buscarNotas(matricula);
    }

    public double media(String matricula) {
        NotasDTO notasDTO = NotasDAO.buscarNotas(matricula);
        return (notasDTO.getNota1() + notasDTO.getNota2() + notasDTO.getNota3()) / 3;
    }
}
