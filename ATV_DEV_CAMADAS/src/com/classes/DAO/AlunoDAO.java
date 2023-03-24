package com.classes.DAO;

import com.classes.DTO.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // Atributos
    final static String NOME_ARQUIVO = "alunos.txt";

    // Instancia
    static FileWriter arquivo;
    static PrintWriter gravarArquivo;

    // Metodos
    public static void insereAluno(Aluno aluno) {
        if (aluno != null) {
            try {
                arquivo = new FileWriter(NOME_ARQUIVO, true);
                gravarArquivo = new PrintWriter(arquivo);
                gravarArquivo.println(
                        aluno.getMatricula() + ";"
                        + aluno.getNome() + ";"
                        + aluno.getCurso() + ";"
                        + aluno.getEmail() + ";"
                        + aluno.getTelefone() + ";"
                        + aluno.getNota1() + ";"
                        + aluno.getNota2() + ";"
                        + aluno.getNota3()
                );

                arquivo.close();
            } catch (Exception e) {
                System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
            }
        }
    }

    public static void removeAluno(String matricula) {
        if (matricula != null) {
            try {
                List<Aluno> alunos = listarAlunos();
                arquivo = new FileWriter(NOME_ARQUIVO);
                gravarArquivo = new PrintWriter(arquivo);
                assert alunos != null;
                for (Aluno aluno : alunos) {
                    if (!aluno.getMatricula().equals(matricula)) {
                        gravarArquivo.println(
                                aluno.getMatricula() + ";"
                                + aluno.getNome() + ";"
                                + aluno.getCurso() + ";"
                                + aluno.getEmail() + ";"
                                + aluno.getTelefone() + ";"
                                + aluno.getNota1() + ";"
                                + aluno.getNota2() + ";"
                                + aluno.getNota3()
                        );
                    }
                }
                arquivo.close();
            } catch (Exception e) {
                System.out.println("Erro ao remover aluno: " + e.getMessage());
            }
        }
    }

    public static List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                Aluno aluno = new Aluno();
                aluno.setMatricula(dados[0]);
                aluno.setNome(dados[1]);
                aluno.setCurso(dados[2]);
                aluno.setEmail(dados[3]);
                aluno.setTelefone(dados[4]);
                aluno.setNota1(Float.parseFloat(dados[5]));
                aluno.setNota2(Float.parseFloat(dados[6]));
                aluno.setNota3(Float.parseFloat(dados[7]));
                alunos.add(aluno);
                linha = br.readLine();
            }
            return alunos;
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
            return null;
        }
    }

    public static Aluno buscarAluno(String matricula) {
        if (matricula != null) {
            try {
                List<Aluno> alunos = listarAlunos();
                assert alunos != null;
                for (Aluno aluno : alunos) {
                    if (aluno.getMatricula().equals(matricula)) {
                        return aluno;
                    }
                }
                return null;
            } catch (Exception e) {
                System.out.println("Erro ao buscar aluno: " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static double mediaAluno(Aluno aluno) {
        return (aluno.getNota1() + aluno.getNota2() + aluno.getNota3()) / 3;
    }
}
