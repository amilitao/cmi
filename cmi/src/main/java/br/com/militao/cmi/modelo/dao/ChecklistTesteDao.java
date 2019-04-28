package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.ChecklistTeste;


public class ChecklistTesteDao {

	final Logger LOGGER = LoggerFactory.getLogger(ChecklistTesteDao.class);
	
	public void insert(ChecklistTeste checklist) {

		String sql = "insert into checklist_teste (operador, desc_problema, status_borracha,"
				+ " status_cabeca_impressao, status_faca, observacao, manutencao_id_manutencao)"
				+ " values (?,?,?,?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, checklist.getOperador());
			stmt.setString(2, checklist.getDesc_problema());
			stmt.setString(3, checklist.getStatus_borracha().name());
			stmt.setString(4, checklist.getStatus_cabeca_impressao().name());
			stmt.setString(5, checklist.getStatus_faca().name());
			stmt.setString(6, checklist.getObservacao());
			stmt.setInt(7, checklist.getManutencao().getId_manutencao());
			

			stmt.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error("Erro ao salvar checklist de manutencao ", checklist.getManutencao().getId_manutencao());
			throw new RuntimeException("Erro ao salvar em checklist_teste" + e);
		}

	}

	
}
