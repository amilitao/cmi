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
    
    private int idImpressora;  
    private int numero;
    private String modelo;
    private int pip;
    private String numero_serie;
    private EstadoImpressoraEnum estado;
    private StatusImpressoraEnum situacao;
    private Loja loja;
    
   

    public int getIdImpressora() {
        return idImpressora;
    }

    public void setIdImpressora(int id_impressora) {
        this.idImpressora = id_impressora;
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
