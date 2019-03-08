 package br.com.militao.cmi.modelo;

public class Usuario {
	
	private int id_usuario;
	private String login;
	private String senha;	
		
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
	public String getSenha() {
		return senha;
	}
	
	@Override
	public String toString() {
		
		return this.getLogin();
	}

}
