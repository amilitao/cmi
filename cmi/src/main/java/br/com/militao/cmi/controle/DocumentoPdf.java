package br.com.militao.cmi.controle;

import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class DocumentoPdf {

	private OutputStream out;
	private Document document;

	DocumentoPdf(OutputStream ops) {
		this.out = ops;
		document = new Document(PageSize.A4.rotate());

	}

	public void criar(PdfPTable table) throws IOException {

		try {
			try {
				PdfWriter.getInstance(document, out);
				
				document.open();
				
				document.add(table);

				document.close();

			} catch (DocumentException e) {				
				e.printStackTrace();
			}
			
		} finally {
			out.close();
		}

		document.open();

	}

}
