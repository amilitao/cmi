package br.com.militao.cmi.modelo;

import java.time.LocalDateTime;

public class Notificacao {
	
	private int id_notificacao;
	private String descricao;
	private int vizualizado;
	private LocalDateTime dt_visualizacao;
	
	
	public int getId_notificacao() {
		return id_notificacao;
	}
	public void setId_notificacao(int id_notificacao) {
		this.id_notificacao = id_notificacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getVizualizado() {
		return vizualizado;
	}
	public void setVizualizado(int vizualizado) {
		this.vizualizado = vizualizado;
	}
	public LocalDateTime getDt_visualizacao() {
		return dt_visualizacao;
	}
	public void setDt_visualizacao(LocalDateTime dt_visualizacao) {
		this.dt_visualizacao = dt_visualizacao;
	}
	
	

}
