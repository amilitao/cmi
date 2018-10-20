package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.HistoricoEmprestimo;


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

		String sql = "insert into historico_emprestimo (emprestimo_id_emprestimo, ocorrencia)"
				+ " values (?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, historico.getEmprestimo().getIdEmprestimo());
			stmt.setString(2, historico.getOcorrencia());	
						
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
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
