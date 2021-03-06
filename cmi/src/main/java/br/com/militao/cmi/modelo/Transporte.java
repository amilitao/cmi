package br.com.militao.cmi.modelo;

import java.time.LocalDate;

import br.com.militao.cmi.util.FormatadorDeData;

public class Transporte {

	private int idTransporte;
	private Emprestimo emprestimo;
	private String nomeTransportadora;	
	private String numNfeEnvio;
	private LocalDate dtEnvio;

	public Transporte() {
	}

	public Transporte(Emprestimo emprestimo, String nomeTransportadora, String numNfeEnvio,
			LocalDate dtEnvio) {

		this.emprestimo = emprestimo;
		this.nomeTransportadora = nomeTransportadora;
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

	public String getDtEnvioFormatada() {
		return FormatadorDeData.formata(dtEnvio);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (!(o instanceof Transporte)) {
			return false;
		}
		Transporte transporte = (Transporte) o;
		if (idTransporte != transporte.idTransporte) {
			return false;
		}
		if (nomeTransportadora != null ? !nomeTransportadora.equals(transporte.nomeTransportadora)
				: transporte.nomeTransportadora != null) {
			return false;
		}
		return true;
	}

}
