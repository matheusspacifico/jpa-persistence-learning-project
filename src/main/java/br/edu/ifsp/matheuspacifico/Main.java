package br.edu.ifsp.matheuspacifico;

import br.edu.ifsp.matheuspacifico.dao.AlunoDao;
import br.edu.ifsp.matheuspacifico.model.Aluno;
import br.edu.ifsp.matheuspacifico.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao dao = new AlunoDao(em);

        while (true) {
            System.out.println("\n\n** CADASTRO DE ALUNOS **\n");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Excluir aluno");
            System.out.println("3 - Alterar aluno");
            System.out.println("4 - Buscar aluno pelo nome");
            System.out.println("5 - Listar alunos (com status aprovação)");
            System.out.println("6 - FIM\n");

            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner, dao, em);
                    break;
                case 2:
                    excluirAluno(scanner, dao, em);
                    break;
                case 3:
                    alterarAluno(scanner, dao, em);
                    break;
                case 4:
                    buscarAlunoPorNome(scanner, dao);
                    break;
                case 5:
                    listarAlunos(dao);
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    em.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarAluno(Scanner scanner, AlunoDao dao, EntityManager em) {
        System.out.println("CADASTRO DE ALUNO:");
        Aluno aluno = new Aluno();

        System.out.print("Digite o nome: ");
        aluno.setNome(scanner.nextLine());

        System.out.print("Digite o RA: ");
        aluno.setRa(scanner.nextLine());

        System.out.print("Digite o email: ");
        aluno.setEmail(scanner.nextLine());

        System.out.print("Digite a nota 1: ");
        aluno.setNota1(scanner.nextBigDecimal());

        System.out.print("Digite a nota 2: ");
        aluno.setNota2(scanner.nextBigDecimal());

        System.out.print("Digite a nota 3: ");
        aluno.setNota3(scanner.nextBigDecimal());

        em.getTransaction().begin();
        dao.cadastrar(aluno);
        em.getTransaction().commit();

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void excluirAluno(Scanner scanner, AlunoDao dao, EntityManager em) {
        System.out.println("EXCLUIR ALUNO:");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        Aluno aluno = dao.buscarPorNome(nome);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        em.getTransaction().begin();
        dao.excluir(aluno);
        em.getTransaction().commit();
        System.out.println("Aluno removido com sucesso!");
    }

    private static void alterarAluno(Scanner scanner, AlunoDao dao, EntityManager em) {
        System.out.println("ALTERAR ALUNO:");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        Aluno aluno = dao.buscarPorNome(nome);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        System.out.println(aluno.toString());

        System.out.println("NOVOS DADOS:");
        System.out.print("Digite o nome: ");
        aluno.setNome(scanner.nextLine());

        System.out.print("Digite o RA: ");
        aluno.setRa(scanner.nextLine());

        System.out.print("Digite o email: ");
        aluno.setEmail(scanner.nextLine());

        System.out.print("Digite a nota 1: ");
        aluno.setNota1(scanner.nextBigDecimal());

        System.out.print("Digite a nota 2: ");
        aluno.setNota2(scanner.nextBigDecimal());

        System.out.print("Digite a nota 3: ");
        aluno.setNota3(scanner.nextBigDecimal());

        em.getTransaction().begin();
        dao.alterar(aluno);
        em.getTransaction().commit();
        System.out.println("Aluno alterado com sucesso!");
    }
}