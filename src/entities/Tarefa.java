package entities;

public class Tarefa {
	
	private String titulo;
	private String data;
	private Double valor;
	
	public Tarefa() {
	}

	public Tarefa(String titulo, String data, Double valor) {
		this.titulo = titulo;
		this.data = data;
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return titulo + " - " + valor + "- " + " - data";
	}

	
	

}
