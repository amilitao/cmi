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
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.HistoricoEmprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;
import br.com.militao.cmi.util.FormatadorDeData;


public class EmprestimoDao implements GenericDao {

	private boolean resultado;
	private HistoricoEmprestimoDao historicoDao;

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

		String sql = "update emprestimo set situacao=?, dt_fim=? where id_emprestimo=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, emprestimo.getSituacao().name());
			stmt.setTimestamp(2, FormatadorDeData.toTimeStamp(emprestimo.getDtFim()));
			stmt.setInt(3, emprestimo.getIdEmprestimo());

			stmt.executeUpdate();
			
			resultado = true;

		} catch (

		SQLException e) {
			resultado = false;
			throw new RuntimeException(e);
		}

		return resultado;
	}

	@Override
	public boolean insert(Object obj) {
		Emprestimo emprestimo = (Emprestimo) obj;

		String sql = "insert into emprestimo " + "(loja_id_loja,impressora_id_impressora,"
				+ "num_chamado, situacao, dt_inicio, prazo_devolucao)" + "values (?,?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			stmt.setInt(1, emprestimo.getLoja().getIdLoja());
			stmt.setInt(2, emprestimo.getImpressora().getIdImpressora());
			stmt.setString(3, emprestimo.getNum_chamado());
			stmt.setString(4, emprestimo.getSituacao().getDescricao());
			stmt.setTimestamp(5, FormatadorDeData.toTimeStamp(emprestimo.getDtInicio()));
			stmt.setDate(6, FormatadorDeData.toDate(emprestimo.getPrazoDevolucao()));

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				historicoDao = new HistoricoEmprestimoDao();
				int idEmp = rs.getInt(1);

				if (idEmp != 0) {
					emprestimo.setIdEmprestimo(idEmp);
					String ocorrencia = "O emprestimo numero " + idEmp + " foi criado em " + LocalDateTime.now();
					historicoDao.insert(new HistoricoEmprestimo(emprestimo, ocorrencia));
				}
			}

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

		String sql = "select e.id_emprestimo, e.dt_inicio, l.id_loja, l.numero_loja, l.nome, l.cnpj, i.id_impressora, "
				+ "i.numero, i.modelo,  e.num_chamado, e.situacao, e.prazo_devolucao, dt_fim from emprestimo e\n"
				+ "join loja l on e.loja_id_loja = l.id_loja \n"
				+ "join impressora i on e.impressora_id_impressora = i.id_impressora " + "order by id_emprestimo desc;";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Emprestimo e = new Emprestimo();
				Loja loja = new Loja();
				Impressora imp = new Impressora();

				e.setIdEmprestimo(rs.getInt("id_emprestimo"));
				e.setDtInicio(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_inicio")));
				loja.setIdLoja(rs.getInt("id_loja"));
				loja.setNome(rs.getString("nome"));
				loja.setNumero_loja(rs.getInt("numero_loja"));
				loja.setCnpj(rs.getString("cnpj"));
				imp.setIdImpressora(rs.getInt("id_impressora"));
				imp.setNumero(rs.getInt("numero"));
				imp.setModelo(rs.getString("modelo"));
				e.setSituacao(StatusEmprestimoEnum.getByDescricao(rs.getString("situacao")));
				e.setNum_chamado(rs.getString("num_chamado"));
				e.setPrazoDevolucao(FormatadorDeData.toLocalDate(rs.getDate("prazo_devolucao")));
				e.setDtFim(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_fim")));
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
