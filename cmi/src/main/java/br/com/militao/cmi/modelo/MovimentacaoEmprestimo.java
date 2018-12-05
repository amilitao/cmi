package br.com.militao.cmi.modelo;

import java.util.List;

import br.com.militao.cmi.modelo.dao.DevolucaoDao;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.TransporteDao;

public class MovimentacaoEmprestimo implements Movimentacao{	
	
	private EmprestimoDao empDao;
	private TransporteDao transDao;
	private DevolucaoDao devDao;	
	private Emprestimo emprestimo;
	private Transporte transporte;
	private Devolucao devolucao;
	

	public MovimentacaoEmprestimo() {
		this.empDao = new EmprestimoDao();
		this.transDao = new TransporteDao();
		this.devDao = new DevolucaoDao();
	}

	@Override
	public void relacionar(int id) {
		
		emprestimo = empDao.getEmprestimoPorId(id);		
		
		
	}

	
	
}
