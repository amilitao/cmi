package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.Componente;
import br.com.militao.cmi.modelo.componente.PainelStatus;

public class DashboardBuilder {
	
	private Componente painel;

	public DashboardBuilder comPainelStatus(Componente painelStatus) {
		this.painel = painelStatus;
		return this;
	}
	
	public Dashboard geraDashboard() {
		return new Dashboard(painel);
	}

}
