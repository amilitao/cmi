package br.com.militao.cmi.modelo.pdf;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;

public class CellCabPapeleta extends CellPapeleta{

	public CellCabPapeleta(int col, int row, String titulo, String valor) {
		super(col, row, titulo, "");	
		
		this.setPadding(5);
		Font font16pt = new Font(FontFamily.HELVETICA, 16 );
		Paragraph rodape = new Paragraph();	
		rodape = new Paragraph(valor, font16pt);				
		rodape.setAlignment(Element.ALIGN_CENTER);
		this.addElement(rodape);
	}

}
