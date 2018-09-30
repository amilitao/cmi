package br.com.militao.cmi.modelo;

public enum StatusEmprestimo {
	
	INICIADO("1%", "iniciado"), EMISSAO_NFE("25%", "aguardando nfe"), 
	AGUARDANDO_TRANSPORTE("40%", "aguardando transporte"), ENVIADO("60%", "em transporte"),
	EM_EMPRESTIMO("75%", "em emprestimo"), ENCERRADO("100%", "encerrado");
	
	public String porcentagem;
	public String descricao;
	
	StatusEmprestimo(String porcentagem, String descricao){
		this.porcentagem = porcentagem;
		this.descricao = descricao;
	}

	public String getPorcentagem() {
		return porcentagem;
	}

	public String getDescricao() {
		return descricao;
	}	
	
	
	

}
