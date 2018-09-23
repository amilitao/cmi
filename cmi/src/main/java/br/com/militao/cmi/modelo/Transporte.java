package br.com.militao.cmi.modelo;

import java.time.LocalDate;

public class Transporte {
	
	private int idTransporte;
	private Emprestimo emprestimo;
	private String nomeTransportadora;
	private String numMinuta;
	private String numControle;
	private String numNfeEnvio;
	private LocalDate dtEnvio;	
	
		
	
	public Transporte(int idTransporte, Emprestimo emprestimo, String nomeTransportadora, String numMinuta,
			String numControle, String numNfeEnvio, LocalDate dtEnvio) {
		this.idTransporte = idTransporte;
		this.emprestimo = emprestimo;
		this.nomeTransportadora = nomeTransportadora;
		this.numMinuta = numMinuta;
		this.numControle = numControle;
		this.numNfeEnvio = numNfeEnvio;
		this.dtEnvio = dtEnvio;
	}
	
	
	public int getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public String getNomeTransportadora() {
		return nomeTransportadora;
	}
	public void setNomeTransportadora(String nomeTransportadora) {
		this.nomeTransportadora = nomeTransportadora;
	}
	public String getNumMinuta() {
		return numMinuta;
	}
	public void setNumMinuta(String numMinuta) {
		this.numMinuta = numMinuta;
	}
	public String getNumControle() {
		return numControle;
	}
	public void setNumControle(String numControle) {
		this.numControle = numControle;
	}
	public String getNumNfeEnvio() {
		return numNfeEnvio;
	}
	public void setNumNfeEnvio(String numNfeEnvio) {
		this.numNfeEnvio = numNfeEnvio;
	}
	public LocalDate getDtEnvio() {
		return dtEnvio;
	}
	public void setDtEnvio(LocalDate dtEnvio) {
		this.dtEnvio = dtEnvio;
	}
	
	
	
	

}
