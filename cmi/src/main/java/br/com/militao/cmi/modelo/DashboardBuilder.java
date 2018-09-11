package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.PainelStatus;

public class DashboardBuilder {
	
	private PainelStatus painel;

	public DashboardBuilder comPainelStatus(PainelStatus painelStatus) {
		this.painel = painelStatus;
		return this;
	}
	
	public Dashboard geraDashboard() {
		return new Dashboard(painel);
	}

}
