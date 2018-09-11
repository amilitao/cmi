package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.PainelStatus;

public class Dashboard {
	
	private PainelStatus painel;
	
	
	
	public Dashboard(PainelStatus painel) {
		this.painel = painel;
	}



	public PainelStatus getPainel() {
		return painel;
	}	
	
	

	

}
