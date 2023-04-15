package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import entities.Conta;
import entities.Despesa;
import entities.Receita;
import entities.enums.TipoDeTransacao;
import services.TransacaoService;

public class ProgramaTeste {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Conta conta = new Conta(1, "Wilkson", "1234");
		TransacaoService contaService = new TransacaoService();
		LocalDateTime localDate = LocalDateTime.now();
		
		contaService.novaTransacao(conta, new Receita(1, 100.0, "Teste1", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.RECEITA));
		contaService.novaTransacao(conta, new Receita(2, 200.0, "Teste2", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.RECEITA));
		contaService.novaTransacao(conta, new Receita(3, 300.0, "Teste3", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.RECEITA));
		contaService.novaTransacao(conta, new Receita(4, 400.0, "Teste4", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.RECEITA));
		contaService.novaTransacao(conta, new Receita(5, 500.0, "Teste5", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.RECEITA));
		
		contaService.novaTransacao(conta, new Despesa(1, 100.0, "Teste1", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.DESPESA));
		contaService.novaTransacao(conta, new Despesa(2, 200.0, "Teste2", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.DESPESA));
		contaService.novaTransacao(conta, new Despesa(3, 300.0, "Teste3", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.DESPESA));
		contaService.novaTransacao(conta, new Despesa(4, 400.0, "Teste4", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.DESPESA));
		contaService.novaTransacao(conta, new Despesa(5, 420.0, "Teste5", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), TipoDeTransacao.DESPESA));
		
		System.out.println("*************************");
		System.out.println(conta.getSaldo());
		System.out.println(conta.getSaldoReceita());
		System.out.println(conta.getSaldoDespesa());
		System.out.println("*************************");
		contaService.imprimirTransacoes(conta);
		System.out.println("*************************");
		contaService.imprimeReceita(conta);
		System.out.println("*************************");
		contaService.imprimeDespesa(conta);
	}

}
