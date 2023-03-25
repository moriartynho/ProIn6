package entities;

import java.util.ArrayList;
import java.util.List;

import entities.dao.ContaDAO;

public class Conta {

	private Integer usuarioId;
	private String nome;
	private String senha;
	private Double saldo;
	private Double saldoReceita;
	private Double saldoDespesa;
	private List<Transac> transacoes = new ArrayList<>();
	private List<Receita> receitas = new ArrayList<>();
	private List<Despesa> despesas = new ArrayList<>();
	private List<Tarefa> tarefas = new ArrayList<>();

	public Conta() {
	}

	public Conta(Integer usuarioId, String nome, String senha, Double saldo, Double saldoReceita, Double saldoDespesa) {
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.senha = senha;
		this.saldo = saldo;
		this.saldoReceita = saldoReceita;
		this.saldoDespesa = saldoDespesa;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldoReceita(Double saldoReceita) {
		this.saldoReceita = saldoReceita;
	}

	public void setSaldoDespesa(Double saldoDespesa) {
		this.saldoDespesa = saldoDespesa;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldoReceita() {
		return saldoReceita;
	}

	public Double getSaldoDespesa() {
		return saldoDespesa;
	}

	public void novaTransacao(Integer id, Double valor, String desc, String data, boolean tipo) {
		if (tipo == true) {
			receitas.add(new Receita(id, valor, desc, data));
			transacoes.add(new Transac(id, valor, desc, data, tipo));
			atualizaSaldoReceita();
		} else {
			despesas.add(new Despesa(id, valor, desc, data));
			transacoes.add(new Transac(id, valor, desc, data, tipo));
			atualizaSaldoDespesa();
		}
		atualizaSaldo();

	}

	public void imprimirTransaacoes() {
		transacoes.forEach(t -> System.out.println((transacoes.indexOf(t) + 1) + " - " + t));
	}

	public void imprimeReceita() {
		receitas.forEach(r -> System.out.println((receitas.indexOf(r) + 1) + " - " + r));
	}

	public void imprimeDespesa() {
		despesas.forEach(d -> System.out.println((despesas.indexOf(d) + 1) + " - " + d));
	}

	public void atualizaSaldo() {
		double novoValor = getSaldoReceita() - getSaldoDespesa();
		this.saldo = novoValor;
	}

	public void atualizaSaldoDespesa() {
		Double total = despesas.stream().mapToDouble(d -> d.getValor()).sum();
		this.saldoDespesa = total;
	}

	public void atualizaSaldoReceita() {
		Double total = receitas.stream().mapToDouble(r -> r.getValor()).sum();
		this.saldoReceita = total;
	}

	public void removerReceita(Integer i) {
		int in = i - 1;
		ContaDAO obj = new ContaDAO();
		obj.removeNoBD(receitas.get(in).getId());
		receitas.remove(in);

		atualizaSaldoReceita();
		atualizaSaldo();
	}

	public void removerDespesa(Integer i) {
		int in = i - 1;
		ContaDAO obj = new ContaDAO();
		obj.removeNoBD(despesas.get(in).getId());
		despesas.remove(in);

		atualizaSaldoDespesa();
		atualizaSaldo();
	}

	public void novaTarefa(String titulo, String data, double valor) {
		tarefas.add(new Tarefa(titulo, data, valor));
	}

	public void removerTarefa(Integer i) {
		int in = i - 1;
		tarefas.remove(in);
	}

	public void imrpimeTarefas() {
		tarefas.forEach(t -> System.out.println((tarefas.indexOf(t) + 1) + " - " + t));
	}

}