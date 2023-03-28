package com.classes.BO;

import com.classes.DAO.NotasDAO;
import com.classes.DTO.Notas;

public class NotasBO {

    public void inserir(Notas nota) {
        NotasDAO.insereNotas(nota);
    }

    public void remover(String matricula) {
        NotasDAO.deletarNotas(matricula);
    }

    public Notas buscar(String matricula) {
        return NotasDAO.buscarNotas(matricula);
    }

    public double media(String matricula) {
        Notas notas = NotasDAO.buscarNotas(matricula);
        return (notas.getNota1() + notas.getNota2() + notas.getNota3()) / 3;
    }
}
