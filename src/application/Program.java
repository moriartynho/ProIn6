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

			switch (inicOp) {
			case 1:
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
				System.out.println();
				
				break;

			case 2:

				System.out.print("Usuário > ");
				nome = sc.next();
				System.out.print("Senha> ");
				senha = sc.next();

				objContaDTO = new Conta();
				objContaDTO.setNome(nome);
				objContaDTO.setSenha(senha);

				objusuarioDAO = new ContaDAO();
				ResultSet rsContaDAO = objusuarioDAO.autenticacaoConta(objContaDTO);

				if (rsContaDAO.next()) {
					System.out.println();
					System.out.println("\nLogin efetuado com sucesso\n");
					login = 1;
				} else {
					System.out.println("\nUsuário ou senha inválida\n");
				}
			}}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		while (respAl == 'n') {

			try {

				System.out.println("Olá, " + conta.getNome()
						+ "\n\n1 - Informações de saldo"
						+ "\n2 - Adicionar Receita"
						+ "\n3 - Adicionar Despesa"
						+ "\n4 - Sair\n");
				respNum = sc.nextInt();

				switch (respNum) {
				case 1:
					System.out.printf("Saldo: R$ %.2f%n", conta.getSaldo());
					System.out.printf("Receita: R$ %.2f%n", conta.getSaldoReceita());
					System.out.printf("Despesa: R$ %.2f%n", conta.getSaldoDespesa());
					System.out.println();
					
					break;

				case 2:
					conta.receitaInfo();
					System.out.println();
					System.out.print("Insira um valor: R$ ");
					double valRec = sc.nextDouble();
					System.out.print("Insira uma descrição: ");
					String descRec = sc.next();
					conta.addReceita(valRec, descRec);
					System.out.println();
					
					break;
					
				case 3:  
					conta.despesaInfo();
					System.out.println();
					System.out.print("Insira um valor: R$ ");
					double valDesp = sc.nextDouble();
					System.out.print("Insira uma descrição: ");
					String descDesp = sc.next();
					conta.addDespesa(valDesp, descDesp);
					System.out.println();
					
					break;

				case 4:
					System.out.println("Deseja sair? [y/n]");
					respAl = sc.next().charAt(0);
				default:
					System.out.println("\nOpção Inválida. Selecione uma opção entre 1 e 4\n");
				}
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}

			System.out.println("Programa encerrado.");

		}

		sc.close();

	}

}
