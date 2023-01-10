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

	public Conta() {
	}
	
	public Conta(Integer usuarioId, String nome, String senha, Double saldo, Double saldoReceita, Double saldoDespesa,
			List<Double> despesa, List<String> descDesp, List<Double> receita, List<String> descRec) {
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



	public void addDespesa(Double valorRec, String descDespRec) { // Adicionar despesa
		despesa.add(valorRec);
		descDesp.add(descDespRec);
		atualizaSaldoDespesa();
		atualizaSaldo();
	}

	public void addReceita(Double valorRec, String descRecRec) { // Adicionar receita
		receita.add(valorRec);
		descRec.add(descRecRec);
		atualizaSaldoReceita();
		atualizaSaldo();
	}

	public void receitaInfo() { // imprime informações de receita
		System.out.println("\nSALDO DE RECEITA: R$ " + getSaldoReceita() + "\n");
		getReceita().forEach(System.out::print);
		getDescRec().forEach(System.out::println);
		/*for (Double x : getReceita()) {
			for (String y : getDescRec()) {
				if (y == "") {
					System.out.println("Sem descrição" + " - " + "R$ " + x);
				} else {
					System.out.println(y + " - " + "R$ " + x);
				}
			}
		}*/
	}

	public void despesaInfo() { // imprime informações de despesa
		System.out.println("\nSALDO DE DESPESA: R$ " + getSaldoDespesa() + "\n");
		for (Double x : getDespesa()) {
			for (String y : getDescDesp()) {
				System.out.println(y.indexOf(0) + " " + y + " - " + "R$ " + x);
			}

		}

	}
	
	public void atualizaSaldoDespesa() {
		double sum = 0;
		for(Double x:getDespesa()) {
			sum += x;
		} setSaldoDespesa(sum);
	}
	
	public void atualizaSaldoReceita() {
		double sum = 0;
		for(Double x:getReceita()) {
			sum += x;
		} setSaldoReceita(sum);
	}
	
	public void atualizaSaldo() {
		double saldoAtu = getSaldoReceita() - getSaldoDespesa();
		setSaldo(saldoAtu);
	}
	

}