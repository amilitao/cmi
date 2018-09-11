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

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.util.FormatadorDeData;

public class EmprestimoDao implements GenericDao {

	private boolean resultado;

	@Override
	public boolean delete(Object obj) {
		Emprestimo emprestimo = (Emprestimo) obj;
		String sql = "delete from emprestimo where id_emprestimo=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, emprestimo.getIdEmprestimo());
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
		Emprestimo emprestimo = (Emprestimo) obj;

		String sql = "update emprestimo set loja_id_loja=?, " + "impressora_id_impressora=?, dt_envio=?,"
				+ "dt_devolucao=?, situacao=?, num_chamado=? where id_emprestimo=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, emprestimo.getLoja().getId_loja());
			stmt.setInt(2, emprestimo.getImpressora().getId_impressora());
			stmt.setDate(3, FormatadorDeData.toDate(emprestimo.getDtEnvio()));

			if (emprestimo.getDtDevolucao() == null) {
				stmt.setDate(4, null);
			} else {
				stmt.setDate(3, FormatadorDeData.toDate(emprestimo.getDtDevolucao()));
			}

			stmt.setString(5, emprestimo.getSituacao());
			stmt.setString(6, emprestimo.getNum_chamado());
			stmt.setInt(7, emprestimo.getIdEmprestimo());

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
		Emprestimo emprestimo = (Emprestimo) obj;

		String sql = "insert into emprestimo " + "(loja_id_loja,impressora_id_impressora,dt_envio,"
				+ "situacao,num_chamado)" + "values (?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, emprestimo.getLoja().getId_loja());
			stmt.setInt(2, emprestimo.getImpressora().getId_impressora());
			stmt.setDate(3, FormatadorDeData.toDate(emprestimo.getDtEnvio()));
			stmt.setString(4, emprestimo.getSituacao());
			stmt.setString(5, emprestimo.getNum_chamado());

			stmt.executeUpdate();
			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException("Erro ao gravar emprestimo " + e);
		}

		return resultado;
	}

	@Override
	public List<Object> getList() {
		List<Object> objEmprestimos = new ArrayList<>();

		String sql = "select e.id_emprestimo, l.id_loja, l.nome, i.id_impressora, "
				+ "i.numero, dt_envio, dt_devolucao, situacao, num_chamado from emprestimo e\n"
				+ "join loja l on e.loja_id_loja = l.id_loja \n"
				+ "join impressora i on e.impressora_id_impressora = i.id_impressora;";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Emprestimo e = new Emprestimo();
				Loja loja = new Loja();
				Impressora imp = new Impressora();

				// id_impressora, numero, modelo, pip, numero_serie, id_loja, nome
				e.setIdEmprestimo(rs.getInt("id_emprestimo"));
				loja.setId_loja(rs.getInt("id_loja"));
				loja.setNome(rs.getString("nome"));
				imp.setId_impressora(rs.getInt("id_impressora"));
				imp.setNumero(rs.getInt("numero"));
				e.setDtEnvio(FormatadorDeData.toLocalDate(rs.getDate("dt_envio")));
				e.setDtDevolucao(FormatadorDeData.toLocalDate(rs.getDate("dt_devolucao")));
				e.setSituacao(rs.getString("situacao"));
				e.setNum_chamado(rs.getString("num_chamado"));
				e.setLoja(loja);
				e.setImpressora(imp);

				objEmprestimos.add(e);

			}

		} catch (SQLException s) {

			throw new RuntimeException(s);
		}

		return objEmprestimos;

	}

}
