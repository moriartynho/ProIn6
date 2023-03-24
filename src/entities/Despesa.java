package entities;

public class Despesa {
	private Integer id;
	private Double valor;
	private String desc;
	private String data;
	
	public Despesa() {
	}
	
	public Despesa(Integer id, Double valor, String desc, String data) {
		this.id = id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
