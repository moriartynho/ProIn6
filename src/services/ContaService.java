package services;

import entities.Conta;
import entities.Despesa;
import entities.Receita;
import entities.Tarefa;
import entities.Transacao;
import services.dao.ContaDAOService;

/**
 * 
 * Classe de serviços da classe Conta
 * 
 * @author moriartynho
 *
 */
public class ContaService {

	private Conta conta;

	public ContaService(Conta conta) {
		this.conta = conta;
	}

	public void novaTransacao(Transacao transacao) {
		conta.getTransacoes().add(transacao);
		if (transacao.getIsRend() == true) {
			conta.getReceitas().add(new Receita(null, transacao.getValor(), transacao.getDesc(), transacao.getData()));
			atualizaSaldoReceita();
		} else {
			conta.getDespesas().add(new Despesa(null, transacao.getValor(), transacao.getDesc(), transacao.getData()));
			atualizaSaldoDespesa();
		}
		atualizaSaldo();

	}

	public void imprimirTransacoes() {
		conta.getTransacoes().forEach(t -> System.out.println((conta.getTransacoes().indexOf(t) + 1) + " - " + t));
	}

	public void imprimeReceita() {
		conta.getReceitas().forEach(r -> System.out.println((conta.getReceitas().indexOf(r) + 1) + " - " + r));
	}

	public void imprimeDespesa() {
		conta.getDespesas().forEach(d -> System.out.println((conta.getDespesas().indexOf(d) + 1) + " - " + d));
	}

	public void atualizaSaldo() {
		double novoValor = conta.getSaldoReceita() - conta.getSaldoDespesa();
		conta.setSaldo(novoValor);
	}

	public void atualizaSaldoDespesa() {
		Double total = conta.getDespesas().stream().mapToDouble(d -> d.getValor()).sum();
		conta.setSaldoDespesa(total);
	}

	public void atualizaSaldoReceita() {
		Double total = conta.getReceitas().stream().mapToDouble(r -> r.getValor()).sum();
		conta.setSaldo(total);
	}

	public void removerReceita(Integer i) {
		int in = i - 1;
		ContaDAOService obj = new ContaDAOService();
		obj.removeNoBD(conta.getReceitas().get(in).getId());
		conta.getReceitas().remove(in);

		atualizaSaldoReceita();
		atualizaSaldo();
	}

	public void removerDespesa(Integer i) {
		int in = i - 1;
		ContaDAOService obj = new ContaDAOService();
		obj.removeNoBD(conta.getDespesas().get(in).getId());
		conta.getDespesas().remove(in);

		atualizaSaldoDespesa();
		atualizaSaldo();
	}

	public void novaTarefa(Tarefa tarefa) {
		conta.getTarefas().add(new Tarefa(tarefa.getTitulo(), tarefa.getData(), tarefa.getValor()));
	}

	public void removerTarefa(Integer i) {
		int in = i - 1;
		conta.getTarefas().remove(in);
	}

	public void imrpimeTarefas() {
		conta.getTarefas().forEach(t -> System.out.println((conta.getTarefas().indexOf(t) + 1) + " - " + t));
	}
}
