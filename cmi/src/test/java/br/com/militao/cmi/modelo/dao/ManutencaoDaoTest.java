package br.com.militao.cmi.modelo.dao;


import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Assistencia;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.StatusManutencaoEnum;


class ManutencaoDaoTest {

	/*@Test
	void salvarManutencao() {
			
		ManutencaoDao manuDao = new ManutencaoDao();
		Manutencao manutencao = new Manutencao();
		Assistencia assistencia = new Assistencia();
		Impressora impressora = new Impressora();
		
		assistencia.setId_assistencia(1);
		impressora.setIdImpressora(2);
		
		manutencao.setAssistencia(assistencia);
		manutencao.setImpressora(impressora);
		manutencao.setStatus_manutencao(StatusManutencaoEnum.getByDescricao("iniciado"));
		
		manuDao.insert(manutencao);		
		
	}*/
	
	@Test
	void listarManutencao() {
		
		ManutencaoDao manu = new ManutencaoDao();
		
		for(Manutencao m : manu.getList()) {
			System.out.println(m.getId_manutencao());
		}
		
	}

}
