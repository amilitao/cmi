package br.com.militao.cmi.modelo.componente;

public class ComponenteCreator {
	
	public static final int PAINEL_STATUS = 0;
	public static final int PAINEL_ATENDIMENTO = 1;
	//adicionar os proximos componentes
	
	public Componente create(int tipoDeComponente) {
		
		//adicionar if else() para os proximos componentes
		if(tipoDeComponente == ComponenteCreator.PAINEL_STATUS) {
			return new PainelStatusImpressora();		
		}else if(tipoDeComponente == ComponenteCreator.PAINEL_ATENDIMENTO) {
			return new PainelStatusAtendimento();
		}else {
			throw new IllegalArgumentException("Tipo de componente não suportado");
		}
		
	}

}
