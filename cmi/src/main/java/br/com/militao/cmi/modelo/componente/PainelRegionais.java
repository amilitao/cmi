package br.com.militao.cmi.modelo.componente;

import java.util.List;

import br.com.militao.cmi.modelo.Regional;
import br.com.militao.cmi.modelo.dao.RegionalDao;

public class PainelRegionais implements Componente {
		
	private RegionalDao regDao;
	private List<Regional> listaDeRegionais;	
	
	public PainelRegionais() {
		regDao = new RegionalDao();		
	}	
	
	
	public List<Regional> getLista() {
		return listaDeRegionais;
	}	


	@Override
	public Componente criar() {
		
		listaDeRegionais = regDao.getList();		
		
		return this;
	}

}
