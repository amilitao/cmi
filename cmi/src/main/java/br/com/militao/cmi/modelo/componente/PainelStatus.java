package br.com.militao.cmi.modelo.componente;

import java.util.List;

import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.StatusImpressora;

public class PainelStatus implements Componente{

	private int qtdDisponivel;
	private int qtdEmprestimo;
	private int qtdManutencao;
	private int qtdDefeito;

	
	
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


	@Override
	public Componente criar(List<Object> impressoras) {
		
		for (Object imp : impressoras) {

			Impressora impressora = (Impressora) imp;
			
			if(impressora.getSituacao().equals(StatusImpressora.DISPONIVEL.getDescricao())) {
				qtdDisponivel++;
			}else if(impressora.getSituacao().equals(StatusImpressora.EM_EMPRESTIMO.getDescricao())) {
				qtdEmprestimo++;
			}else if(impressora.getSituacao().equals(StatusImpressora.EM_MANUTENCAO.getDescricao())) {
				qtdManutencao++;
			}else if(impressora.getSituacao().equals(StatusImpressora.COM_DEFEITO.getDescricao())) {
				qtdDefeito++;
			}else{
				 throw new IllegalArgumentException("Situacao de impressora incorreta");
			}	
			
		}
		
		return this;
	}

	
}
