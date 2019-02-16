package br.com.militao.cmi.modelo.pdf;

import com.itextpdf.text.pdf.PdfPTable;

public class TabelaPapeletaBuilder {

	private CellCabPapeleta cellcabecalho;
	private CellPapeleta cellDest;
	private CellPapeleta cellNumFilial;
	private CellPapeleta cellNomeFilial;
	private CellPapeleta cellEndereco;
	private CellPapeleta cellTelefone;
	private CellPapeleta cellQtd;
	private CellPapeleta cellNfe;
	private CellPapeleta cellRemetente;
	private CellPapeleta cellEndRemetente;
	private CellPapeleta cellBairroRemetente;
	private CellPapeleta cellCidadeRemetente;
	private CellPapeleta cellTelefoneRemetente;
	private CellPapeleta cellCepRemetente;
	private CellRodPapeleta cellRodape;
	
	
	public TabelaPapeletaBuilder comCabecalho(String var) {
		cellcabecalho = new CellCabPapeleta(8, 2, "", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comDestinatario(String var) {
		cellDest = new CellPapeleta(4, 2, "Destinatário:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comNumeroDaFilial(String var) {
		cellNumFilial = new CellPapeleta(1, 2, "Nº filial:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comNomeDaFilial(String var) {
		cellNomeFilial = new CellPapeleta(3, 2, "Nome filial:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comEndereco(String var) {
		cellEndereco = new CellPapeleta(8, 2, "Endereço:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comTelefone(String var) {
		cellTelefone = new CellPapeleta(3, 2, "Telefone:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comQuantidade(String var) {
		cellQtd = new CellPapeleta(3, 2, "Quantidade:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comNfe(String var) {
		cellNfe = new CellPapeleta(2, 2, "Numero Nfe:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comRemetente(String var) {
		cellEndRemetente = new CellPapeleta(8, 2, "Remetente:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comEnderecoRemetente(String var) {
		cellRemetente = new CellPapeleta(8, 2, "Endereço:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comBairroRemetente(String var) {
		cellBairroRemetente = new CellPapeleta(3, 2, "Bairro:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comCidadeRemetente(String var) {
		cellCidadeRemetente = new CellPapeleta(3, 2, "Cidade:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comTelefoneRemetente(String var) {
		cellTelefoneRemetente = new CellPapeleta(2, 2, "Telefone:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comCepRemetente(String var) {

		cellCepRemetente = new CellPapeleta(8, 2, "CEP:", var.toUpperCase());
		return this;
	}
	public TabelaPapeletaBuilder comRodape(String var) {
		cellRodape = new CellRodPapeleta(8, 4, "", var.toUpperCase());
		return this;
	}
	
	public PdfPTable geraTabela() {
		
		PdfPTable tabela = new PdfPTable(8);
		tabela.addCell(cellcabecalho);
		tabela.addCell(cellDest);
		tabela.addCell(cellNumFilial);
		tabela.addCell(cellNomeFilial);
		tabela.addCell(cellEndereco);
		tabela.addCell(cellTelefone);
		tabela.addCell(cellQtd);
		tabela.addCell(cellNfe);
		tabela.addCell(cellRemetente);
		tabela.addCell(cellEndRemetente);
		tabela.addCell(cellBairroRemetente);
		tabela.addCell(cellCidadeRemetente);
		tabela.addCell(cellTelefoneRemetente);
		tabela.addCell(cellCepRemetente);
		tabela.addCell(cellRodape);
		
		return tabela;
	}
	
	
	
}
