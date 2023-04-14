package services.transacoes.receita;

import entities.Conta;
import entities.Despesa;
import entities.Transacao;
import services.transacoes.InsercaoDeTransacao;

public class InserirReceita extends InsercaoDeTransacao {

	public InserirReceita(InsercaoDeTransacao proxima) {
		super(proxima);
	}

	public void inserir(Transacao transacao, Conta conta) {
		if (transacao.getIsRend() == false) {
			conta.getDespesas().add(new Despesa(null, transacao.getValor(), transacao.getDesc(), transacao.getData()));
		}

	}
}
