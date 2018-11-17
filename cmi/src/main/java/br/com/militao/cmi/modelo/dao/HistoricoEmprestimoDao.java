package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.HistoricoEmprestimo;
import br.com.militao.cmi.util.FormatadorDeData;


public class HistoricoEmprestimoDao implements GenericDao{
	private boolean resultado;
	
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
		HistoricoEmprestimo historico = (HistoricoEmprestimo) obj;

		String sql = "insert into historico_emprestimo (emprestimo_id_emprestimo, ocorrencia, dt_ocorrencia)"
				+ " values (?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, historico.getEmprestimo().getIdEmprestimo());
			stmt.setString(2, historico.getOcorrencia());
			stmt.setTimestamp(3, FormatadorDeData.toTimeStamp(historico.getDt_ocorrencia()));
						
			stmt.executeUpdate();
			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException("Erro ao gravar historico de emprestimo " + e);
		}

		return resultado;
	}

	@Override
	public List<Object> getList() {
		List<Object> historicos = new ArrayList<>();
		String sql = "select * from historico_emprestimo";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				HistoricoEmprestimo ocorrencia = new HistoricoEmprestimo();	
				Emprestimo emprestimo = new Emprestimo();
				
				ocorrencia.setIdHistoricoEmprestimo(rs.getInt("id_historico_emprestimo"));
				emprestimo.setIdEmprestimo(rs.getInt("emprestimo_id_emprestimo"));				
				ocorrencia.setEmprestimo(emprestimo);		
				ocorrencia.setOcorrencia(rs.getString("ocorrencia"));
				
				historicos.add(ocorrencia);

			}

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de HistoricoEmprestimo!!!", e);
		}

		return historicos;

	}
	
	

}
