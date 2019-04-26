package br.com.militao.cmi.modelo;

public class CheckListTeste {
	
	private String operador;
	private Manutencao manutencao;
	private String desc_problema;
	private StatusPecaImpressoraEnum status_borracha;
	private StatusPecaImpressoraEnum status_cabeca_impressao;
	private StatusPecaImpressoraEnum status_faca;
	private String observacao;
	
	
	
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public Manutencao getManutencao() {
		return manutencao;
	}
	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}
	public String getDesc_problema() {
		return desc_problema;
	}
	public void setDesc_problema(String desc_problema) {
		this.desc_problema = desc_problema;
	}
	public StatusPecaImpressoraEnum getStatus_borracha() {
		return status_borracha;
	}
	public void setStatus_borracha(StatusPecaImpressoraEnum status_borracha) {
		this.status_borracha = status_borracha;
	}
	public StatusPecaImpressoraEnum getStatus_cabeca_impressao() {
		return status_cabeca_impressao;
	}
	public void setStatus_cabeca_impressao(StatusPecaImpressoraEnum status_cabeca_impressao) {
		this.status_cabeca_impressao = status_cabeca_impressao;
	}
	public StatusPecaImpressoraEnum getStatus_faca() {
		return status_faca;
	}
	public void setStatus_faca(StatusPecaImpressoraEnum status_faca) {
		this.status_faca = status_faca;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	

}
