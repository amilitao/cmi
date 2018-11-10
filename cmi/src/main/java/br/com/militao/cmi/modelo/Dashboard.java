package br.com.militao.cmi.modelo;

import br.com.militao.cmi.modelo.componente.Componente;

public class Dashboard {
	
	private Componente painel;	
	
	
	public Dashboard(Componente painel) {
		this.painel = painel;
	}


	public Componente getPainel() {
		return painel;
	}		

}
