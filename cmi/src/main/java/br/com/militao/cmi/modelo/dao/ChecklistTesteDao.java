package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.ChecklistTeste;
import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.StatusPecaImpressoraEnum;


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
	
	public ChecklistTeste getByIdManutencao(int id) {
		
		ChecklistTeste teste = new ChecklistTeste();
		Manutencao manutencao = new Manutencao();
		
		String sql = "select * from checklist_teste where manutencao_id_manutencao = ?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);){
				
				stmt.setInt(1, id);

				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {						
					
					teste.setId_checklist_teste(rs.getInt("id_checklist_teste"));
					teste.setOperador(rs.getString("operador"));
					teste.setDesc_problema(rs.getString("desc_problema"));
					teste.setStatus_borracha(StatusPecaImpressoraEnum.valueOf(rs.getString("status_borracha")));
					teste.setStatus_cabeca_impressao(StatusPecaImpressoraEnum.valueOf(rs.getString("status_cabeca_impressao")));
					teste.setStatus_faca(StatusPecaImpressoraEnum.valueOf(rs.getString("status_faca")));
					teste.setObservacao(rs.getString("observacao"));
					
					manutencao.setId_manutencao(rs.getInt("manutencao_id_manutencao"));
					
					teste.setManutencao(manutencao);						
				}				
				
		}catch(SQLException e) {
			
			LOGGER.error("Erro ao buscar registro de teste de manutencao nº ", id);
			throw new RuntimeException(e);
		}	
		
		return teste;
		
	}

	
}
