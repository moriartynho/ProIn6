package services.insercao;

import entities.Conta;
import entities.Transacao;

public abstract class NovaTransacao {
	
	protected NovaTransacao proxima;

	public NovaTransacao(NovaTransacao proxima) {
		this.proxima = proxima;
	}
	
	public void efetuarInsercao(Transacao transacao, Conta conta) {
		if(verificar(transacao)) {
			inserir(transacao, conta);
		}else proxima.efetuarInsercao(transacao, conta);
		
	}
	
	protected abstract void inserir(Transacao transacao, Conta conta);
	protected abstract boolean verificar(Transacao transacao);
	
	
	
}
