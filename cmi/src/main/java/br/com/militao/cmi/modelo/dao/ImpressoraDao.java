/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.EstadoImpressoraEnum;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;

public class ImpressoraDao {

	public void delete(Impressora impressora) {

		String sql = "delete from impressora where numero=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, impressora.getNumero());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void update(Impressora impressora) {

		String sql = "update impressora set loja_id_loja=?, numero=?, modelo=?,"
				+ "pip=?, numero_serie=?, estado=?, situacao=? where id_impressora=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, impressora.getLoja().getIdLoja());
			stmt.setInt(2, impressora.getNumero());
			stmt.setString(3, impressora.getModelo());
			stmt.setInt(4, impressora.getPip());
			stmt.setString(5, impressora.getNumero_serie());
			stmt.setString(6, impressora.getEstado().getDescricao());
			stmt.setString(7, impressora.getSituacao().getDescricao());
			stmt.setInt(8, impressora.getIdImpressora());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void insert(Impressora impressora) {

		String sql = "insert into impressora (loja_id_loja,numero,modelo,pip,numero_serie,estado,situacao)"
				+ " values (?,?,?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, impressora.getLoja().getIdLoja());
			stmt.setInt(2, impressora.getNumero());
			stmt.setString(3, impressora.getModelo());
			stmt.setInt(4, impressora.getPip());
			stmt.setString(5, impressora.getNumero_serie());
			stmt.setString(6, impressora.getEstado().getDescricao());
			stmt.setString(7, impressora.getSituacao().getDescricao());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public List<Impressora> getList() {

		List<Impressora> impressoras = new ArrayList<>();

		String sql = "select * from impressora inner join loja where loja_id_loja = id_loja order by numero;";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Impressora imp = new Impressora();
				Loja loja = new Loja();

				imp.setIdImpressora(rs.getInt("id_impressora"));
				loja.setIdLoja(rs.getInt("id_loja"));
				loja.setNumero_loja(rs.getInt("numero_loja"));
				loja.setNome(rs.getString("nome"));
				imp.setLoja(loja);
				imp.setNumero(rs.getInt("numero"));
				imp.setModelo(rs.getString("modelo"));
				imp.setPip(rs.getInt("pip"));
				imp.setNumero_serie(rs.getString("numero_serie"));
				imp.setEstado(EstadoImpressoraEnum.getByDescricao(rs.getString("estado")));
				imp.setSituacao(StatusImpressoraEnum.getByDescricao(rs.getString("situacao")));

				impressoras.add(imp);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return impressoras;
	}

	public Impressora getImpressoraPorId(int id) {
		Impressora impressoraProcurada = new Impressora();
		List<Impressora> impressoras = this.getList();

		for (Impressora impressora : impressoras) {

			if (impressora.getIdImpressora() == id) {
				impressoraProcurada = impressora;
			}

		}
		return impressoraProcurada;
	}

	public List<Impressora> getListPorStatus(String status) {
		List<Impressora> listaDeImpressoras = new ArrayList<>();

		for (Impressora imp : this.getList()) {

			if (imp.getSituacao().getDescricao().equals(status)) {
				listaDeImpressoras.add(imp);
			}
		}

		return listaDeImpressoras;
	}

}
