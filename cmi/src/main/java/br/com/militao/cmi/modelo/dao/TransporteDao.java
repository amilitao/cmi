package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Transporte;
import br.com.militao.cmi.util.FormatadorDeData;

public class TransporteDao {

	public void delete(Transporte transporte) {

		String sql = "delete from transporte where id_transporte=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, transporte.getIdTransporte());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void update(Transporte transporte) {

		String sql = "update transporte set nome_transportadora=?," + " num_nfe_envio=? where id_transporte=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, transporte.getNomeTransportadora());
			stmt.setString(2, transporte.getNumNfeEnvio());
			stmt.setInt(3, transporte.getIdTransporte());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void insert(Transporte transporte) {

		String sql = "insert into transporte (emprestimo_id_emprestimo, nome_transportadora, "
				+ "num_nfe_envio, dt_envio)" + " values (?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, transporte.getEmprestimo().getIdEmprestimo());
			stmt.setString(2, transporte.getNomeTransportadora());
			stmt.setString(3, transporte.getNumNfeEnvio());
			stmt.setDate(4, FormatadorDeData.toDate(transporte.getDtEnvio()));

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public List<Transporte> getList() {

		List<Transporte> transportes = new ArrayList<>();

		String sql = "select * from transporte";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Transporte transporte = new Transporte();
				Emprestimo emprestimo = new Emprestimo();

				transporte.setIdTransporte(rs.getInt("id_transporte"));
				emprestimo.setIdEmprestimo(rs.getInt("emprestimo_id_emprestimo"));
				transporte.setEmprestimo(emprestimo);
				transporte.setNomeTransportadora(rs.getString("nome_transportadora"));
				transporte.setNumNfeEnvio(rs.getString("num_nfe_envio"));
				transporte.setDtEnvio(FormatadorDeData.toLocalDate(rs.getDate("dt_envio")));

				transportes.add(transporte);

			}

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao importar dados de transporte!!!", e);
		}

		return transportes;
	}

	public List<Transporte> getTransportePorIdEmprestimo(int id_emprestimo) {
		List<Transporte> transporteProcurado = new ArrayList<>();
		List<Transporte> transportes = this.getList();

		for (Transporte transporte : transportes) {
			if (transporte.getEmprestimo().getIdEmprestimo() == id_emprestimo) {
				transporteProcurado.add(transporte);
			}
		}

		return transporteProcurado;
	}

}
