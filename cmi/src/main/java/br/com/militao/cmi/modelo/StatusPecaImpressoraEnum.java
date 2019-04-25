package br.com.militao.cmi.modelo;

public enum StatusPecaImpressoraEnum {

	RUIM("Ruim"), BOM("Bom"), OTIMO("Ótimo"), COM_DEFEITO("Com defeito");	
	
	private final String descricao;
	
	private StatusPecaImpressoraEnum(String desc) {
		this.descricao = desc;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
