package services.transacoes;

import entities.Conta;
import entities.Transacao;

public class SemTransacao extends InsercaoDeTransacao {

	public SemTransacao() {
		super(null);
	}

	@Override
	public void inserir(Transacao transacao, Conta conta) {
		System.out.println("Nenhuma transação...");
	}

}
