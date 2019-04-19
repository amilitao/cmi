package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.Componente;

public class DashboardBuilder {
	
	private Componente painelStatus;
	private Componente painelRegionais;
	private Componente painelUltimasAtualizacoes;

	public DashboardBuilder comPainelStatus(Componente painelStatus) {
		
		this.painelStatus = painelStatus;		
		return this;
	}
	
	public DashboardBuilder comPainelRegionais(Componente painelRegionais) {
		
		this.painelRegionais = painelRegionais; 
		return this;
	}
	
	public DashboardBuilder comPainelUltimasAtualizacoes(Componente painelUltimasAtualizacoes) {
		this.painelUltimasAtualizacoes = painelUltimasAtualizacoes;
		return this;
	}
	
	public Dashboard geraDashboard() {
		return new Dashboard(painelStatus, painelRegionais, painelUltimasAtualizacoes);
	}

}
