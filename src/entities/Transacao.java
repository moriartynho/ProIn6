package entities;

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
	private Double valor;
	private String descricao;
	private String data;
	private Boolean tipo;

	public Transacao() {
	}

	public Transacao(Integer id, double quant, String desc, String data, boolean tipo) {
		this.id = id;
		this.valor = quant;
		this.descricao = desc;
		this.data = data;
		this.tipo = tipo;
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

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean isRend) {
		this.tipo = isRend;
	}

	public static String testeTipo(boolean tipo) {
		if (tipo == true) {
			return "Entrada";
		} else
			return "Saída";
	}

	public Boolean getIsRend() {
		return tipo;
	}

	public void setIsRend(Boolean isRend) {
		this.tipo = isRend;
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

	@Override
	public String toString() {
		return "R$ " + valor + " - " + testeTipo(getTipo()) + " (" + data + ") - " + descricao;
	}

}