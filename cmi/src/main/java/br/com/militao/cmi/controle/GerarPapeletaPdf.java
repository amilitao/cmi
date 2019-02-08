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
				Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 100f, 0f);
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
				
				
				cell = new PdfPCell();
				cell.setColspan(4);
				cell.setRowspan(2);
				cell.setPadding(5);
				cell.setUseAscender(true);
				cell.setUseDescender(true);
				Paragraph p5 = new Paragraph("TELEFONE:");
				cell.addElement(p5);
				p5 = new Paragraph("variavel");
				p5.setAlignment(Element.ALIGN_CENTER);
				cell.addElement(p5);
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
