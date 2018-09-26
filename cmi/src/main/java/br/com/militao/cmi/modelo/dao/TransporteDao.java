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

public class TransporteDao implements GenericDao{

	private boolean resultado;
	
	@Override
	public boolean delete(Object obj) {
		Transporte transporte = (Transporte) obj;
		String sql = "delete from transporte where id_transporte=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, transporte.getIdTransporte());

			stmt.executeUpdate();

			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}

		return resultado;
	}

	@Override
	public boolean update(Object obj) {
		Transporte transporte = (Transporte) obj;
		String sql = "update transporte set nome_transportadora=?, num_controle=?,"
				+ " num_nfe_envio=? where id_transporte=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, transporte.getNomeTransportadora());		
			stmt.setString(2, transporte.getNumControle());
			stmt.setString(3, transporte.getNumNfeEnvio());
			stmt.setInt(4, transporte.getIdTransporte());
			

			stmt.executeUpdate();

			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}
		return resultado;
	}

	@Override
	public boolean insert(Object obj) {
		Transporte transporte = (Transporte) obj;
		
		String sql = "insert into transporte (emprestimo_id_emprestimo, nome_transportadora, "
				+ "num_controle, num_nfe_envio, dt_envio)" + " values (?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, transporte.getEmprestimo().getIdEmprestimo());
			stmt.setString(2, transporte.getNomeTransportadora());		
			stmt.setString(3, transporte.getNumControle());
			stmt.setString(4, transporte.getNumNfeEnvio());
			stmt.setDate(5, FormatadorDeData.toDate(transporte.getDtEnvio()));

			stmt.executeUpdate();

			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}
		return resultado;
	}

	@Override
	public List<Object> getList() {
		List<Object> transportes = new ArrayList<>();
		String sql = "select * from transporte";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Transporte transporte = new Transporte();
				

				transporte.setIdTransporte(rs.getInt("id_transporte"));
				transporte.setEmprestimo(new Emprestimo(rs.getInt("emprestimo_id_emprestimo")));
				transporte.setNomeTransportadora(rs.getString("nome_transportadora"));			
				transporte.setNumControle(rs.getString("num_controle"));
				transporte.setNumNfeEnvio(rs.getString("num_nfe_envio"));
				transporte.setDtEnvio(FormatadorDeData.toLocalDate(rs.getDate("dt_envio")));

				transportes.add(transporte);

			}

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de transporte!!!", e);
		}

		return transportes;
	}

}
