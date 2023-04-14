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

	public String getSaldo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSaldoReceita() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSaldoDespesa() {
		// TODO Auto-generated method stub
		return null;
	}

}