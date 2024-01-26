package controllers;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {

	public void cadastrarAluno() throws Exception {

		System.out.println("\nCadastro de Aluno:\n");

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		Aluno aluno = new Aluno(random.nextInt(Integer.MAX_VALUE));

		System.out.print("Informe o nome: ");
		aluno.setNome(scanner.nextLine());

		System.out.print("Informe a matrícula: ");
		aluno.setMatricula(scanner.nextLine());

		System.out.print("Informe o CPF: ");
		aluno.setCpf(scanner.nextLine());
		scanner.close();

		AlunoRepository alunoRepository = new AlunoRepository();

		alunoRepository.create(aluno);

		System.out.println("\nAluno cadastrado com sucesso!");
	}

	public void atualizarAluno() throws Exception {

		System.out.println("\nEdição de Aluno:\n");

		Scanner scanner = new Scanner(System.in);

		System.out.print("Informe o ID: ");
		Integer id = Integer.parseInt(scanner.nextLine());

		AlunoRepository alunoRepository = new AlunoRepository();
		Aluno aluno = alunoRepository.findbyId(id);

		if (aluno != null) {
			System.out.print("\nInforme o nome: ");
			aluno.setNome(scanner.nextLine());

			System.out.print("\nInforme a matrícula: ");
			aluno.setMatricula(scanner.nextLine());

			System.out.print("\nInforme o CPF: ");
			aluno.setCpf(scanner.nextLine());

			alunoRepository.update(aluno);

			System.out.println("\nAluno autalizado com sucesso!");
		} else
			System.out.println("\nAluno não encontrado. Verifique o ID.");

		scanner.close();
	}

	public void excluirAluno() throws Exception {

		System.out.println("\nExclusão de Aluno:\n");

		System.out.print("Informe o ID do Aluno: ");
		Scanner scanner = new Scanner(System.in);
		Integer id = Integer.parseInt(scanner.nextLine());

		AlunoRepository alunoRepository = new AlunoRepository();
		Aluno aluno = alunoRepository.findbyId(id);

		if (aluno != null) {
			alunoRepository.delete(aluno);
			System.out.println("\nAluno excluído com sucesso!");
		} else
			System.out.println("\nAluno não encontrado. Verifique o ID.");

		scanner.close();
	}

	public void consultarAlunos() throws Exception {

		System.out.println("\nConsulta de Alunos:\n");

		AlunoRepository alunoRepository = new AlunoRepository();
		List<Aluno> lista = alunoRepository.findAll();

		for (Aluno aluno : lista) {

			System.out.println("ID do Aluno: " + aluno.getIdAluno());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Matrícula: " + aluno.getMatricula());
			System.out.println("CPF: " + aluno.getCpf());
			System.out.println("...");
		}

	}
}
