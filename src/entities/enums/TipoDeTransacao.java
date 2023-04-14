package entities.enums;

public enum TipoDeTransacao {

	RECEITA(true), DESPESA(false);

	private Boolean tipo;

	TipoDeTransacao(boolean tipo) {
		this.setTipo(tipo);
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

}
