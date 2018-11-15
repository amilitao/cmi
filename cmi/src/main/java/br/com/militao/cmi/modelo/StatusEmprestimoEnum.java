package br.com.militao.cmi.modelo;

public enum StatusEmprestimoEnum {
	
	INICIADO("1%", "iniciado", "brown"), EMISSAO_NFE("25%", "aguardando nfe", "green"), 
	AGUARDANDO_TRANSPORTE("40%", "aguardando transporte", "deep-purple"), ENVIADO("60%", "em transporte", "amber"),
	EM_EMPRESTIMO("75%", "em emprestimo", "green"), ENCERRADO("100%", "encerrado", "red");
	
	private String porcentagem;
	private String descricao;
	private String cor; 
	
	StatusEmprestimoEnum(String porcentagem, String descricao, String cor){
		this.porcentagem = porcentagem;
		this.descricao = descricao;
		this.cor = cor;
	}

	public String getPorcentagem() {
		return porcentagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCor() {
		return cor;
	}	
	
	public static StatusEmprestimoEnum getByDescricao(String desc) {
		if(desc == null) 
			return null;		
		for(StatusEmprestimoEnum s : StatusEmprestimoEnum.values()) {
			if(s.descricao.equals(desc))
			return s;
		}
		return null;
	}

	
	
	
	

}
