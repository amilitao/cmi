package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.Componente;

public class Dashboard {
	
	private Componente painelStatusImpressora;	

	private Componente painelUltimasAtualizacoes;
	
	
	public Dashboard(Componente painelStat, Componente painelUltimasAtu) {
		this.painelStatusImpressora = painelStat;		
		this.painelUltimasAtualizacoes = painelUltimasAtu;
	}


	public Componente getPainelStatusImpressora() {
		return painelStatusImpressora;
	}

	

	public Componente getPainelUltimasAtualizacoes() {
		return painelUltimasAtualizacoes;
	}		
	
	

}
