package services;

import entities.Conta;
import entities.Despesa;
import entities.Receita;
import entities.Tarefa;
import entities.Transac;
import entities.dao.ContaDAO;

/**
 * 
 * Classe de serviços da classe Conta
 * @author moriartynho
 *
 */
public class ContaService {

	private Conta conta;

	public ContaService(Conta conta) {
		this.conta = conta;
	}

	public void novaTransacao(Integer id, Double valor, String desc, String data, boolean tipo) {
		if (tipo == true) {
			conta.getReceitas().add(new Receita(id, valor, desc, data));
			conta.getTransacoes().add(new Transac(id, valor, desc, data, tipo));
			atualizaSaldoReceita();
		} else {
			conta.getDespesas().add(new Despesa(id, valor, desc, data));
			conta.getTransacoes().add(new Transac(id, valor, desc, data, tipo));
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
		ContaDAO obj = new ContaDAO();
		obj.removeNoBD(conta.getReceitas().get(in).getId());
		conta.getReceitas().remove(in);

		atualizaSaldoReceita();
		atualizaSaldo();
	}

	public void removerDespesa(Integer i) {
		int in = i - 1;
		ContaDAO obj = new ContaDAO();
		obj.removeNoBD(conta.getDespesas().get(in).getId());
		conta.getDespesas().remove(in);

		atualizaSaldoDespesa();
		atualizaSaldo();
	}

	public void novaTarefa(String titulo, String data, double valor) {
		conta.getTarefas().add(new Tarefa(titulo, data, valor));
	}

	public void removerTarefa(Integer i) {
		int in = i - 1;
		conta.getTarefas().remove(in);
	}

	public void imrpimeTarefas() {
		conta.getTarefas().forEach(t -> System.out.println((conta.getTarefas().indexOf(t) + 1) + " - " + t));
	}
}
