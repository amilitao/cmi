package br.com.militao.cmi.modelo;

public class Usuario {
	
	private String login;
	private String senha;
	
	public Usuario(String login) {
		this.login = login;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
