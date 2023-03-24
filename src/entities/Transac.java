package entities;

public class Transac {
	private Integer id;
	private Double quant;
	private String desc;
	private String data;
	private Boolean eRenda;

	public Transac() {
	}

	public Transac(double quant, String desc, String data, boolean isRend) {
		this.quant = quant;
		this.desc = desc;
		this.data = data;
		this.eRenda = isRend;
	}

	public double getQuant() {
		return quant;
	}

	public void setQuant(double quant) {
		this.quant = quant;
	}

	public String getDesc() {
		return desc;
	}

	public void setEdsc(String desc) {
		this.desc = desc;
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
		this.quant = quant;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "R$ " + quant + " - " + testeTipo(isRend()) + " (" + data + ") - " + desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}