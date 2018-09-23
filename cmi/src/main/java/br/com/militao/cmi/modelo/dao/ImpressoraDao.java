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
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;

/**
 *
 * @author Adriano
 */
public class ImpressoraDao implements GenericDao {

	private boolean resultado;

	public boolean delete(Object obj) {
		Impressora impressora = (Impressora) obj;
		String sql = "delete from impressora where numero=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, impressora.getNumero());

			stmt.executeUpdate();
			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public boolean update(Object obj) {
		Impressora impressora = (Impressora) obj;

		String sql = "update impressora set numero=?, modelo=?,"
				+ "pip=?, numero_serie=?, estado=?, situacao=? where id_impressora=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			
			stmt.setInt(1, impressora.getNumero());
			stmt.setString(2, impressora.getModelo());
			stmt.setInt(3, impressora.getPip());
			stmt.setString(4, impressora.getNumero_serie());
			stmt.setString(5, impressora.getEstado());
			stmt.setString(6, impressora.getSituacao());
			stmt.setInt(7, impressora.getIdImpressora());

			stmt.executeUpdate();
			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public boolean insert(Object obj) {
		Impressora impressora = (Impressora) obj;

		String sql = "insert into impressora " + "(numero,modelo,pip,numero_serie,estado,situacao)"
				+ " values (?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

		
			stmt.setInt(1, impressora.getNumero());
			stmt.setString(2, impressora.getModelo());
			stmt.setInt(3, impressora.getPip());
			stmt.setString(4, impressora.getNumero_serie());
			stmt.setString(5, impressora.getEstado());
			stmt.setString(6, impressora.getSituacao());

			stmt.executeUpdate();
			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public List<Object> getList() {

		List<Object> objImpressoras = new ArrayList<>();

		String sql = "select * from impressora order by numero;";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Impressora imp = new Impressora();
				Loja loja = new Loja();

				// id_impressora, numero, modelo, pip, numero_serie, id_loja, nome
				imp.setIdImpressora(rs.getInt("id_impressora"));
				imp.setNumero(rs.getInt("numero"));
				imp.setModelo(rs.getString("modelo"));
				imp.setPip(rs.getInt("pip"));
				imp.setNumero_serie(rs.getString("numero_serie"));
				imp.setSituacao(rs.getString("situacao"));			
			

				objImpressoras.add(imp);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return objImpressoras;
	}

	public Impressora getImpressoraPorId(int id) {
		Impressora impressoraProcurada = new Impressora();
		List<Object> impressoras = this.getList();

		for (Object imp : impressoras) {
			Impressora impressora = (Impressora) imp;
			if (impressora.getIdImpressora() == id) {
				impressoraProcurada = impressora;
			}

		}
		return impressoraProcurada;
	}
	
	
	public List<Object> getListPorStatus(String status) {
		List<Object> listaDeImpressoras = new ArrayList<>();
		Impressora imp;
		
		for(Object obj : this.getList()) {
			imp = (Impressora) obj;
			if(imp.getSituacao().equals(status)) {
				listaDeImpressoras.add(obj);
			}
		}	

		return listaDeImpressoras;
	}

}
