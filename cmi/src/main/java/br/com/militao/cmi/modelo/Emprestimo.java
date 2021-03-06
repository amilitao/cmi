/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.militao.cmi.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.militao.cmi.util.FormatadorDeData;

public class Emprestimo {

	private int id_emprestimo;
	private Loja loja;
	private Impressora impressora;
	private LocalDateTime dtInicio;
	private LocalDateTime dtFim;
	private LocalDate prazoDevolucao;
	private StatusEmprestimoEnum situacao;
	private String num_chamado;

	public Emprestimo() {
	}
	
public Emprestimo(int id) {
		this.id_emprestimo = id;
	}

	public Emprestimo(Loja loja, Impressora impressora, String num_chamado) {
		this.loja = loja;
		this.impressora = impressora;
		this.dtInicio = LocalDateTime.now();
		this.situacao = StatusEmprestimoEnum.EMISSAO_NFE;
		this.num_chamado = num_chamado;
		this.prazoDevolucao = calculaPrazoDevolucao();
	}	


	private LocalDate calculaPrazoDevolucao() {
		LocalDate hoje = LocalDate.now();
		return hoje.plusMonths(4);
	}	

	public int getId_emprestimo() {
		return id_emprestimo;
	}

	public void setId_emprestimo(int id_emprestimo) {
		this.id_emprestimo = id_emprestimo;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Impressora getImpressora() {
		return impressora;
	}

	public void setImpressora(Impressora impressora) {
		this.impressora = impressora;
	}

	public LocalDateTime getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDateTime dtFim) {
		this.dtFim = dtFim;
	}

	public void setDtInicio(LocalDateTime dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDateTime getDtInicio() {
		return dtInicio;
	}

	public String getDtInicioFormatada() {
		return FormatadorDeData.formata(dtInicio);
	}

	public String getDtFimFormatada() {
		return FormatadorDeData.formata(dtFim);
	}

	public void setPrazoDevolucao(LocalDate prazoDevolucao) {
		this.prazoDevolucao = prazoDevolucao;
	}

	public LocalDate getPrazoDevolucao() {
		return prazoDevolucao;
	}

	public String getPrazoDevolucaoFormatada() {
		return FormatadorDeData.formata(this.getPrazoDevolucao());
	}

	public StatusEmprestimoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusEmprestimoEnum situacao) {
		this.situacao = situacao;
	}

	public String getNum_chamado() {
		return num_chamado;
	}

	public void setNum_chamado(String num_chamado) {
		this.num_chamado = num_chamado;
	}

}
