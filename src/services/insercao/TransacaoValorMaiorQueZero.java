package services.insercao;

import entities.Conta;
import entities.Transacao;

public class TransacaoValorMaiorQueZero extends NovaTransacao {

	public TransacaoValorMaiorQueZero(NovaTransacao proxima) {
		super(proxima);
	}

	@Override
	public void inserir(Transacao transacao, Conta conta) {
		if (transacao.getValor() >= 0) {

			conta.getTransacoes().add(transacao);

		} else proxima.inserir(transacao, conta);
			
	}

}
