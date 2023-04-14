package services.transacoes;

import entities.Conta;
import entities.Transacao;

public abstract class InsercaoDeTransacao {

	protected InsercaoDeTransacao proxima;

	public InsercaoDeTransacao(InsercaoDeTransacao proxima) {
		this.proxima = proxima;
	}

	public abstract void inserir(Transacao transacao, Conta conta);

}
