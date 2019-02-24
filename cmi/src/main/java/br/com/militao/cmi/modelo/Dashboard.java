package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.Componente;

public class Dashboard {
	
	private Componente painelStatus;	
	private Componente painelRegionais;
	
	
	public Dashboard(Componente painelStat, Componente painelReg) {
		this.painelStatus = painelStat;
		this.painelRegionais = painelReg;
	}


	public Componente getPainel() {
		return painelStatus;
	}


	public Componente getPainelRegionais() {
		return painelRegionais;
	}		
	
	

}
