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

				CellPapeleta cellDest = new CellPapeleta(4, 2, "DESTINATARIO:", req.getParameter("idEmprestimo"));
				table.addCell(cellDest);

				/*
				 * cell = new PdfPCell(); cell.setColspan(4); cell.setRowspan(2);
				 * cell.setPadding(5); cell.setUseAscender(true); cell.setUseDescender(true);
				 * Paragraph p1 = new Paragraph("DESTINATARIO:"); cell.addElement(p1); p1 = new
				 * Paragraph("variavel"); p1.setAlignment(Element.ALIGN_CENTER);
				 * cell.addElement(p1); table.addCell(cell);
				 */

				// Numero filial
				cell = new PdfPCell();
				cell.setRowspan(2);
				cell.setPadding(5);
				cell.setUseAscender(true);
				cell.setUseDescender(true);
				Paragraph p2 = new Paragraph("Nº FILIAL:");
				cell.addElement(p2);
				p2 = new Paragraph("variavel");
				p2.setAlignment(Element.ALIGN_CENTER);
				cell.addElement(p2);
				table.addCell(cell);

				cell = new PdfPCell();
				cell.setColspan(3);
				cell.setRowspan(2);
				cell.setPadding(5);
				cell.setUseAscender(true);
				cell.setUseDescender(true);
				Paragraph p3 = new Paragraph("NOME FILIAL:");
				cell.addElement(p3);
				p3 = new Paragraph("variavel");
				p3.setAlignment(Element.ALIGN_CENTER);
				cell.addElement(p3);
				table.addCell(cell);

				// segunda linha

				cell = new PdfPCell();
				cell.setColspan(4);
				cell.setRowspan(2);
				cell.setPadding(5);
				cell.setUseAscender(true);
				cell.setUseDescender(true);
				Paragraph p4 = new Paragraph("ENDEREÇO:");
				cell.addElement(p4);
				p4 = new Paragraph("variavel");
				p4.setAlignment(Element.ALIGN_CENTER);
				cell.addElement(p4);
				table.addCell(cell);

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
