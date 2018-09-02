package br.com.militao.cmi.modelo;

import java.util.List;

import br.com.militao.cmi.modelo.componente.Componente;
import br.com.militao.cmi.modelo.componente.PainelStatus;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;

public class Dashboard {
	
	private List<Componente> componentes;
	
	
	
	public void addComponente(Componente com) {
		
		componentes.add(com);
	}
	
	public List<Componente> getList(){
		
		return componentes;
	}

	public void atualiza() {
		ImpressoraDao dao = new ImpressoraDao();
		
		componentes.set(componentes.indexOf(get("painelStatus")), new PainelStatus(dao.getList()));
		
		
	}

	public Componente get(String string) {
				
		for(Componente c : componentes) {
			if(c.getNome().equals(string)) {
				return c;
			}			
		}
		
		return null;
	}

}
