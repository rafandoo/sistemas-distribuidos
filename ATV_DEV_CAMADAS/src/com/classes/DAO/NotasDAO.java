package com.classes.DAO;

import com.classes.DTO.Notas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class NotasDAO {

    // Atributos
    final static String NOME_ARQUIVO = "notas.txt";

    // Instancia
    static FileWriter arquivo;
    static PrintWriter gravarArquivo;

    // Metodos
    public static void insereNotas(Notas nota) {
        if (nota != null) {
            try {
                arquivo = new FileWriter(NOME_ARQUIVO, true);
                gravarArquivo = new PrintWriter(arquivo);
                gravarArquivo.println(
                        nota.getMatricula() + ";"
                        + nota.getNota1() + ";"
                        + nota.getNota2() + ";"
                        + nota.getNota3()
                );
                arquivo.close();
            } catch (Exception e) {
                System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
            }
        }
    }

    public static void deletarNotas(String matricula) {
        if (matricula != null) {
            try {
                List<Notas> notas = listarNotas();
                arquivo = new FileWriter(NOME_ARQUIVO);
                gravarArquivo = new PrintWriter(arquivo);
                assert notas != null;
                for (Notas nota : notas) {
                    if (!nota.getMatricula().equals(matricula)) {
                        gravarArquivo.println(
                                nota.getMatricula() + ";"
                                + nota.getNota1() + ";"
                                + nota.getNota2() + ";"
                                + nota.getNota3()
                        );
                    }
                }
                arquivo.close();
            } catch (Exception e) {
                System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
            }
        }
    }

    public static List<Notas> listarNotas() {
        List<Notas> notas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Notas nota = new Notas();
                nota.setMatricula(dados[0]);
                nota.setNota1(Double.parseDouble(dados[1]));
                nota.setNota2(Double.parseDouble(dados[2]));
                nota.setNota3(Double.parseDouble(dados[3]));
                notas.add(nota);
            }
            return notas;
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

    public static Notas buscarNotas(String matricula) {
        if (matricula != null) {
            try {
                List<Notas> notas = listarNotas();
                assert notas != null;
                for (Notas nota : notas) {
                    if (nota.getMatricula().equals(matricula)) {
                        return nota;
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
            }
        }
        return null;
    }
}
