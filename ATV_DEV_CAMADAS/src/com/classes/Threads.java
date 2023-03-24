package com.classes;

import com.classes.BO.AlunoBO;
import com.classes.DTO.Aluno;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Threads extends Thread {
    private Semaphore semaforo;

    public Threads(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    private void menu() {
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Listar");
        System.out.println("4 - Buscar");
        System.out.println("5 - Media");
        System.out.println("6 - Sair");
    }

    private void inserir() {
        Aluno aluno = new Aluno();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome: ");
        aluno.setNome(sc.nextLine());
        System.out.println("Matricula: ");
        aluno.setMatricula(sc.nextLine());
        System.out.println("Curso: ");
        aluno.setCurso(sc.nextLine());
        System.out.println("Email: ");
        aluno.setEmail(sc.nextLine());
        System.out.println("Telefone: ");
        aluno.setTelefone(sc.nextLine());
        System.out.println("Nota 1: ");
        aluno.setNota1(sc.nextDouble());
        System.out.println("Nota 2: ");
        aluno.setNota2(sc.nextDouble());
        System.out.println("Nota 3: ");
        aluno.setNota3(sc.nextDouble());

        AlunoBO alunoBO = new AlunoBO();
        alunoBO.inserir(aluno);
    }

    private void remover() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = sc.nextLine();

        AlunoBO alunoBO = new AlunoBO();
        alunoBO.remover(matricula);
    }

    private void listar() {
        AlunoBO alunoBO = new AlunoBO();
        System.out.println(alunoBO.listar());
    }

    private void buscar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = sc.nextLine();

        AlunoBO alunoBO = new AlunoBO();
        System.out.println(alunoBO.buscar(matricula));
    }

    private void media() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = sc.nextLine();

        AlunoBO alunoBO = new AlunoBO();
        System.out.println(alunoBO.media(matricula));
    }

    private int escolher() {
        menu();
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    private void processar() {
        int opcao = escolher();

        switch (opcao) {
            case 1:
                System.out.println("Inserir");
                inserir();
                break;
            case 2:
                System.out.println("Remover");
                remover();
                break;
            case 3:
                System.out.println("Listar");
                listar();
                break;
            case 4:
                System.out.println("Buscar");
                buscar();
                break;
            case 5:
                System.out.println("Media");
                media();
                break;
            case 6:
                System.out.println("Sair");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public void run() {
        try {
            semaforo.acquire();
            processar();
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
        } finally {
            semaforo.release();
        }
    }

    public static void main(String[] args) {
        int numeroPermissoes = 1;

        Semaphore semaforo = new Semaphore(numeroPermissoes);

        while (true) {
            new Threads(semaforo).start();
        }
    }
}
