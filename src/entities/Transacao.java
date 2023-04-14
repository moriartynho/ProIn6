package entities;

import entities.enums.TipoDeTransacao;

/**
 * 
 * Classe que representa uma transação realizada pelo usuário. Possui um id que
 * é passado para o Banco de Dados , possui também valor, descrição, data e tipo
 * (Receita ou Despesa)
 * 
 * @author moriartynho
 *
 */
public class Transacao {

	private Integer id;
	protected Double valor;
	protected String descricao;
	protected String data;
	protected Boolean tipoDeTransacao;

	public Transacao() {
	}

	public Transacao(Integer id, Double valor, String descricao, String data, TipoDeTransacao tipoDeTransacao) {
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
		this.data = data;
		this.setTipoDeTransacao(tipoDeTransacao);
	}

	public double getValor() {
		return valor;
	}

	public void setQuant(double quant) {
		this.valor = quant;
	}

	public String getDesc() {
		return descricao;
	}

	public void setEdsc(String desc) {
		this.descricao = desc;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setQuant(Double quant) {
		this.valor = quant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDesc(String desc) {
		this.descricao = desc;
	}
	
	public TipoDeTransacao getTipoDeTransacao() {
		return tipoDeTransacao;
	}

	public void setTipoDeTransacao(TipoDeTransacao tipoDeTransacao) {
		this.tipoDeTransacao = tipoDeTransacao;
	}

	@Override
	public String toString() {
		return "R$ " + valor + " - " + getTipoDeTransacao() + " (" + data + ") - " + descricao;
	}

	

}