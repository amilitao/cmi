/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.militao.cmi.modelo;

/**
 *
 * @author Adriano
 */
public class Loja {

	private int id_loja;
	private int numero_loja;
	private String nome;
	private String cnpj;
	private String telefone;
	private String endereco;
	private Regional regional;

	public Loja() {
	}

	public Loja(int id) {
		this.id_loja = id;
	}
	

	public int getId_loja() {
		return id_loja;
	}

	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}

	public int getNumero_loja() {
		return numero_loja;
	}

	public void setNumero_loja(int numero_loja) {
		this.numero_loja = numero_loja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	@Override
	public String toString() {
		String numero = String.valueOf(this.getNumero_loja());
		return numero + " - " + this.getNome();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (!(o instanceof Loja)) {
			return false;
		}
		Loja loja = (Loja) o;
		if (id_loja != loja.id_loja) {
			return false;
		}
		if (nome != null ? !nome.equals(loja.nome) : loja.nome != null) {
			return false;
		}
		return true;
	}

	// @Override
	// public int hashCode() {
	// int hash = 3;
	// hash = 89 * hash + (this.nome != null ? this.nome.hashCode() : 0);
	// return hash;
	// }
	//
}
