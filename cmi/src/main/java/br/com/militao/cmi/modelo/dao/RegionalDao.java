package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Regional;

public class RegionalDao implements GenericDao {
	
	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> getList() {
		List<Object> regionais = new ArrayList<>();
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

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de regionais!!!", e);
		}

		return regionais;

	}

}
