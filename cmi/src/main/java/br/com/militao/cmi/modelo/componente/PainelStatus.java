package br.com.militao.cmi.modelo.componente;

import java.util.List;

import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;

public class PainelStatus {

	private int qtdDisponivel;
	private int qtdEmprestimo;
	private int qtdManutencao;
	private int qtdDefeito;

	public PainelStatus(List<Object> i) {		
		this.carrega(i);
	}	
	

	public void carrega(List<Object> impressoras) {
		
		for (Object imp : impressoras) {

			Impressora impressora = (Impressora) imp;

			switch (impressora.getSituacao()) {
			case "disponivel":
				qtdDisponivel++;
				break;
			case "em emprestimo":
				qtdEmprestimo++;
				break;
			case "em manutencao":
				qtdManutencao++;
				break;
			case "com defeito":
				qtdDefeito++;

			}
		}

	}
	
	public int getQtdDisponivel() {
		return qtdDisponivel;
	}

	public int getQtdEmprestimo() {
		return qtdEmprestimo;
	}

	public int getQtdManutencao() {
		return qtdManutencao;
	}

	public int getQtdDefeito() {
		return qtdDefeito;
	}

	
}
