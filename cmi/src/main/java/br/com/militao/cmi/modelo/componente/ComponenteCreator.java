package br.com.militao.cmi.modelo.componente;

public class ComponenteCreator {
	
	public static final int PAINEL_STATUS = 0;
	public static final int PAINEL_REGIONAL = 1;
	//adicionar os proximos componentes
	
	public Componente create(int tipoDeComponente) {
		
		//adicionar if else() para os proximos componentes
		if(tipoDeComponente == ComponenteCreator.PAINEL_STATUS) {
			return new PainelStatus();		
		}else if(tipoDeComponente == ComponenteCreator.PAINEL_REGIONAL) {
			return new PainelRegionais();
		}else {
			throw new IllegalArgumentException("Tipo de componente não suportado");
		}
		
	}

}
