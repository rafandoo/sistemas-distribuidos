package com.classes.DAO;

import com.classes.DTO.AlunoDTO;

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
    public static void insereAluno(AlunoDTO alunoDTO) {
        if (alunoDTO != null) {
            try {
                arquivo = new FileWriter(NOME_ARQUIVO, true);
                gravarArquivo = new PrintWriter(arquivo);
                gravarArquivo.println(
                        alunoDTO.getMatricula() + ";"
                        + alunoDTO.getNome() + ";"
                        + alunoDTO.getCurso() + ";"
                        + alunoDTO.getEmail() + ";"
                        + alunoDTO.getTelefone()
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
                List<AlunoDTO> alunoDTOS = listarAlunos();
                arquivo = new FileWriter(NOME_ARQUIVO);
                gravarArquivo = new PrintWriter(arquivo);
                assert alunoDTOS != null;
                for (AlunoDTO alunoDTO : alunoDTOS) {
                    if (!alunoDTO.getMatricula().equals(matricula)) {
                        gravarArquivo.println(
                                alunoDTO.getMatricula() + ";"
                                + alunoDTO.getNome() + ";"
                                + alunoDTO.getCurso() + ";"
                                + alunoDTO.getEmail() + ";"
                                + alunoDTO.getTelefone()
                        );
                    }
                }
                arquivo.close();
            } catch (Exception e) {
                System.out.println("Erro ao remover aluno: " + e.getMessage());
            }
        }
    }

    public static List<AlunoDTO> listarAlunos() {
        List<AlunoDTO> alunoDTOS = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                AlunoDTO alunoDTO = new AlunoDTO();
                alunoDTO.setMatricula(dados[0]);
                alunoDTO.setNome(dados[1]);
                alunoDTO.setCurso(dados[2]);
                alunoDTO.setEmail(dados[3]);
                alunoDTO.setTelefone(dados[4]);
                alunoDTOS.add(alunoDTO);
                linha = br.readLine();
            }
            return alunoDTOS;
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
            return null;
        }
    }

    public static AlunoDTO buscarAluno(String matricula) {
        if (matricula != null) {
            try {
                List<AlunoDTO> alunoDTOS = listarAlunos();
                assert alunoDTOS != null;
                for (AlunoDTO alunoDTO : alunoDTOS) {
                    if (alunoDTO.getMatricula().equals(matricula)) {
                        return alunoDTO;
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
}