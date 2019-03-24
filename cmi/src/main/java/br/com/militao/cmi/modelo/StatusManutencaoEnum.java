package br.com.militao.cmi.modelo;

public enum StatusManutencaoEnum {

	CANCELADO("0%","cancelado", "gray"), INICIADO("1%", "iniciado", "brown"), TESTE("20%", "aguardando teste local", "orange"), EMISSAO_NFE("30%", "aguardando nfe", "green"), 
	ORCAMENTO("40%", "aguardando orçamento", "gray"), CONTROLE_DESPESA("50%", "lançando despesa", "deep-purple"), APROVADO("60%", "em analise", "amber"),
	EM_MANUTENCAO("70%", "em manutencao", "indigo"), NOTA_PAGAMENTO("80%", "envio de nota de pagamento", "black"), ENCERRADO("100%", "encerrado", "red");
	
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
