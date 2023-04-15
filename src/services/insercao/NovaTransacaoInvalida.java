package services.insercao;

import entities.Conta;
import entities.Transacao;

public class NovaTransacaoInvalida extends NovaTransacao {

	public NovaTransacaoInvalida() {
		super(null);
	}

	@Override
	public void inserir(Transacao transacao, Conta conta) {
		throw new IllegalArgumentException("Valor deve ser maior que 0");
	}

}
