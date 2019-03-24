package br.com.militao.cmi.modelo;

public class Assistencia {
	
	private int id_assistencia;
	private String razao_social;
	private String cnpj;
	private String email;
	private String telefone;
	private String endereco;
	
	
	public int getId_assistencia() {
		return id_assistencia;
	}
	public void setId_assistencia(int id_assistencia) {
		this.id_assistencia = id_assistencia;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	

}
