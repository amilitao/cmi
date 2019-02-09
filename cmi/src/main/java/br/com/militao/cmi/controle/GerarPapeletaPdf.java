package br.com.militao.cmi.controle;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.militao.cmi.modelo.CellPapeleta;

@WebServlet(urlPatterns = "/controle/pdf")
public class GerarPapeletaPdf extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/pdf");

		OutputStream out = resp.getOutputStream();

		try {
			try {
				Document document = new Document(PageSize.A4.rotate());
				PdfWriter.getInstance(document, out);
				document.open();

				PdfPTable table = new PdfPTable(8);

				// Cabeçalho
				PdfPCell cell = new PdfPCell(new Phrase("ENDEREÇAMENTO"));
				cell.setColspan(8);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				// Destinatario
				CellPapeleta cellDest = new CellPapeleta(4, 2, "Destinatário:", "ATACADAO S.A");
				table.addCell(cellDest);				

				// Numero filial
				CellPapeleta cellNumFilial = new CellPapeleta(1,2, "Nº filial:", req.getParameter("numero_loja"));
				table.addCell(cellNumFilial);
				
				// Nome da filial
				CellPapeleta cellNomeFilial = new CellPapeleta(3, 2, "Nome filial", req.getParameter("loja").toUpperCase());
				table.addCell(cellNomeFilial);				

				// endereço
				CellPapeleta cellEndereco = new CellPapeleta(8, 2, "Endereço:", req.getParameter("endereco").toUpperCase());				
				table.addCell(cellEndereco);
				
				// telefone
				CellPapeleta cellTelefone = new CellPapeleta(3, 2, "Telefone:", req.getParameter("telefone").toUpperCase());
				table.addCell(cellTelefone);				
				
				// Quantidade
				CellPapeleta cellQtd = new CellPapeleta(3, 2, "Quantidade:", "1 " + req.getParameter("modelo").toUpperCase());
				table.addCell(cellQtd);
				
				// Numero da nota fiscal
				CellPapeleta cellNfe = new CellPapeleta(2, 2, "Numero Nfe:", req.getParameter("nfe").toUpperCase());
				table.addCell(cellNfe);	

				// Remetente
				CellPapeleta cellRemetente = new CellPapeleta(8, 2, "Remetente:", "ATACADAO S.A");
				table.addCell(cellRemetente);	
				
				// Endereço remetente
				CellPapeleta cellEndRemetente = new CellPapeleta(8, 2, "Endereço:", "AV. MORVAN DIAS DE FIGUEIREDO, 6169");
				table.addCell(cellEndRemetente);	
				
				// bairro remetente
				CellPapeleta cellBairroRemetente = new CellPapeleta(3, 2, "Bairro:", "VILA MARIA");
				table.addCell(cellBairroRemetente);
				
				// cidade remetente
				CellPapeleta cellCidadeRemetente = new CellPapeleta(3, 2, "Cidade:", "SÃO PAULO - SP");
				table.addCell(cellCidadeRemetente);
				
				// telefone remetente
				CellPapeleta cellTelefoneRemetente = new CellPapeleta(2, 2, "Telefone:", "(11)2967-9570");
				table.addCell(cellTelefoneRemetente);
				
				// telefone remetente
				CellPapeleta cellCepRemetente = new CellPapeleta(8, 2, "Cep:", "02170-901");
				table.addCell(cellCepRemetente);
				
				// Rodape
				cell = new PdfPCell();
				cell.setColspan(8);		
				cell.setPadding(5);
				cell.setUseAscender(true);
				cell.setUseDescender(true);
				Font font22pt = new Font(FontFamily.HELVETICA, 22 );
				Paragraph rodape = new Paragraph();	
				rodape = new Paragraph("ATENÇÃO!!! CUIDADO FRÁGIL", font22pt);				
				rodape.setAlignment(Element.ALIGN_CENTER);
				cell.addElement(rodape);
				table.addCell(cell);
				
				
				document.add(table);

				document.close();

			} catch (Exception ex) {
				ex.getMessage();
			}
		} finally {
			out.close();
		}
	}

}
