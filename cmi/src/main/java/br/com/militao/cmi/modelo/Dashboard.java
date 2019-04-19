package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.Componente;

public class Dashboard {
	
	private Componente painelStatusImpressora;	
	private Componente painelStatusAtendimento;
	private Componente painelUltimasAtualizacoes;
	
	
	public Dashboard(Componente painelStat, Componente painelAtend, Componente painelUltimasAtu) {
		this.painelStatusImpressora = painelStat;
		this.painelStatusAtendimento = painelAtend;
		this.painelUltimasAtualizacoes = painelUltimasAtu;
	}


	public Componente getPainelStatusImpressora() {
		return painelStatusImpressora;
	}


	public Componente getPainelStatusAtendimento() {
		return painelStatusAtendimento;
	}


	public Componente getPainelUltimasAtualizacoes() {
		return painelUltimasAtualizacoes;
	}		
	
	

}
