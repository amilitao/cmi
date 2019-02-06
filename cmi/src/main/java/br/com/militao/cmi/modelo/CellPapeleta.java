package br.com.militao.cmi.modelo;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;

public class CellPapeleta extends PdfPCell{

	public CellPapeleta(int col, int row, String titulo, String valor) {

		this.setColspan(col);
        this.setRowspan(row);	
        this.setPadding(5);
        this.setUseAscender(true);
        this.setUseDescender(true);		
        Paragraph p = new Paragraph(titulo);	
        this.addElement(p);
        p = new Paragraph(valor);
        p.setAlignment(Element.ALIGN_CENTER);
        this.addElement(p);			
		
	}

	
	
}
