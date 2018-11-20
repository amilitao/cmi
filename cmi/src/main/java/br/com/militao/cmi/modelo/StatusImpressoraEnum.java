package br.com.militao.cmi.modelo;

public enum StatusImpressoraEnum {
	
	DISPONIVEL("disponivel", "green"), EM_EMPRESTIMO("emprestimo", "indigo"),
	EM_MANUTENCAO("manutencao", "brown"),	COM_DEFEITO("defeito", "red"),
	LOCADO_NA_REGIONAL("locado na regional", "orange");	
	
	private final String descricao;
	private final String cor;
	
	StatusImpressoraEnum(String desc, String c){
		descricao = desc;
		cor = c;
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getCor() {
		return cor;
	}
	
	
	public static StatusImpressoraEnum getByDescricao(String desc) {
		if(desc == null) 
			return null;		
		for(StatusImpressoraEnum s : StatusImpressoraEnum.values()) {
			if(s.descricao.equals(desc))
			return s;
		}
		return null;
	}

}
