package entities;

public class Transac {
	private Integer id;
	private Double valor;
	private String descricao;
	private String data;
	private Boolean eRenda;

	public Transac() {
	}

	public Transac(Integer id, double quant, String desc, String data, boolean isRend) {
		this.id = id;
		this.valor = quant;
		this.descricao = desc;
		this.data = data;
		this.eRenda = isRend;
	}

	public double getQuant() {
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

	public boolean isRend() {
		return eRenda;
	}

	public void setRend(boolean isRend) {
		this.eRenda = isRend;
	}

	public static String testeTipo(boolean tipo) {
		if (tipo == true) {
			return "Entrada";
		} else
			return "Saída";
	}

	public Boolean getIsRend() {
		return eRenda;
	}

	public void setIsRend(Boolean isRend) {
		this.eRenda = isRend;
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
		return "R$ " + valor + " - " + testeTipo(isRend()) + " (" + data + ") - " + descricao;
	}

}