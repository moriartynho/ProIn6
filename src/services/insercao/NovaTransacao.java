package services.insercao;

import entities.Conta;
import entities.Transacao;

public abstract class NovaTransacao {
	
	protected NovaTransacao proxima;

	public NovaTransacao(NovaTransacao proxima) {
		this.proxima = proxima;
	}
	
	public abstract void inserir(Transacao transacao, Conta conta);
	
	
}
