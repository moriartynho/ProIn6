package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import services.ContaDAO;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		Conta conta = new Conta();
		LocalDateTime localDate = LocalDateTime.now();
		boolean income = true, expense = false;
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

				System.out.println("Olá, " + conta.getNome() + "\n\nSaldo: " + conta.getSaldo() + "\nReceita: "
						+ conta.getSaldoReceita() + "\nDespesa: " + conta.getSaldoDespesa() + "\n\n1 - Histórico"
						+ "\n2 - Receita" + "\n3 - Despesa" + "\n4 - Sair\n");
				respNum = sc.nextInt();

				switch (respNum) {
				case 1:
					conta.imprimir();

					break;

				case 2:
					int recResp = 0;
					System.out.println("Selecione uma opção: \n10 - Adicionar Receita\n20 - Remover Receita");
					recResp = sc.nextInt();
					switch (recResp) {
					case 10:
						System.out.println();
						conta.imprimeReceita();
						System.out.print("Insira um valor: R$ ");
						double valRec = sc.nextDouble();
						System.out.print("Insira uma descrição: ");
						String descRec = sc.next();
						conta.newTransac(valRec, descRec, localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
								income);
						System.out.println();
						objUsuarioDAO.atualizaDados(conta);
						break;
					case 20:
						System.out.println();
						conta.imprimeReceita();
						System.out.print("Indique o número da receita que deseja remover: ");
						int i = sc.nextInt();
						conta.inacRec(i);
						conta.imprimeReceita();
						break;

					default:
						System.out.println("\nOpção Inválida. Selecione as opções 10 ou 20\n");
						break;
					}

					break;

				case 3:
					int despResp = 0;
					System.out.println("Selecione uma opção: \n30 - Adicionar Despesa\n40 - Remover Despesa");
					despResp = sc.nextInt();
					switch (despResp) {
					case 30:
						System.out.println();
						conta.imprimeDespesa();
						System.out.print("Insira um valor: R$ ");
						double valDesp = sc.nextDouble();
						System.out.print("Insira uma descrição: ");
						String descDesp = sc.next();
						conta.newTransac(valDesp, descDesp, localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
								expense);
						System.out.println();
						objUsuarioDAO.atualizaDados(conta);
						break;

					case 40:
						System.out.println();
						conta.imprimeDespesa();
						System.out.print("Indique o número da despesa que deseja remover: ");
						int i = sc.nextInt();
						conta.inacDesp(i);
						conta.imprimeDespesa();
						break;

					default:
						System.out.println("\nOpção Inválida. Selecione as opções 30 ou 40\n");
						break;
					}

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
