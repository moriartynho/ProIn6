package entities;

import java.util.ArrayList;
import java.util.List;

import services.Despesa;
import services.Receita;
import services.Transac;

public class Conta {

	private Integer usuarioId;
	private String nome;
	private String senha;
	private Double saldo;
	private Double saldoReceita;
	private Double saldoDespesa;
	private List<Transac> transac = new ArrayList<>();
	private List<Receita> receita = new ArrayList<>();
	private List<Despesa> despesa = new ArrayList<>();

	public Conta() {
	}

	public Conta(Integer usuarioId, String nome, String senha, Double saldo, Double saldoReceita, Double saldoDespesa,
			List<Transac> transac, List<Receita> receita, List<Despesa> despesa) {
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.senha = senha;
		this.saldo = saldo;
		this.saldoReceita = saldoReceita;
		this.saldoDespesa = saldoDespesa;
		this.transac = transac;
		this.receita = receita;
		this.despesa = despesa;
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

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldoReceita() {
		return saldoReceita;
	}

	public void setSaldoReceita(Double saldoReceita) {
		this.saldoReceita = saldoReceita;
	}

	public Double getSaldoDespesa() {
		return saldoDespesa;
	}

	public void setSaldoDespesa(Double saldoDespesa) {
		this.saldoDespesa = saldoDespesa;
	}

	public List<Transac> getTransac() {
		return transac;
	}

	public void setTransac(List<Transac> transac) {
		this.transac = transac;
	}

	public void newTransac(Double valor, String desc, String data, boolean tipo) {
		if (tipo == true) {
			receita.add(new Receita(valor, desc, data));
			transac.add(new Transac(valor, desc, data, tipo));
			atualSaldReceita();
		} else {
			despesa.add(new Despesa(valor, desc, data));
			transac.add(new Transac(valor, desc, data, tipo));
			atualSaldDespesa();
		}
		atualSaldo();

	}

	public void imprimir() {
		for (int i = 0; i < getTransac().size(); i++) {
			System.out.println(getTransac().get(i) + "\n");
		}
	}

	public void imprimeReceita() {
		for (int i = 0; i < receita.size(); i++) {
			int in = i + 1;
			System.out.println(in + " - " + receita.get(i) + "\n");
		}
	}

	public void imprimeDespesa() {
		for (int i = 0; i < despesa.size(); i++) {
			int in = i + 1;
			System.out.println(in + " - " + despesa.get(i) + "\n");
		}
	}

	public void atualSaldo() {
		double novoValor = getSaldoReceita() - getSaldoDespesa();
		setSaldo(novoValor);
	}

	public void atualSaldDespesa() {
		Double total = 0.0;
		for (Despesa x : despesa) {
			total += x.getValor();
		}
		setSaldoDespesa(total);
	}

	public void atualSaldReceita() {
		Double total = 0.0;
		for (Receita x : receita) {
			total += x.getValor();
		}
		setSaldoReceita(total);
	}

	public void inacRec(Integer i) {
		int in = i - 1;
		receita.remove(in);
		atualSaldReceita();
		atualSaldo();
	}

	public void inacDesp(Integer i) {
		int in = i - 1;
		despesa.remove(in);
		atualSaldDespesa();
		atualSaldo();
	}

}