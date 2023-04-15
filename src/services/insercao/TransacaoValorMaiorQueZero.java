package services.insercao;

import entities.Conta;
import entities.Transacao;

public class TransacaoValorMaiorQueZero extends NovaTransacao {

	public TransacaoValorMaiorQueZero(NovaTransacao proxima) {
		super(proxima);
	}

	@Override
	public void inserir(Transacao transacao, Conta conta) {
		conta.getTransacoes().add(transacao);

	}

	@Override
	public boolean verificar(Transacao transacao) {
		return transacao.getValor() > 0;
	}

}
