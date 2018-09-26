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
    private LocalDateTime dtInicio;
    private LocalDateTime dtFim;   
    private StatusEmprestimo situacao;
    private String num_chamado; 
    private LocalDate prazoDevolucao;
    
    public Emprestimo() {    	
    }
    
    public Emprestimo(int id) {  
    	idEmprestimo = id;
    }

    public Emprestimo(Loja loja, Impressora impressora,  String num_chamado) {
		this.loja = loja;
		this.impressora = impressora;
		this.dtInicio = LocalDateTime.now();		
		this.situacao = StatusEmprestimo.NFE;
		this.num_chamado = num_chamado;
		this.prazoDevolucao = calculaPrazoDevolucao();
	}
    
    

	private LocalDate calculaPrazoDevolucao() {
		LocalDate hoje = LocalDate.now();
		return hoje.plusMonths(4);
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
    
    public LocalDateTime getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDateTime dtFim) {
		this.dtFim = dtFim;
	}

	
	
	public void setDtInicio(LocalDateTime dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDateTime getDtInicio() {
		return dtInicio;
	}
	
	public String getDataInicioFormatada() {
		return FormatadorDeData.formata(dtInicio);
	}
	
	public String getDataFimFormatada() {
		return FormatadorDeData.formata(dtFim);
	}
    

	public LocalDate getPrazoDevolucao() {
		return prazoDevolucao;
	}

	public void setPrazoDevolucao(LocalDate prazoDevolucao) {
		this.prazoDevolucao = prazoDevolucao;
	}	
	
	public String getPrazoDevolucaoFormatada() {
		return FormatadorDeData.formata(prazoDevolucao);
	}	

    public StatusEmprestimo getSituacao() {
    	
		return situacao;		
	}

	public void setSituacao(StatusEmprestimo situacao) {
		this.situacao = situacao;
	}

	public String getNum_chamado() {
        return num_chamado;
    }

    public void setNum_chamado(String num_chamado) {
        this.num_chamado = num_chamado;
    }
    
    
    
    
    
}
