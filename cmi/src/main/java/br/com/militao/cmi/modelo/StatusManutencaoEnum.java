package br.com.militao.cmi.modelo;

public enum StatusManutencaoEnum {

	CANCELADO("0%","cancelado", "gray"), INICIADO("1%", "iniciado", "brown"), TESTE("20%", "aguardando teste local", "orange"), EMISSAO_NFE("30%", "aguardando nfe", "green"), 
	ENVIO("40%", "envio", "light-blue"), ORCAMENTO("45%", "lançando orçamento", "indigo"), CONTROLE_DESPESA("55%", "lançando despesa", "deep-purple"), ANALISE("65%", "em analise", "amber"),
	EM_MANUTENCAO("75%", "em manutencao", "indigo"), NOTA_PAGAMENTO("85%", "envio de nota de pagamento", "black"), ENCERRADO("100%", "encerrado", "red");
	
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
