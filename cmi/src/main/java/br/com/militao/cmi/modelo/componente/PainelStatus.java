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
			
			if(impressora.getSituacao() == StatusImpressora.DISPONIVEL) {
				qtdDisponivel++;
			}else if(impressora.getSituacao() == StatusImpressora.EM_EMPRESTIMO) {
				qtdEmprestimo++;
			}else if(impressora.getSituacao() == StatusImpressora.EM_MANUTENCAO) {
				qtdManutencao++;
			}else if(impressora.getSituacao() == StatusImpressora.COM_DEFEITO) {
				qtdDefeito++;
			}else{
				 throw new IllegalArgumentException("Situacao de impressora incorreta");
			}	
			
		}
		
		return this;
	}

	
}
