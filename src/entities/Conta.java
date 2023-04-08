package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a conta de um usuário.
 * 
 * @author moriartynho
 *
 */
public class Conta {

	private Integer usuarioId;
	private String nome;
	private String senha;
	private Double saldo;
	private Double saldoReceita;
	private Double saldoDespesa;
	private List<Transacao> transacoes = new ArrayList<>();
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

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

}