package br.com.militao.cmi.modelo;

import java.time.LocalDateTime;

import br.com.militao.cmi.util.FormatadorDeData;

public class HistoricoEmprestimo {
	
	private int idHistoricoEmprestimo;
	private Emprestimo emprestimo;
	private String ocorrencia;
	private LocalDateTime dt_ocorrencia;
		
		
	public HistoricoEmprestimo() {	
	this.dt_ocorrencia = LocalDateTime.now();	
	}	
	
	public HistoricoEmprestimo(Emprestimo emprestimo, String ocorrencia) {
		this.emprestimo = emprestimo;
		this.ocorrencia = ocorrencia;
		this.dt_ocorrencia = LocalDateTime.now();				
	}
	public int getIdHistoricoEmprestimo() {
		return idHistoricoEmprestimo;
	}
	public void setIdHistoricoEmprestimo(int idHistoricoEmprestimo) {
		this.idHistoricoEmprestimo = idHistoricoEmprestimo;
	}
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public String getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	public LocalDateTime getDt_ocorrencia() {
		return dt_ocorrencia;
	}
	public String getDtRegistroFormatada() {
		return FormatadorDeData.formata(dt_ocorrencia);
	}
	
	
	
	
	

}
