package entities;

import entities.enums.TipoDeTransacao;

public class Despesa extends Transacao {

	public Despesa(Integer id, Double valor, String descricao, String data, TipoDeTransacao tipoDeTransacao) {
		super(id, valor, descricao, data, tipoDeTransacao);
	}

	@Override
	public String toString() {
		return "R$ " + valor + " - " + descricao + " (" + data + ")";
	}

}
