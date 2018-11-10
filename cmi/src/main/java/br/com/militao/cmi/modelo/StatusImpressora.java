package br.com.militao.cmi.modelo;

public enum StatusImpressora {
	
	DISPONIVEL("disponivel"), EM_EMPRESTIMO("em_emprestimo"),EM_MANUTENCAO("em_manutencao"),
	COM_DEFEITO("com_defeito");	
	
	private final String descricao;
	
	StatusImpressora(String desc){
		descricao = desc;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
