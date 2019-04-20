package br.com.militao.cmi.modelo.componente;

import java.util.List;

import br.com.militao.cmi.modelo.HistoricoEmprestimo;
import br.com.militao.cmi.modelo.dao.HistoricoEmprestimoDao;
import br.com.militao.cmi.util.FormatadorDeData;

public class PainelUltimasAtualizacoes implements Componente {

	private int ultima_id_emprestimo;
	private String ultima_usuario;
	private String ultima_ocorrencia;
	private String ultima_dt_ocorrencia;
	private String ultima_avatar;
	private int penultima_id_emprestimo;
	private String penultima_usuario;
	private String penultima_ocorrencia;
	private String penultima_dt_ocorrencia;
	private String penultima_avatar;

	private HistoricoEmprestimoDao historicoDao;
	private List<HistoricoEmprestimo> historicos;

	public PainelUltimasAtualizacoes() {
		this.ultima_id_emprestimo = 0;
		this.ultima_usuario = "";
		this.ultima_ocorrencia = "";
		this.ultima_dt_ocorrencia = "";
		this.ultima_avatar = "";
		this.penultima_id_emprestimo = 0;
		this.penultima_usuario = "";
		this.penultima_ocorrencia = "";
		this.penultima_dt_ocorrencia = "";
		this.penultima_avatar = "";
		this.historicoDao = new HistoricoEmprestimoDao();

	}

	public int getUltima_id_emprestimo() {
		return ultima_id_emprestimo;
	}

	public int getPenultima_id_emprestimo() {
		return penultima_id_emprestimo;
	}

	public String getUltima_usuario() {
		return ultima_usuario;
	}

	public String getUltima_ocorrencia() {
		return ultima_ocorrencia;
	}

	public String getUltima_dt_ocorrencia() {
		return ultima_dt_ocorrencia;
	}

	public String getPenultima_usuario() {
		return penultima_usuario;
	}

	public String getPenultima_ocorrencia() {
		return penultima_ocorrencia;
	}

	public String getPenultima_dt_ocorrencia() {
		return penultima_dt_ocorrencia;
	}

	public HistoricoEmprestimoDao getHistoricoDao() {
		return historicoDao;
	}

	public String getUltima_avatar() {
		return ultima_avatar;
	}

	public String getPenultima_avatar() {
		return penultima_avatar;
	}

	@Override
	public Componente criar() {

		historicos = historicoDao.getList();

		this.ultima_id_emprestimo = historicos.get(0).getEmprestimo().getId_emprestimo();
		this.ultima_usuario = historicos.get(0).getUsuario().getLogin();
		this.ultima_ocorrencia = historicos.get(0).getOcorrencia();
		this.ultima_dt_ocorrencia = FormatadorDeData.formata(historicos.get(0).getDt_ocorrencia());

		if (historicos.get(0).getUsuario().getLogin().equals("sistema")) {
			this.ultima_avatar = "avatar1";
		} else {
			this.ultima_avatar = "avatar2";
		}

		this.penultima_id_emprestimo = historicos.get(1).getEmprestimo().getId_emprestimo();
		this.penultima_usuario = historicos.get(1).getUsuario().getLogin();
		this.penultima_ocorrencia = historicos.get(1).getOcorrencia();
		this.penultima_dt_ocorrencia = FormatadorDeData.formata(historicos.get(1).getDt_ocorrencia());

		if (historicos.get(1).getUsuario().getLogin().equals("sistema")) {
			this.penultima_avatar = "avatar1";
		} else {
			this.penultima_avatar = "avatar2";
		}

		return this;
	}

}
