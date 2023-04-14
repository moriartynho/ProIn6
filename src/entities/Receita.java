package entities;

import entities.enums.TipoDeTransacao;

public class Receita extends Transacao {

	public Receita(Integer id, Double valor, String descricao, String data, TipoDeTransacao tipoDeTransacao) {
		super(id, valor, descricao, data, tipoDeTransacao);
	}

	@Override
	public String toString() {
		return "R$ " + valor + " - " + descricao + " (" + data + ")";
	}

}
