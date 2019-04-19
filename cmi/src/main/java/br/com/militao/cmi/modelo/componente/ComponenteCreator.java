package br.com.militao.cmi.modelo.componente;

public class ComponenteCreator {
	
	public static final int PAINEL_STATUS = 0;
	public static final int PAINEL_ATENDIMENTO = 1;
	public static final int PAINEL_ULT_ATUALIZACOES = 2;
	//adicionar os proximos componentes
	
	public Componente create(int tipoDeComponente) {
		
		//adicionar if else() para os proximos componentes
		if(tipoDeComponente == ComponenteCreator.PAINEL_STATUS) {
			return new PainelStatusImpressora();		
		}else if(tipoDeComponente == ComponenteCreator.PAINEL_ATENDIMENTO) {
			return new PainelStatusAtendimento();
		}else if(tipoDeComponente == ComponenteCreator.PAINEL_ULT_ATUALIZACOES){
			return new PainelUltimasAtualizacoes();
		}else {
			throw new IllegalArgumentException("Tipo de componente não suportado");
		}
		
	}

}
