package services;

import entities.Conta;
import entities.Transacao;
import entities.enums.TipoDeTransacao;
import services.dao.ContaDAOService;
import services.insercao.NovaTransacao;
import services.insercao.NovaTransacaoInvalida;
import services.insercao.TransacaoValorMaiorQueZero;

/**
 * 
 * Classe de serviços da classe Conta
 * 
 * @author moriartynho
 *
 */
public class TransacaoService {

	public void novaTransacao(Conta conta, Transacao transacao) {
		NovaTransacao novaTransacao = new TransacaoValorMaiorQueZero(new NovaTransacaoInvalida());
		novaTransacao.inserir(transacao, conta);

	}

	public void imprimirTransacoes(Conta conta) {
		conta.getTransacoes().forEach(t -> System.out.println((conta.getTransacoes().indexOf(t) + 1) + " - " + t));
	}

	public void imprimeReceita(Conta conta) {
		conta.getTransacoes().stream().filter(t -> t.getTipoDeTransacao() == TipoDeTransacao.RECEITA)
				.forEach(r -> System.out.println((conta.getTransacoes().indexOf(r) + 1) + " - " + r));
	}

	public void imprimeDespesa(Conta conta) {
		conta.getTransacoes().stream().filter(t -> t.getTipoDeTransacao() == TipoDeTransacao.DESPESA)
				.forEach(d -> System.out.println((conta.getTransacoes().indexOf(d) + 1) + " - " + d));
	}

	public void removerTransacao(Conta conta, Integer i) {
		int in = i - 1;
		ContaDAOService obj = new ContaDAOService();
		obj.removeNoBD(conta.getTransacoes().get(in).getId());
		conta.getTransacoes().remove(in);
	}

}
