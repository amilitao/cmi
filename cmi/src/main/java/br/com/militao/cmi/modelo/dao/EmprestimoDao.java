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
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;
import br.com.militao.cmi.util.FormatadorDeData;

public class EmprestimoDao {
	
	final Logger LOGGER = LoggerFactory.getLogger(EmprestimoDao.class);

	public void delete(Emprestimo emprestimo) {

		String sql = "delete from emprestimo where id_emprestimo=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, emprestimo.getId_emprestimo());
			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public void update(Emprestimo emprestimo) {

		String sql = "update emprestimo set situacao=?, impressora_id_impressora=? where id_emprestimo=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, emprestimo.getSituacao().getDescricao());		
			stmt.setInt(2, emprestimo.getImpressora().getIdImpressora());
			stmt.setInt(3, emprestimo.getId_emprestimo());

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao atualizar emprestimo!!!" + e);
		}

	}

	public void insert(Emprestimo emprestimo) {

		String sql = "insert into emprestimo (loja_id_loja,impressora_id_impressora,"
				+ "num_chamado, situacao, dt_inicio, prazo_devolucao) values (?,?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, emprestimo.getLoja().getIdLoja());
			stmt.setInt(2, emprestimo.getImpressora().getIdImpressora());
			stmt.setString(3, emprestimo.getNum_chamado());
			stmt.setString(4, emprestimo.getSituacao().getDescricao());
			stmt.setTimestamp(5, FormatadorDeData.toTimeStamp(emprestimo.getDtInicio()));
			stmt.setDate(6, FormatadorDeData.toDate(emprestimo.getPrazoDevolucao()));

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao gravar emprestimo " + e);
		}

	}

	public List<Emprestimo> getList() {
		List<Emprestimo> emprestimos = new ArrayList<>();

		String sql = "select e.id_emprestimo, e.dt_inicio, l.id_loja, l.numero_loja, l.nome, l.cnpj, l.endereco,"
				+ " l.telefone, i.id_impressora, i.numero, i.modelo,  e.num_chamado, e.situacao, e.prazo_devolucao, dt_fim "
				+ "from emprestimo e join loja l on e.loja_id_loja = l.id_loja \n"
				+ "join impressora i on e.impressora_id_impressora = i.id_impressora "
				+ "order by id_emprestimo desc;";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Emprestimo e = new Emprestimo();
				Loja loja = new Loja();
				Impressora imp = new Impressora();

				e.setId_emprestimo(rs.getInt("id_emprestimo"));
				e.setDtInicio(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_inicio")));
				loja.setIdLoja(rs.getInt("id_loja"));
				loja.setNome(rs.getString("nome"));
				loja.setNumero_loja(rs.getInt("numero_loja"));
				loja.setCnpj(rs.getString("cnpj"));
				loja.setEndereco(rs.getString("endereco"));
				loja.setTelefone(rs.getString("telefone"));
				imp.setIdImpressora(rs.getInt("id_impressora"));
				imp.setNumero(rs.getInt("numero"));
				imp.setModelo(rs.getString("modelo"));
				e.setSituacao(StatusEmprestimoEnum.getByDescricao(rs.getString("situacao")));
				e.setNum_chamado(rs.getString("num_chamado"));
				e.setPrazoDevolucao(FormatadorDeData.toLocalDate(rs.getDate("prazo_devolucao")));
				e.setDtFim(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_fim")));
				e.setLoja(loja);
				e.setImpressora(imp);

				emprestimos.add(e);

			}

		} catch (SQLException s) {

			throw new RuntimeException(s);
		}

		return emprestimos;

	}

	public Emprestimo getEmprestimoPorId(int id) {
		Emprestimo emprestimoProcurado = new Emprestimo();
		List<Emprestimo> emprestimos = this.getList();

		for (Emprestimo emprestimo : emprestimos) {

			if (emprestimo.getId_emprestimo() == id) {
				emprestimoProcurado = emprestimo;
			}

		}
		return emprestimoProcurado;
	}

}
