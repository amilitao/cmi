package br.com.militao.cmi.modelo;

public class Assistencia {
	
	private int id_assistencia;
	private String razao_social;
	private String cnpj;
	private String email;
	private String telefone_assistencia;
	private String endereco;
	
	public Assistencia() {}
	
	public Assistencia(int id) {
		this.id_assistencia = id;
	}
	
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
	
	public String getTelefone_assistencia() {
		return telefone_assistencia;
	}

	public void setTelefone_assistencia(String telefone_assistencia) {
		this.telefone_assistencia = telefone_assistencia;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {		
		return this.razao_social;
	}
	
	
	

}
