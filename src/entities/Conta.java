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
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void setDespesa(List<Double> despesa) {
		this.despesa = despesa;
	}

	public void setReceita(List<Double> receita) {
		this.receita = receita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() { // retorna o saldo total
		saldo = getSaldoReceita() - getSaldoDespesa();
		return saldo;
	}

	public List<Double> getDespesa() {
		return despesa;
	}

	public List<Double> getReceita() {
		return receita;
	}

	public void addDespesa(Double valorRec, String descDespRec) { // Adicionar despesa
		despesa.add(valorRec);
		descDesp.add(descDespRec);
	}

	public void addReceita(Double valorRec, String descRecRec) { // Adicionar receita
		receita.add(valorRec);
		descRec.add(descRecRec);
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

	public Double getSaldoDespesa() { // retorna saldo de despesas
		double somaDesp = 0;
		for (Double x : getDespesa()) {
			somaDesp += x.doubleValue();
		}
		saldoDespesa = somaDesp;
		return saldoDespesa;
	}

	public void setSaldoDespesa(Double saldoDespesa) {
		this.saldoDespesa = saldoDespesa;

	}

	public Double getSaldoReceita() { // retorna saldo de receitas
		double somaRec = 0;
		for (Double x : getReceita()) {
			somaRec += x.doubleValue();
		}
		saldoReceita = somaRec;
		return saldoReceita;
	}

	public void setSaldoReceita(Double saldoReceita) {
		this.saldoReceita = saldoReceita;
	}

	public List<String> getDescDesp() {
		return descDesp;
	}

	public void setDescDesp(List<String> descDesp) {
		this.descDesp = descDesp;
	}

	public List<String> getDescRec() {
		return descRec;
	}

	public void setDescRec(List<String> descRec) {
		this.descRec = descRec;
	}

	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", saldo=" + saldo + ", despesa=" + despesa + ", receita=" + receita
				+ "saldoDespesa=" + saldoDespesa + "]";
	}

}
