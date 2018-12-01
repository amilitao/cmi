package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Regional;

public class RegionalDao {

	public void delete(Regional regional) {

		String sql = "delete from regional where nome_regional=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, regional.getId_regional());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao deleter regional" + e);
		}

	}

	public void update(Regional regional) {

		String sql = "update regional set nome_regional=?, num_filial_base=? where id_regional=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, regional.getNome_regional());
			stmt.setInt(2, regional.getNum_filial_base());
			stmt.setInt(3, regional.getId_regional());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao alterar regional" + e);
		}

	}

	public void insert(Regional regional) {

		String sql = "insert into regional (nome_regional, num_filial_base) values (?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, regional.getNome_regional());
			stmt.setInt(2, regional.getNum_filial_base());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao salvar em regional" + e);
		}

	}

	public List<Regional> getList() {

		List<Regional> regionais = new ArrayList<>();

		String sql = "select * from regional";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Regional regional = new Regional();

				regional.setId_regional(rs.getInt("id_regional"));
				regional.setNome_regional(rs.getString("nome_regional"));
				regional.setNum_filial_base(rs.getInt("num_filial_base"));

				regionais.add(regional);
			}

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao importar dados de regionais!!!", e);
		}

		return regionais;

	}

}
