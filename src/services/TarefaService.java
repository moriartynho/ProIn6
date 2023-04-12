package services;

import entities.Conta;
import entities.Tarefa;

public class TarefaService {

	public void novaTarefa(Conta conta, Tarefa tarefa) {
		conta.getTarefas().add(new Tarefa(tarefa.getTitulo(), tarefa.getData(), tarefa.getValor()));
	}

	public void removerTarefa(Conta conta, Integer i) {
		int in = i - 1;
		conta.getTarefas().remove(in);
	}

	public void imrpimeTarefas(Conta conta) {
		conta.getTarefas().forEach(t -> System.out.println((conta.getTarefas().indexOf(t) + 1) + " - " + t));
	}
}
