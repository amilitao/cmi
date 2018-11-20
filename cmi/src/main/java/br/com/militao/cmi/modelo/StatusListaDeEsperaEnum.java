package br.com.militao.cmi.modelo;

public enum StatusListaDeEsperaEnum {
	
	ATENDIDO("atendido", "blue"), AGUARDANDO("aguardando", "orange"),
	CANCELADO("cancelado", "red");
	
	
	private final String descricao;
	private final String cor;
	
	private StatusListaDeEsperaEnum(String desc, String cor) {
		this.descricao = desc;
		this.cor = cor;			
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCor() {
		return cor;
	}
	
	public static StatusListaDeEsperaEnum getByDescricao(String desc) {
		if(desc == null) 
			return null;		
		for(StatusListaDeEsperaEnum s : StatusListaDeEsperaEnum.values()) {
			if(s.descricao.equals(desc))
			return s;
		}
		return null;
	}
	

}
