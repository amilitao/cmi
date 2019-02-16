package br.com.militao.cmi.modelo.pdf;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;

public class CellRodPapeleta extends CellPapeleta{

	public CellRodPapeleta(int col, int row, String titulo, String valor) {
		super(col, row, titulo, "");
		this.setPadding(5);
		Font font30pt = new Font(FontFamily.HELVETICA, 30 );
		Paragraph rodape = new Paragraph();	
		rodape = new Paragraph(valor, font30pt);				
		rodape.setAlignment(Element.ALIGN_CENTER);
		this.addElement(rodape);
		
	}

}
