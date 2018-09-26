package br.com.militao.cmi.modelo;

public enum StatusEmprestimo {
	
	INICIO("1%", "iniciado"), NFE("25%", "aguardando nfe"), 
	TRANSPORTE("40%", "aguardando transporte"), ENTREGA("60%", "em transporte"),
	DEVOLUCAO("80%", "em emprestimo"), FIM("100%", "encerrado");
	
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
