package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import entities.Despesa;
import entities.Receita;
import entities.Tarefa;
import entities.enums.TipoDeTransacao;
import services.TarefaService;
import services.TransacaoService;
import services.dao.ContaDAOService;

/**
 * Classe que inicializa o programa
 * @author moriartynho
 *
 */
public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		Conta conta = new Conta();
		TransacaoService contaService = new TransacaoService();
		TarefaService tarefaService = new TarefaService();
		LocalDateTime localDate = LocalDateTime.now();
		int respNum = 0, login = 0;
		char respAl = 'n';
		String nome, senha;

		try {
			while (login == 0) {
				int inicOp = 0;
				System.out.println("Olá, escolha uma opção: "
						+ "\n1- Cadastro"
						+ "\n2- Login");
				inicOp = sc.nextInt();

				switch (inicOp) {
				case 1:
					System.out.print("Insira um nome: ");
					nome = sc.next();
					System.out.print("Insira uma senha: ");
					senha = sc.next();

					conta.setNome(nome);
					conta.setSenha(senha);

					ContaDAOService objusuarioDAO = new ContaDAOService();
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

					objusuarioDAO = new ContaDAOService();

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
			ContaDAOService objUsuarioDAO = new ContaDAOService();
			try {
				System.out.println("*************************");
				System.out.println(
						"Olá, " + conta.getNome() 
						+ "\n\nSaldo: " + conta.getSaldo() + 
						"\nReceita: " + conta.getSaldoReceita() 
						+ "\nDespesa: " + conta.getSaldoDespesa()
						+ "\n\n1 - Histórico"
						+ "\n2 - Receita" 
						+ "\n3 - Despesa" 
						+ "\n4 - Tarefa" 
						+ "\n5 - Limpar dados" 
						+ "\n6 - Sair\n");
				System.out.println("*************************");
				respNum = sc.nextInt();

				switch (respNum) {
				case 1:
					contaService.imprimirTransacoes(conta);

					break;

				case 2:
					int respostaReceita = 0;
					System.out.println(
							"Selecione uma opção: "
							+ "\n10 - Adicionar Receita"
							+ "\n20 - Remover Receita");
					respostaReceita = sc.nextInt();

					switch (respostaReceita) {
					case 10:
						System.out.println("*************************");
						contaService.imprimeReceita(conta);
						System.out.print("Insira um valor: R$ ");
						double valRec = sc.nextDouble();
						System.out.print("Insira uma descrição: ");
						String descRec = sc.next();
						contaService.novaTransacao(conta, new Receita(null, valRec, descRec, localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.RECEITA));
						System.out.println("*************************");
						objUsuarioDAO.novaTransacaoBD(new Receita(null, valRec, descRec, localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.RECEITA), conta.getUsuarioId());
						break;
					case 20:
						System.out.println("*************************");
						contaService.imprimeReceita(conta);
						System.out.print("Indique o número da receita que deseja remover: ");
						int i = sc.nextInt();
						contaService.removerTransacao(conta,i);
						contaService.imprimeReceita(conta);
						break;

					default:
						System.out.println("\nOpção Inválida. Selecione as opções 10 ou 20\n");
						break;
					}

					break;

				case 3:
					int respostaDespesa = 0;
					System.out.println(
							"Selecione uma opção: "
							+ "\n30 - Adicionar Despesa"
							+ "\n40 - Remover Despesa");
					respostaDespesa = sc.nextInt();

					switch (respostaDespesa) {
					case 30:
						System.out.println("*************************");
						contaService.imprimeDespesa(conta);
						System.out.print("Insira um valor: R$ ");
						double valorDespesa = sc.nextDouble();
						System.out.print("Insira uma descrição: ");
						String descricaoDespesa = sc.next();
						contaService.novaTransacao(conta, new Despesa(null, valorDespesa, descricaoDespesa, localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.DESPESA));
						System.out.println("*************************");
						objUsuarioDAO.novaTransacaoBD(new Despesa(null, valorDespesa, descricaoDespesa, localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.DESPESA), conta.getUsuarioId());
						break;

					case 40:
						System.out.println("*************************");
						contaService.imprimeDespesa(conta);
						System.out.print("Indique o número da despesa que deseja remover: ");
						int i = sc.nextInt();
						contaService.removerTransacao(conta, i);
						contaService.imprimeDespesa(conta);
						break;

					default:
						System.out.println("\nOpção Inválida. Selecione as opções 30 ou 40\n");
						break;
					}

					break;
				case 4:
					int respostaTarefa = 0;
					System.out.println(
							"Selecione uma opção: \n50 - Adicionar Tarefa\n60 - Remover Tarefa\n70 - Ver tarefas");
					respostaTarefa = sc.nextInt();

					switch (respostaTarefa) {
					case 50:
						System.out.println("*************************");
						tarefaService.imrpimeTarefas(conta);
						System.out.print("Insira um título: ");
						String titulo = sc.next();
						System.out.print("Quando pretende realizar essa tarefa? ");
						String data = sc.next();
						System.out.print("Qual valor pretende utilizar? R$");
						double valor = sc.nextDouble();
						tarefaService.novaTarefa(conta, new Tarefa(titulo, data, valor));
						objUsuarioDAO.novaTarefaBD(new Tarefa(titulo, data, valor), conta.getUsuarioId());
						break;
					case 60:
						System.out.println("*************************");
						tarefaService.imrpimeTarefas(conta);
						System.out.print("Indique o número da tarefa que deseja remover: ");
						int i = sc.nextInt();
						tarefaService.removerTarefa(conta, i);
						tarefaService.imrpimeTarefas(conta);
						break;
						

					case 70:
						System.out.println("*************************");
						System.out.println("Tarefas");
						tarefaService.imrpimeTarefas(conta);
						break;

					default:
						System.out.println("\nOpção Inválida. Selecione as opções 50, 60 ou 70\n");
						break;
					}
					break;

				case 5:
					System.out.println("Deseja limpar todos os dados? Essa ação é irreversível (y/n)");
					char respostaLimparDados = sc.next().charAt(0);
					if (respostaLimparDados == 'y') {
						objUsuarioDAO.limparDados(conta.getUsuarioId());
						objUsuarioDAO.carregaInfo(conta);
						System.out.println("*************************");
						break;
					} else {
						System.out.println("Retornando ao menu");
						break;
					}
				case 6:
					System.out.println("Deseja sair? [y/n]");
					respAl = sc.next().charAt(0);
					System.out.println("Programa encerrado.");
					break;
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
