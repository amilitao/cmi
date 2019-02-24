package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.Componente;

public class Dashboard {
	
	private Componente painelStatusImpressora;	
	private Componente painelStatusAtendimento;
	
	
	public Dashboard(Componente painelStat, Componente painelAtend) {
		this.painelStatusImpressora = painelStat;
		this.painelStatusAtendimento = painelAtend;
	}


	public Componente getPainelStatusImpressora() {
		return painelStatusImpressora;
	}


	public Componente getPainelStatusAtendimento() {
		return painelStatusAtendimento;
	}		
	
	

}
