package entities;

public class Transac {
	private Double quant;
	private String desc;
	private String data;
	private Boolean isRend;

	public Transac() {
	}

	public Transac(double quant, String desc, String data, boolean isRend) {
		this.quant = quant;
		this.desc = desc;
		this.data = data;
		this.isRend = isRend;
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
		return isRend;
	}

	public void setRend(boolean isRend) {
		this.isRend = isRend;
	}

	public static String testeTipo(boolean tipo) {
		if (tipo == true) {
			return "Entrada";
		} else
			return "Saída";
	}

	public Boolean getIsRend() {
		return isRend;
	}

	public void setIsRend(Boolean isRend) {
		this.isRend = isRend;
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

}