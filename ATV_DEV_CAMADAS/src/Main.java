import com.classes.BO.AlunoBO;
import com.classes.DTO.Aluno;

public class Main {
    public static void main(String[] args) {
//        Aluno aluno = new Aluno();
//
//        aluno.setNome("Rafael");
//        aluno.setMatricula("123456");
//        aluno.setCurso("BCC");
//        aluno.setEmail("rafael@gmail.com");
//        aluno.setTelefone("123456789");
//        aluno.setNota1(10);
//        aluno.setNota2(10);
//        aluno.setNota3(9);
//
//        System.out.println(aluno);

        AlunoBO alunoBO = new AlunoBO();
//        alunoBO.inserir(aluno);

        System.out.println(alunoBO.listar());

        alunoBO.remover("123456");


    }
}