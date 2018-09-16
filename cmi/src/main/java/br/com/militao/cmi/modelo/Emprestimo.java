/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.militao.cmi.modelo;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.militao.cmi.util.FormatadorDeData;


/**
 *
 * @author Adriano
 */
public class Emprestimo {
    
    private int idEmprestimo;
    private Loja loja;
    private Impressora impressora;
    private LocalDateTime dtAbertura;
    private LocalDateTime dtEncerramento;
    private LocalDate dtEnvio;
    private LocalDate dtDevolucao;
    private String numNotaEnvio;
    private String numNotaDevolucao;
    private String tipoTransporte;
    private String nomeTransportadora;
    private String numMinuta;
    private String situacao;
    private String num_chamado; 
    private LocalDate prazoDevolucao;
    
    public Emprestimo() {    	
    }

    public Emprestimo(Loja loja, Impressora impressora, LocalDate dtEnvio, String situacao, String num_chamado) {
		this.loja = loja;
		this.impressora = impressora;
		this.dtEnvio = dtEnvio;	
		this.situacao = situacao;
		this.num_chamado = num_chamado;
	}
    
    

	public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Impressora getImpressora() {
        return impressora;
    }

    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
    }  
    
    
    public LocalDateTime getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(LocalDateTime dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public LocalDateTime getDtEncerramento() {
		return dtEncerramento;
	}

	public void setDtEncerramento(LocalDateTime dtEncerramento) {
		this.dtEncerramento = dtEncerramento;
	}

	public String getNumNotaEnvio() {
		return numNotaEnvio;
	}

	public void setNumNotaEnvio(String numNotaEnvio) {
		this.numNotaEnvio = numNotaEnvio;
	}

	public String getNumNotaDevolucao() {
		return numNotaDevolucao;
	}

	public void setNumNotaDevolucao(String numNotaDevolucao) {
		this.numNotaDevolucao = numNotaDevolucao;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
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

	public LocalDate getPrazoDevolucao() {
		return prazoDevolucao;
	}

	public void setPrazoDevolucao(LocalDate prazoDevolucao) {
		this.prazoDevolucao = prazoDevolucao;
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
	

	public LocalDate getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(LocalDate dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNum_chamado() {
        return num_chamado;
    }

    public void setNum_chamado(String num_chamado) {
        this.num_chamado = num_chamado;
    }
    
    
    
    
    
}
