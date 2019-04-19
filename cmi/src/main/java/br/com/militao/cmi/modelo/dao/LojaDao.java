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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.Regional;

/**
 *
 * @author Adriano
 */
public class LojaDao {

	final Logger LOGGER = LoggerFactory.getLogger(LojaDao.class);

	public void delete(Loja loja) {
	
		String sql = "delete from loja where numero_loja=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, loja.getNumero_loja());

			stmt.executeUpdate();		

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void update(Loja loja) {
	
		String sql = "update loja set regional_id_regional=?, numero_loja=?, nome=?," + "cnpj=?, telefone=?, endereco=? where id_loja=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, loja.getRegional().getId_regional());
			stmt.setInt(2, loja.getNumero_loja());
			stmt.setString(3, loja.getNome());
			stmt.setString(4, loja.getCnpj());
			stmt.setString(5, loja.getTelefone());
			stmt.setString(6, loja.getEndereco());
			stmt.setInt(7, loja.getIdLoja());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void insert(Loja loja) {		

		String sql = "insert into loja (regional_id_regional, numero_loja, nome, cnpj, telefone, endereco)"
				+ " values (?,?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {
			
			stmt.setInt(1, loja.getRegional().getId_regional());
			stmt.setInt(2, loja.getNumero_loja());
			stmt.setString(3, loja.getNome());
			stmt.setString(4, loja.getCnpj());
			stmt.setString(5, loja.getTelefone());
			stmt.setString(6, loja.getEndereco());

			stmt.executeUpdate();


		} catch (SQLException e) {
			LOGGER.error("Erro ao inserir loja ", loja.getNome());
			throw new RuntimeException(e);
		}

	}

	public List<Loja> getList() {

		List<Loja> lojas = new ArrayList<>();
		
		String sql = "select * from loja inner join regional where regional_id_regional = id_regional";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Loja loja = new Loja();
				Regional regional = new Regional();

				loja.setIdLoja(rs.getInt("id_loja"));
				regional.setId_regional(rs.getInt("id_regional"));
				regional.setNome_regional(rs.getString("nome_regional"));
				regional.setNum_filial_base(rs.getInt("num_filial_base"));
				loja.setRegional(regional);
				loja.setNumero_loja(rs.getInt("numero_loja"));
				loja.setNome(rs.getString("nome"));
				loja.setCnpj(rs.getString("cnpj"));
				loja.setTelefone(rs.getString("telefone"));
				loja.setEndereco(rs.getString("endereco"));

				lojas.add(loja);

			}

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de Loja!!!", e);
		}

		return lojas;

	}

	public Loja getLojaPorId(int id) {
		Loja lojaProcurada = new Loja();
		List<Loja> lojas = this.getList();

		for (Loja loja : lojas) {
	
			if (loja.getIdLoja() == id) {
				lojaProcurada = loja;
			}

		}
		return lojaProcurada;

	}

}
