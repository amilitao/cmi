package br.com.militao.cmi.modelo;

public class HistoricoEmprestimo {
	
	private int idHistorioEmprestimo;
	private Emprestimo emprestimo;
	private String ocorrencia;
		
	
	public HistoricoEmprestimo(Emprestimo emprestimo, String ocorrencia) {
		this.emprestimo = emprestimo;
		this.ocorrencia = ocorrencia;
	}
	public int getIdHistorioEmprestimo() {
		return idHistorioEmprestimo;
	}
	public void setIdHistorioEmprestimo(int idHistorioEmprestimo) {
		this.idHistorioEmprestimo = idHistorioEmprestimo;
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
	
	

}
