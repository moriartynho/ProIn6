package services;

import entities.Conta;
import entities.Despesa;
import entities.Receita;
import entities.Transacao;
import services.dao.ContaDAOService;
import services.transacoes.InsercaoDeTransacao;
import services.transacoes.SemTransacao;
import services.transacoes.despesa.InserirDespesa;
import services.transacoes.receita.InserirReceita;

/**
 * 
 * Classe de serviços da classe Conta
 * 
 * @author moriartynho
 *
 */
public class TransacaoService {

	public void novaTransacao(Conta conta, Transacao transacao) {
		if (transacao.getValor() >= 0) {

			conta.getTransacoes().add(transacao);
			
			InsercaoDeTransacao novaTransacao = new InserirReceita(new InserirDespesa(new SemTransacao()));
			
			atualizaSaldoReceita(conta);
			atualizaSaldoDespesa(conta);
			atualizaSaldo(conta);

		} else
			throw new IllegalArgumentException("Valor deve ser maior que 0");

	}

	public void imprimirTransacoes(Conta conta) {
		conta.getTransacoes().forEach(t -> System.out.println((conta.getTransacoes().indexOf(t) + 1) + " - " + t));
	}

	public void imprimeReceita(Conta conta) {
		conta.getReceitas().forEach(r -> System.out.println((conta.getReceitas().indexOf(r) + 1) + " - " + r));
	}

	public void imprimeDespesa(Conta conta) {
		conta.getDespesas().forEach(d -> System.out.println((conta.getDespesas().indexOf(d) + 1) + " - " + d));
	}

	public void atualizaSaldo(Conta conta) {
		double novoValor = conta.getSaldoReceita() - conta.getSaldoDespesa();
		conta.setSaldo(novoValor);
	}

	public void atualizaSaldoDespesa(Conta conta) {
		Double total = conta.getDespesas().stream().mapToDouble(d -> d.getValor()).sum();
		conta.setSaldoDespesa(total);
	}

	public void atualizaSaldoReceita(Conta conta) {
		Double total = conta.getReceitas().stream().mapToDouble(r -> r.getValor()).sum();
		conta.setSaldo(total);
	}

	public void removerReceita(Conta conta, Integer i) {
		int in = i - 1;
		ContaDAOService obj = new ContaDAOService();
		obj.removeNoBD(conta.getReceitas().get(in).getId());
		conta.getReceitas().remove(in);

		atualizaSaldoReceita(conta);
		atualizaSaldo(conta);
	}

	public void removerDespesa(Conta conta, Integer i) {
		int in = i - 1;
		ContaDAOService obj = new ContaDAOService();
		obj.removeNoBD(conta.getDespesas().get(in).getId());
		conta.getDespesas().remove(in);

		atualizaSaldoDespesa(conta);
		atualizaSaldo(conta);
	}

}
