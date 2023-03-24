package com.classes.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListaAluno {

    // Instancia
    List<Aluno> lista = new ArrayList<Aluno>();

    // Get
    public List<Aluno> getLista() {
        return lista;
    }

    // Set
    public boolean insereAluno(Aluno aluno) {
        if (aluno != null) {
            lista.add(aluno);
            return true;
        }
        return false;
    }
}
