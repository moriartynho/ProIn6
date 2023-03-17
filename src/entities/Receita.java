package entities;

public class Receita {
	
	private Double valor;
	private String desc;
	private String data;
	
	public Receita() {
	}
	
	public Receita(Double valor, String desc, String data) {
		super();
		this.valor = valor;
		this.desc = desc;
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "R$ " + valor + " - " +  desc + " (" + data + ")";
	}
	
	

}
