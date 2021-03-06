package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.Orcamento;
import br.com.militao.cmi.modelo.StatusOrcamentoEnum;
import br.com.militao.cmi.modelo.dao.OrcamentoDao;
import br.com.militao.cmi.util.FormatadorDeData;

public class SalvarOrcamento implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		OrcamentoDao orcDao = new OrcamentoDao();
		Orcamento orcamento = new Orcamento();
		Manutencao manutencao = new Manutencao();	
		
		
		manutencao.setId_manutencao(Integer.parseInt(req.getParameter("id_manutencao")));
		orcamento.setManutencao(manutencao);
		orcamento.setNumero_orcamento(Integer.parseInt(req.getParameter("numeroOrcamento")));
		orcamento.setValor_total(Double.parseDouble(req.getParameter("valorTotal")));
		orcamento.setPrazo(FormatadorDeData.toLocalDate(req.getParameter("prazo")));
		orcamento.setStatus(StatusOrcamentoEnum.EM_ANALISE);
		
		orcDao.insert(orcamento);	
		
		return "redirect:controle?logica=ManutencaoDetalhada";
	}

}
