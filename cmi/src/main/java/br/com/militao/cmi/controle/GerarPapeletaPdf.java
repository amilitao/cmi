package br.com.militao.cmi.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.pdf.PdfPTable;


import br.com.militao.cmi.modelo.pdf.TabelaPapeletaBuilder;

@WebServlet(urlPatterns = "/controle/pdf")
public class GerarPapeletaPdf extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/pdf");
		
		PapeletaPdf papeleta = new PapeletaPdf(resp.getOutputStream());	
		
				
				PdfPTable table = new TabelaPapeletaBuilder()
						.comCabecalho("ENDEREÇAMENTO")
						.comDestinatario("ATACADAO S.A")
						.comNumeroDaFilial(req.getParameter("numero_loja"))
						.comNomeDaFilial(req.getParameter("loja"))
						.comEndereco(req.getParameter("endereco"))
						.comTelefone(req.getParameter("telefone"))
						.comQuantidade(req.getParameter("modelo"))
						.comNfe(req.getParameter("nfe"))
						.comRemetente("ATACADAO S.A")
						.comEnderecoRemetente("AV. MORVAN DIAS DE FIGUEIREDO, 6169")
						.comBairroRemetente("VILA MARIA")
						.comCidadeRemetente("SÃO PAULO - SP")
						.comTelefoneRemetente("(11)2967-9570")
						.comCepRemetente("02170-901")
						.comRodape("ATENÇÃO!!! CUIDADO FRÁGIL")
						.geraTabela();
						
				papeleta.criar(table);
	}

}
