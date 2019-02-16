package br.com.militao.cmi.modelo.pdf;

import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PapeletaPdf {

	private OutputStream out;
	private Document document;

	public PapeletaPdf(OutputStream out) {
		this.out = out;
	}

	public void criar(PdfPTable table) throws IOException {

		try {
			try {
				document = new Document(PageSize.A4.rotate());
				PdfWriter.getInstance(document, out);
				document.open();

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
