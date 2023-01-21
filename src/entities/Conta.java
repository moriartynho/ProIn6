package entities;

import java.util.ArrayList;
import java.util.List;

public class Conta {

	private Integer usuarioId;
	private String nome;
	private String senha;
	private Double saldo;
	private Double saldoReceita;
	private Double saldoDespesa;
	private List<Double> despesa = new ArrayList<>();
	private List<String> descDesp = new ArrayList<>();
	private List<Double> receita = new ArrayList<>();
	private List<String> descRec = new ArrayList<>();
	private List <String> dateDesp = new ArrayList<>();
	private List <String> dateRec = new ArrayList<>();

	public Conta() {
	}

	public Conta(Integer usuarioId, String nome, String senha, Double saldo, Double saldoReceita, Double saldoDespesa,
			List<Double> despesa, List<String> descDesp, List<Double> receita, List<String> descRec,
			List<String> dateDesp, List<String> dateRec) {
		super();
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.senha = senha;
		this.saldo = saldo;
		this.saldoReceita = saldoReceita;
		this.saldoDespesa = saldoDespesa;
		this.despesa = despesa;
		this.descDesp = descDesp;
		this.receita = receita;
		this.descRec = descRec;
		this.dateDesp = dateDesp;
		this.dateRec = dateRec;
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

	public List<Double> getDespesa() {
		return despesa;
	}

	public void setDespesa(List<Double> despesa) {
		this.despesa = despesa;
	}

	public List<String> getDescDesp() {
		return descDesp;
	}

	public void setDescDesp(List<String> descDesp) {
		this.descDesp = descDesp;
	}

	public List<Double> getReceita() {
		return receita;
	}

	public void setReceita(List<Double> receita) {
		this.receita = receita;
	}

	public List<String> getDescRec() {
		return descRec;
	}

	public void setDescRec(List<String> descRec) {
		this.descRec = descRec;
	}

	public List<String> getDateDesp() {
		return dateDesp;
	}


	public void setDateDesp(List<String> dateDesp) {
		this.dateDesp = dateDesp;
	}

	public List<String> getDateRec() {
		return dateRec;
	}

	public void setDateRec(List<String> dateRec) {
		this.dateRec = dateRec;
	}

	public void addDespesa(Double valorRec, String descDespRec, String localDateTime) { // Adicionar despesa
		despesa.add(valorRec);
		dateDesp.add(localDateTime);
		if(descDespRec!=" ") {
		descDesp.add(descDespRec);
		} else {
			descDesp.add("Sem descrição");
		}
		atualizaSaldoDespesa();
		atualizaSaldo();
	}

	public void addReceita(Double valorRec, String descRecRec, String localDateTime) { // Adicionar receita
		receita.add(valorRec);
		dateRec.add(localDateTime);
		if(descRecRec!=" ") {
		descRec.add(descRecRec);
		} else {
			descRec.add("Sem descrição");
		}
		atualizaSaldoReceita();
		atualizaSaldo();
	}

	public void receitaInfo() { // imprime informações de receita
		//atualizaSaldoReceita();
		//atualizaSaldo();
		System.out.println("\nSALDO DE RECEITA: R$ " + getSaldoReceita() + "\n");

		for (int i = 0; i < getReceita().size(); i++) {
			System.out.println("R$" + getReceita().get(i) + " - " + getDescRec().get(i)+" ("+getDateRec().get(i)+")");
		}
	}

	public void despesaInfo() { // imprime informações de despesa
		//atualizaSaldoDespesa();
		//atualizaSaldo();
		System.out.println("\nSALDO DE DESPESA: R$ " + getSaldoDespesa() + "\n");

		for (int i = 0; i < getDespesa().size(); i++) {
			System.out.println("R$" + getDespesa().get(i) + " - " + getDescDesp().get(i)+" ("+getDateDesp().get(i)+")");
		}

	}

	public void atualizaSaldoDespesa() {
		double sum = 0;
		for (Double x : getDespesa()) {
			sum += x;
		}
		setSaldoDespesa(sum);
		System.out.println("\nSaldo atualizado\n");
	}

	public void atualizaSaldoReceita() {
		double sum = 0;
		for (Double x : getReceita()) {
			sum += x;
		}
		setSaldoReceita(sum);
		System.out.println("\nSaldo atualizado\n");
	}

	public void atualizaSaldo() {
		double saldoAtu = getSaldoReceita() - getSaldoDespesa();
		setSaldo(saldoAtu);
	}

}