package br.com.militao.cmi.modelo;

import java.time.LocalDate;

public class Orcamento {
	
	private int id_orcamento;
	private Manutencao manutencao;
	private int numero_orcamento;
	private double valor_total;
	private LocalDate prazo;
	private boolean aprovado;
	
	
	public int getId_orcamento() {
		return id_orcamento;
	}
	public void setId_orcamento(int id_orcamento) {
		this.id_orcamento = id_orcamento;
	}
	public Manutencao getManutencao() {
		return manutencao;
	}
	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}
	public int getNumero_orcamento() {
		return numero_orcamento;
	}
	public void setNumero_orcamento(int numero_orcamento) {
		this.numero_orcamento = numero_orcamento;
	}	
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public LocalDate getPrazo() {
		return prazo;
	}
	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}
	public boolean isAprovado() {
		return aprovado;
	}
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
	
	

}
