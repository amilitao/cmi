package br.com.militao.cmi.modelo;

public enum StatusOrcamentoEnum {
	
	APROVADO("aprovado", "green"), REPROVADO("reprovado", "red"), EM_ANALISE("em análise", "orange");
	
	private String  descricao;
	private String cor;
	
	StatusOrcamentoEnum(String descricao, String cor){
		this.descricao = descricao;
		this.cor = cor;
	}	
	

	public String getDescricao() {
		return descricao;
	}


	public String getCor() {
		return cor;
	}
	
	
}
