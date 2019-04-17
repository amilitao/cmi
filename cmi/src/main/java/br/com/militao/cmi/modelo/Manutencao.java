package br.com.militao.cmi.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.militao.cmi.util.FormatadorDeData;

public class Manutencao {
	
	private int id_manutencao;
	private Assistencia assistencia;
	private Impressora impressora;
	private LocalDateTime dt_envio;
	private String nfe_envio;
	private LocalDateTime dt_devolucao;
	private String nfe_devolucao;
	private StatusManutencaoEnum status_manutencao;
	private int numero_despesa;
	private String nfe_pagamento;
	private LocalDate dt_inicio;
	private LocalDate dt_fim;
	
	public Manutencao() {}
	
	
	public Manutencao(Assistencia assistencia, Impressora impressora) {
		
		this.assistencia = assistencia;
		this.impressora = impressora;
		this.status_manutencao = StatusManutencaoEnum.TESTE;
		this.dt_inicio = LocalDate.now();				
		
		
	}
	
	
	public int getId_manutencao() {
		return id_manutencao;
	}
	public void setId_manutencao(int id_manutencao) {
		this.id_manutencao = id_manutencao;
	}
	public Assistencia getAssistencia() {
		return assistencia;
	}
	public void setAssistencia(Assistencia assistencia) {
		this.assistencia = assistencia;
	}
	public Impressora getImpressora() {
		return impressora;
	}
	public void setImpressora(Impressora impressora) {
		this.impressora = impressora;
	}
	public LocalDateTime getDt_envio() {
		return dt_envio;
	}
	public void setDt_envio(LocalDateTime dt_envio) {
		this.dt_envio = dt_envio;
	}
	public String getNfe_envio() {
		return nfe_envio;
	}
	public void setNfe_envio(String nfe_envio) {
		this.nfe_envio = nfe_envio;
	}
	public LocalDateTime getDt_devolucao() {
		return dt_devolucao;
	}
	public void setDt_devolucao(LocalDateTime dt_devolucao) {
		this.dt_devolucao = dt_devolucao;		
	}
	
	public String getNfe_devolucao() {
		return nfe_devolucao;
	}
	
	public void setNfe_devolucao(String nfe_devolucao) {
		this.nfe_devolucao = nfe_devolucao;
	}
	public StatusManutencaoEnum getStatus_manutencao() {
		return status_manutencao;
	}
	public void setStatus_manutencao(StatusManutencaoEnum status_manutencao) {
		this.status_manutencao = status_manutencao;
	}
	public int getNumero_despesa() {
		return numero_despesa;
	}
	public void setNumero_despesa(int numero_despesa) {
		this.numero_despesa = numero_despesa;
	}
	public String getNfe_pagamento() {
		return nfe_pagamento;
	}
	public void setNfe_pagamento(String nfe_pagamento) {
		this.nfe_pagamento = nfe_pagamento;
	}
	public LocalDate getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(LocalDate dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	
	public String getDtInicioFormatada() {
		return FormatadorDeData.formata(dt_inicio);
	}

	public String getDtFimFormatada() {
		return FormatadorDeData.formata(dt_fim);
	}

	public LocalDate getDt_fim() {
		return dt_fim;
	}
	public void setDt_fim(LocalDate dt_fim) {
		this.dt_fim = dt_fim;
	}
	
	
	
	

}
