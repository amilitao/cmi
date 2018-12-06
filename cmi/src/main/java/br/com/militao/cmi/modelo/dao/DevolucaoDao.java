package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.util.FormatadorDeData;

public class DevolucaoDao {

	public void delete(Devolucao devolucao) {

		String sql = "delete from devolucao where id_devolucao=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, devolucao.getIdDevolucao());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void update(Devolucao devolucao) {

		String sql = "update devolucao set emprestimo_id_emprestimo=?, dt_devolucao=?,"
				+ "num_nfe_devolucao=?, recebedor=? where id_devolucao=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, devolucao.getEmprestimo().getIdEmprestimo());
			stmt.setDate(2, FormatadorDeData.toDate(devolucao.getDtDevolucao()));
			stmt.setString(3, devolucao.getNumNfeDevolucao());
			stmt.setString(4, devolucao.getRecebedor());
			stmt.setInt(5, devolucao.getIdDevolucao());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void insert(Devolucao devolucao) {

		String sql = "insert into devolucao (emprestimo_id_emprestimo, dt_devolucao,"
				+ " num_nfe_devolucao, recebedor) values (?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, devolucao.getEmprestimo().getIdEmprestimo());
			stmt.setDate(2, FormatadorDeData.toDate(devolucao.getDtDevolucao()));
			stmt.setString(3, devolucao.getNumNfeDevolucao());
			stmt.setString(4, devolucao.getRecebedor());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public List<Devolucao> getList() {
		List<Devolucao> devolucoes = new ArrayList<>();
		String sql = "select * from devolucao";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Devolucao devolucao = new Devolucao();
				Emprestimo emprestimo = new Emprestimo();

				devolucao.setIdDevolucao(rs.getInt("id_devolucao"));
				emprestimo.setIdEmprestimo(rs.getInt("emprestimo_id_emprestimo"));
				devolucao.setEmprestimo(emprestimo);
				devolucao.setDtDevolucao(FormatadorDeData.toLocalDate(rs.getDate("dt_devolucao")));
				devolucao.setNumNfeDevolucao(rs.getString("num_nfe_devolucao"));
				devolucao.setRecebedor(rs.getString("recebedor"));

				devolucoes.add(devolucao);

			}

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de Devolucao!!!", e);
		}

		return devolucoes;

	}

	public List<Devolucao> getDevolucaoPorIdEmprestimo(int id_emprestimo) {
		List<Devolucao> devolucaoProcurada = new ArrayList<>();
		List<Devolucao> devolucoes = this.getList();

		for (Devolucao devolucao : devolucoes) {
			if (devolucao.getEmprestimo().getIdEmprestimo() == id_emprestimo) {
				devolucaoProcurada.add(devolucao);
			}
		}

		return devolucaoProcurada;
	}

}
