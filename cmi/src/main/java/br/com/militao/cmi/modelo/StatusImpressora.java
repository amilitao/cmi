package br.com.militao.cmi.modelo;

public enum StatusImpressora {
	
	DISPONIVEL("disponivel"), EM_EMPRESTIMO("emprestimo"),EM_MANUTENCAO("manutencao"),
	COM_DEFEITO("defeito");	
	
	private final String descricao;
	
	StatusImpressora(String desc){
		descricao = desc;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusImpressora getByDescricao(String desc) {
		if(desc == null) 
			return null;		
		for(StatusImpressora s : StatusImpressora.values()) {
			if(s.descricao.equals(desc))
			return s;
		}
		return null;
	}

}
