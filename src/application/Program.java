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
			while(login == 0) {
			int inicOp = 0;
			System.out.println("Olá, escolha uma opção: \n1- Cadastro\n2- Login");
			inicOp = sc.nextInt();

			if (inicOp == 1) {
				System.out.print("Insira um nome: ");
				nome = sc.next();
				System.out.print("Insira uma senha: ");
				senha = sc.next();

				Conta objContaDTO = new Conta();
				objContaDTO.setNome(nome);
				objContaDTO.setSenha(senha);
				objContaDTO.setSaldo(null);

				ContaDAO objusuarioDAO = new ContaDAO();
				objusuarioDAO.cadastrarConta(objContaDTO);
				System.out.println();
				System.out.println("Cadastro realizado");

			} else if (inicOp == 2) {

				System.out.print("Usuário > ");
				nome = sc.next();
				System.out.print("Senha> ");
				senha = sc.next();

				Conta objContaDTO = new Conta();
				objContaDTO.setNome(nome);
				objContaDTO.setSenha(senha);

				ContaDAO objusuarioDAO = new ContaDAO();
				ResultSet rsContaDAO = objusuarioDAO.autenticacaoConta(objContaDTO);

				if (rsContaDAO.next()) {
					System.out.println("Login efetuado com sucesso");
					login = 1;
				} else {
					System.out.println();
					System.out.println("Usuário ou senha inválida");
					System.out.println();
				}
			}}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		while (respAl == 'n') {

			try {

				System.out.println("Olá, " + conta.getNome()
						+ "\n\n1 - Informações de saldo\n2 - Adicionar Receita\n3 - Adicionar Despesa\n4 - Sair\n");
				respNum = sc.nextInt();

				if (respNum == 1) { // Nessa opção o usuário pode visualizar opções gerais da conta
					System.out.printf("Saldo: R$ %.2f%n", conta.getSaldo());
					System.out.printf("Receita: R$ %.2f%n", conta.getSaldoReceita());
					System.out.printf("Despesa: R$ %.2f%n", conta.getSaldoDespesa());
					System.out.println();

				} else if (respNum == 2) { // Nessa opção o usuário pode adicionar uma receita
					conta.receitaInfo(); // Esse método imprime as informações de receita
					System.out.println();
					System.out.print("Insira um valor: R$ ");
					double valRec = sc.nextDouble();
					System.out.print("Insira uma descrição: ");
					String descRec = sc.next();
					conta.addReceita(valRec, descRec);
					System.out.println();

				} else if (respNum == 3) { // Nessa opção o usuário pode adicionar uma despesa com valor e descrição
					conta.despesaInfo();// Esse método imprime as informações de despesa
					System.out.println();
					System.out.print("Insira um valor: R$ ");
					double valDesp = sc.nextDouble();
					System.out.print("Insira uma descrição: ");
					String descDesp = sc.next();
					conta.addDespesa(valDesp, descDesp);
					System.out.println();

				} else { // Nessa opção o usuário pode encerrar o programa
					System.out.println("Deseja sair? [y/n]");
					respAl = sc.next().charAt(0);
				}
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}

			System.out.println("Programa encerrado."); // Essa mensagem aparece quando o programa é encerrado

		}

		sc.close();

	}

}
