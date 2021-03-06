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
public class Impressora {

	private int id_impressora;
	private int numero;
	private String modelo;
	private int pip;
	private String numero_serie;
	private double valor;
	private EstadoImpressoraEnum estado;
	private StatusImpressoraEnum situacao;
	private Loja loja;

	public Impressora() {}

	public Impressora(int id) {
		this.id_impressora = id;
	}	

	public int getId_impressora() {
		return id_impressora;
	}

	public void setId_impressora(int id_impressora) {
		this.id_impressora = id_impressora;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPip() {
		return pip;
	}

	public void setPip(int pip) {
		this.pip = pip;
	}

	public String getNumero_serie() {
		return numero_serie;
	}

	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}

	public double getValor() {	
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public EstadoImpressoraEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoImpressoraEnum estado) {
		this.estado = estado;
	}

	public StatusImpressoraEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusImpressoraEnum situacao) {
		this.situacao = situacao;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public String toString() {
		String numero = String.valueOf(this.getNumero());
		return numero + " - " + this.getModelo();
	}

}
