package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.TipoDeTransacao;

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
	private List<Transacao> transacoes = new ArrayList<>();
	private List<Tarefa> tarefas = new ArrayList<>();

	public Conta() {
	}

	public Conta(Integer usuarioId, String nome, String senha) {
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.senha = senha;
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

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public Double getSaldo() {
		return (getSaldoReceita() - getSaldoDespesa());
	}

	public Double getSaldoReceita() {
		return transacoes.stream()
				.filter(t -> t.getTipoDeTransacao() == TipoDeTransacao.RECEITA)
				.mapToDouble(r -> r.getValor()).sum();
	}

	public Double getSaldoDespesa() {
		return transacoes.stream()
				.filter(t -> t.getTipoDeTransacao() == TipoDeTransacao.DESPESA)
				.mapToDouble(r -> r.getValor()).sum();
	}

}