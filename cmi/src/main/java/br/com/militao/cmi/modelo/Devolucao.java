package br.com.militao.cmi.modelo;

import java.time.LocalDate;

import br.com.militao.cmi.util.FormatadorDeData;

public class Devolucao {

	private int idDevolucao;
	private Emprestimo emprestimo;
	private LocalDate dtDevolucao;
	private String numNfeDevolucao;
	private String recebedor;
	
	public Devolucao() {
		
	}	
	
	public Devolucao(Emprestimo emprestimo, String numNfeDevolucao,	String recebedor) {
		
		this.emprestimo = emprestimo;
		this.dtDevolucao = LocalDate.now();
		this.numNfeDevolucao = numNfeDevolucao;
		this.recebedor = recebedor;
	}

	public int getIdDevolucao() {
		return idDevolucao;
	}
	public void setIdDevolucao(int idDevolucao) {
		this.idDevolucao = idDevolucao;
	}
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public LocalDate getDtDevolucao() {
		return dtDevolucao;
	}
	public void setDtDevolucao(LocalDate dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}
	
	public String getDtDevolucaoFormatada() {
		return FormatadorDeData.formata(dtDevolucao);
	}
	
	public String getNumNfeDevolucao() {
		return numNfeDevolucao;
	}
	public void setNumNfeDevolucao(String numNfeDevolucao) {
		this.numNfeDevolucao = numNfeDevolucao;
	}
	public String getRecebedor() {
		return recebedor;
	}
	public void setRecebedor(String recebedor) {
		this.recebedor = recebedor;
	}
	
	
	
	
}
