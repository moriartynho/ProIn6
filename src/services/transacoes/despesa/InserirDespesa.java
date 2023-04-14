package services.transacoes.despesa;

import entities.Conta;
import entities.Receita;
import entities.Transacao;
import services.transacoes.InsercaoDeTransacao;

public class InserirDespesa extends InsercaoDeTransacao {

	public InserirDespesa(InsercaoDeTransacao proxima) {
		super(proxima);
	}

	public void inserir(Transacao transacao, Conta conta) {
		if (transacao.getIsRend() == true) {
			conta.getReceitas().add(new Receita(null, transacao.getValor(), transacao.getDesc(), transacao.getData()));
		}
		
		proxima.inserir(transacao, conta);
	}
}
