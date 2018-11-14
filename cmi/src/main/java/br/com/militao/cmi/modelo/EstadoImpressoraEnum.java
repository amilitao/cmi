package br.com.militao.cmi.modelo;

public enum EstadoImpressoraEnum {
	
	BOM("Bom", "blue"),REGULAR("Regular","yellow"),
	RUIM("Ruim","orange"),PESSIMO("Pessimo","red");
	
	private String descricao;
	private String cor;
	
	EstadoImpressoraEnum(String descricao, String cor){
		this.descricao = descricao;
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCor() {
		return cor;
	}
	
	public static EstadoImpressoraEnum getByDescricao(String desc) {
		if(desc == null) 
			return null;		
		for(EstadoImpressoraEnum s : EstadoImpressoraEnum.values()) {
			if(s.descricao.equals(desc))
			return s;
		}
		return null;
	}

}
