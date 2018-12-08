package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.HistoricoEmprestimo;
import br.com.militao.cmi.util.FormatadorDeData;

public class HistoricoEmprestimoDao {

	public void insert(HistoricoEmprestimo historico) {

		String sql = "insert into historico_emprestimo (emprestimo_id_emprestimo, ocorrencia, dt_ocorrencia)"
				+ " values (?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, historico.getEmprestimo().getIdEmprestimo());
			stmt.setString(2, historico.getOcorrencia());
			stmt.setTimestamp(3, FormatadorDeData.toTimeStamp(historico.getDt_ocorrencia()));

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao gravar historico de emprestimo " + e);
		}

	}

	public List<HistoricoEmprestimo> getList() {
		List<HistoricoEmprestimo> historicos = new ArrayList<>();

		String sql = "select * from historico_emprestimo order by id_historico_emprestimo desc";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				HistoricoEmprestimo ocorrencia = new HistoricoEmprestimo();
				Emprestimo emprestimo = new Emprestimo();

				ocorrencia.setIdHistoricoEmprestimo(rs.getInt("id_historico_emprestimo"));
				emprestimo.setIdEmprestimo(rs.getInt("emprestimo_id_emprestimo"));
				ocorrencia.setEmprestimo(emprestimo);
				ocorrencia.setOcorrencia(rs.getString("ocorrencia"));
				ocorrencia.setDt_ocorrencia(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_ocorrencia")));

				historicos.add(ocorrencia);

			}

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de HistoricoEmprestimo!!!", e);
		}

		return historicos;

	}
	
	public List<HistoricoEmprestimo> getHistoricoPorIdEmprestimo(int id) {
		List<HistoricoEmprestimo> historicoProcurado = new ArrayList<>();
		List<HistoricoEmprestimo> historicos = this.getList();

		for (HistoricoEmprestimo historico : historicos) {
	
			if (historico.getEmprestimo().getIdEmprestimo() == id) {
				historicoProcurado.add(historico);
			}
		}
		return historicoProcurado;

	}

}
