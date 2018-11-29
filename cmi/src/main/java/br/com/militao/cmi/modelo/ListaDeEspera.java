package br.com.militao.cmi.modelo;

public class ListaDeEspera {

	private int id_reserva;
	private Loja loja;
	private StatusListaDeEsperaEnum status;
	

	public ListaDeEspera() {
	}

	public ListaDeEspera(Loja loja, StatusListaDeEsperaEnum status) {
		this.loja = loja;
		this.status = status;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public StatusListaDeEsperaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusListaDeEsperaEnum status) {
		this.status = status;
	}

}