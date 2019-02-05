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


@WebServlet(urlPatterns="/controle/pdf")
public class PapeletaPdf extends HttpServlet{	

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
				
				 PdfPTable table = new PdfPTable(3);
				 
			        PdfPCell cell = new PdfPCell(new Phrase("ENDEREÇAMENTO"));
			        cell.setColspan(3);
			        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(cell);      
			       
			        
			        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
			        cell.setRowspan(2);			        
			        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        table.addCell(cell);
			        table.addCell("Cell 1.1");
			        
			        cell = new PdfPCell();
			        cell.addElement(new Phrase("Cell 1.2"));
			        table.addCell(cell);
			        
			        cell = new PdfPCell(new Phrase("Cell 2.1"));
			        cell.setPadding(5);
			        cell.setUseAscender(true);
			        cell.setUseDescender(true);
			        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(cell);
			        
			        cell = new PdfPCell();
			        cell.setPadding(5);
			        cell.setUseAscender(true);
			        cell.setUseDescender(true);
			        
			        Paragraph p = new Paragraph("Cell 2.2");
			        p.setAlignment(Element.ALIGN_CENTER);
			        cell.addElement(p);
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
