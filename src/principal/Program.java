package principal;

import java.util.Scanner;

import controllers.AlunoController;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("\nSistema para controle de Alunos\n");

		try {

			System.out.println("(1) Cadastrar Aluno");
			System.out.println("(2) Atualizar Aluno");
			System.out.println("(3) Excluir Aluno");
			System.out.println("(4) Obter Aluno");
			System.out.println("(5) Consultar Alunos");

			System.out.print("\nInforme a opção desejada: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			AlunoController alunoController = new AlunoController();

			switch (opcao) {
			case 1:
				alunoController.cadastrarAluno();
				break;
			case 2:
				alunoController.atualizarAluno();
				break;
			case 3:
				alunoController.excluirAluno();
				break;
			case 4:
				alunoController.obterAluno();
				break;
			case 5:
				alunoController.consultarAlunos();
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
