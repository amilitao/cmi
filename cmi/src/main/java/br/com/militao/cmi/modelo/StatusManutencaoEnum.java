package br.com.militao.cmi.modelo;

public enum StatusManutencaoEnum {

	CANCELADO("0%","cancelado", "gray"), INICIADO("1%", "iniciado", "brown"), TESTE("20%", "aguardando teste local", "orange"), EMISSAO_NFE("30%", "aguardando nfe", "green"), 
	SOLICITACAO_ORCAMENTO("40%", "solicitando orçamento", "light-blue"), ORCAMENTO("50%", "lançando orçamento", "gray"), CONTROLE_DESPESA("60%", "lançando despesa", "deep-purple"), ANALISE("70%", "em analise", "amber"),
	EM_MANUTENCAO("80%", "em manutencao", "indigo"), NOTA_PAGAMENTO("90%", "envio de nota de pagamento", "black"), ENCERRADO("100%", "encerrado", "red");
	
	private String porcentagem;
	private String descricao;
	private String cor; 
	
	StatusManutencaoEnum(String porcentagem, String descricao, String cor){
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
	
	public static StatusManutencaoEnum getByDescricao(String desc) {
		if(desc == null) 
			return null;		
		for(StatusManutencaoEnum s : StatusManutencaoEnum.values()) {
			if(s.descricao.equals(desc))
			return s;
		}
		return null;
	}

	
	
}
