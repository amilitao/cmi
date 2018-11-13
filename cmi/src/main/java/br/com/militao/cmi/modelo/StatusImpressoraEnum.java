package br.com.militao.cmi.modelo;

public enum StatusImpressoraEnum {
	
	DISPONIVEL("disponivel"), EM_EMPRESTIMO("emprestimo"),EM_MANUTENCAO("manutencao"),
	COM_DEFEITO("defeito");	
	
	private final String descricao;
	
	StatusImpressoraEnum(String desc){
		descricao = desc;
	}
	
	public String getDescricao() {
		return descricao;
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
