package services;

public class Transac {
	private double quant;
    private String desc;
    private String data;
    private boolean isRend;

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

}
