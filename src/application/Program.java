package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import services.ContaDAO;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		Conta conta = new Conta();
		int respNum = 0, login = 0;
		char respAl = 'n';
		String nome, senha;

		try {
			while (login == 0) {
				int inicOp = 0;
				System.out.println("Olá, escolha uma opção: \n1- Cadastro\n2- Login");
				inicOp = sc.nextInt();

				switch (inicOp) {
				case 1:
					System.out.print("Insira um nome: ");
					nome = sc.next();
					System.out.print("Insira uma senha: ");
					senha = sc.next();

					
					conta.setNome(nome);
					conta.setSenha(senha);
				

					ContaDAO objusuarioDAO = new ContaDAO();
					objusuarioDAO.cadastrarConta(conta);
					System.out.println();
					System.out.println("Cadastro realizado");
					System.out.println();

					break;

				case 2:

					System.out.print("Usuário > ");
					nome = sc.next();
					System.out.print("Senha> ");
					senha = sc.next();

					
					conta.setNome(nome);
					conta.setSenha(senha);
					

					objusuarioDAO = new ContaDAO();
					
					ResultSet rsContaDAO = objusuarioDAO.autenticacaoConta(conta);
					

					if (rsContaDAO.next()) {
						objusuarioDAO.iniciarConta(conta);
						System.out.println();
						System.out.println("\nLogin efetuado com sucesso\n");
						login = 1;
						
					} else {
						System.out.println("\nUsuário ou senha inválida\n");
					}
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		while (respAl == 'n') {
			ContaDAO objUsuarioDAO = new ContaDAO();
			// objUsuarioDAO.pesquisarConta();

			try {
				System.out.println("Olá, " + conta.getNome() + "\n\n1 - Informações de saldo"
						+ "\n2 - Adicionar Receita" + "\n3 - Adicionar Despesa" + "\n4 - Sair\n");
				respNum = sc.nextInt();

				switch (respNum) {
				case 1:
					System.out.printf("Saldo: R$ %.2f%n", conta.getSaldo());
					System.out.printf("Receita: R$ %.2f%n", conta.getSaldoReceita());
					System.out.printf("Despesa: R$ %.2f%n", conta.getSaldoDespesa());
					System.out.println();

					break;

				case 2: // adicionar receita
					conta.receitaInfo();
					System.out.println();
					System.out.print("Insira um valor: R$ ");
					double valRec = sc.nextDouble();
					System.out.print("Insira uma descrição: ");
					String descRec = sc.next();
					conta.addReceita(valRec, descRec);
					System.out.println();
					objUsuarioDAO.atualizaDados(conta);

					break;

				case 3: // adicionar despesa
					conta.despesaInfo();
					System.out.println();
					System.out.print("Insira um valor: R$ ");
					double valDesp = sc.nextDouble();
					System.out.print("Insira uma descrição: ");
					String descDesp = sc.next();
					conta.addDespesa(valDesp, descDesp);
					System.out.println();
					objUsuarioDAO.atualizaDados(conta);

					break;

				case 4:
					System.out.println("Deseja sair? [y/n]");
					respAl = sc.next().charAt(0);
					System.out.println("Programa encerrado.");
				default:
					System.out.println("\nOpção Inválida. Selecione uma opção entre 1 e 4\n");
					break;
				}
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}

			

		}

		sc.close();

	}

}
