package com.classes;

import com.classes.BO.AlunoBO;
import com.classes.BO.NotasBO;
import com.classes.DTO.AlunoDTO;
import com.classes.DTO.NotasDTO;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

    // Menus
    private static int menuPrincipal() {
        System.out.println("1 - Aluno");
        System.out.println("2 - Lancar notas");
        System.out.println("3 - Sair");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int menuAluno() {
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Listar");
        System.out.println("4 - Buscar");
        System.out.println("5 - Voltar");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int menuNotas() {
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Buscar");
        System.out.println("4 - Media");
        System.out.println("5 - Voltar");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    // Metodos
    private static void inserirAluno() {
        AlunoDTO alunoDTO = new AlunoDTO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome: ");
        alunoDTO.setNome(sc.nextLine());
        System.out.println("Matricula: ");
        alunoDTO.setMatricula(sc.nextLine());
        System.out.println("Curso: ");
        alunoDTO.setCurso(sc.nextLine());
        System.out.println("Email: ");
        alunoDTO.setEmail(sc.nextLine());
        System.out.println("Telefone: ");
        alunoDTO.setTelefone(sc.nextLine());

        AlunoBO alunoBO = new AlunoBO();
        alunoBO.inserir(alunoDTO);
    }

    private static void removerAluno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = sc.nextLine();

        AlunoBO alunoBO = new AlunoBO();
        alunoBO.remover(matricula);
    }

    private static void listarAluno() {
        AlunoBO alunoBO = new AlunoBO();
        System.out.println(alunoBO.listar());
    }

    private static void buscarAluno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = sc.nextLine();

        AlunoBO alunoBO = new AlunoBO();
        System.out.println(alunoBO.buscar(matricula));
    }

    private static void inserirNota() {
        NotasDTO nota = new NotasDTO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Matricula: ");
        nota.setMatricula(sc.nextLine());
        System.out.println("Nota 1: ");
        nota.setNota1(sc.nextDouble());
        System.out.println("Nota 2: ");
        nota.setNota2(sc.nextDouble());
        System.out.println("Nota 3: ");
        nota.setNota3(sc.nextDouble());

        NotasBO notasBO = new NotasBO();
        notasBO.inserir(nota);
    }

    private static void removerNota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = sc.nextLine();

        NotasBO notasBO = new NotasBO();
        notasBO.remover(matricula);
    }

    private static void buscarNota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = sc.nextLine();

        NotasBO notasBO = new NotasBO();
        System.out.println(notasBO.buscar(matricula));
    }

    private static void media() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = sc.nextLine();

        NotasBO notasBO = new NotasBO();
        System.out.println(notasBO.media(matricula));
    }

    private static void processar(int opcao) throws InterruptedException {
        int PERMISSOES = 1;
        Semaphore semaforo = new Semaphore(PERMISSOES);

        semaforo.acquire();
        switch (opcao) {
            case 1 -> {
                System.out.println("Inserir");
                inserirAluno();
            }
            case 2 -> {
                System.out.println("Remover");
                removerAluno();
            }
            case 3 -> {
                System.out.println("Listar");
                listarAluno();
            }
            case 4 -> {
                System.out.println("Buscar");
                buscarAluno();
            }
            case 5 -> System.out.println("Voltar");
            case 10 -> {
                System.out.println("Inserir");
                inserirNota();
            }
            case 20 -> {
                System.out.println("Remover");
                removerNota();
            }
            case 30 -> {
                System.out.println("Buscar");
                buscarNota();
            }
            case 40 -> {
                System.out.println("Media");
                media();
            }
            case 50 -> System.out.println("Voltar");
            default -> System.out.println("Opção inválida");
        }
        semaforo.release();
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            int opcao = menuPrincipal();
            int opcao2;

            switch (opcao) {
                case 1 -> {
                    opcao2 = menuAluno();
                    processar(opcao2);
                }
                case 2 -> {
                    opcao2 = menuNotas();
                    opcao2 = opcao2 * 10;
                    processar(opcao2);
                }
                case 3 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }
    }
}
