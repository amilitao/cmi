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
import br.com.militao.cmi.modelo.Loja;

/**
 *
 * @author Adriano
 */
public class LojaDao implements GenericDao {

	private boolean resultado;

	public boolean delete(Object obj) {
		Loja loja = (Loja) obj;
		String sql = "delete from loja where numero_loja=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, loja.getNumero_loja());

			stmt.executeUpdate();

			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public boolean update(Object obj) {
		Loja loja = (Loja) obj;
		String sql = "update loja set numero_loja=?, nome=?," + "cnpj=?, telefone=?, endereco=? where id_loja=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, loja.getNumero_loja());
			stmt.setString(2, loja.getNome());
			stmt.setString(3, loja.getCnpj());
			stmt.setString(4, loja.getTelefone());
			stmt.setString(5, loja.getEndereco());
			stmt.setInt(6, loja.getIdLoja());

			stmt.executeUpdate();

			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}
		return resultado;
	}

	public boolean insert(Object obj) {
		Loja loja = (Loja) obj;

		String sql = "insert into loja " + "(numero_loja, nome, cnpj, telefone, endereco)" + " values (?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, loja.getNumero_loja());
			stmt.setString(2, loja.getNome());
			stmt.setString(3, loja.getCnpj());
			stmt.setString(4, loja.getTelefone());
			stmt.setString(5, loja.getEndereco());

			stmt.executeUpdate();

			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}
		return resultado;
	}

	public List<Object> getList() {

		List<Object> objLojas = new ArrayList<>();
		String sql = "select * from loja";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Loja loja = new Loja();

				loja.setIdLoja(rs.getInt("id_loja"));
				loja.setNumero_loja(rs.getInt("numero_loja"));
				loja.setNome(rs.getString("nome"));
				loja.setCnpj(rs.getString("cnpj"));
				loja.setTelefone(rs.getString("telefone"));
				loja.setEndereco(rs.getString("endereco"));

				objLojas.add(loja);

			}

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de Loja!!!", e);
		}

		return objLojas;

	}

	public Loja getLojaPorId(int id) {
		Loja lojaProcurada = new Loja();
		List<Object> lojas = this.getList();

		for (Object loj : lojas) {
			Loja loja = (Loja) loj;
			if (loja.getIdLoja() == id) {
				lojaProcurada = loja;
			}

		}
		return lojaProcurada;

	}

}
