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
import br.com.militao.cmi.modelo.Assistencia;

public class AssistenciaDao {
	
	final Logger LOGGER = LoggerFactory.getLogger(AssistenciaDao.class);
	
	
	public void insert(Assistencia assist) {
		
		String sql = "insert into assistencia "
				+ "(razao_social, cnpj, email, telefone_assistencia, endereco) values "
				+ "(?,?,?,?,?)";
		
		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {
			
			stmt.setString(1, assist.getRazao_social());
			stmt.setString(2, assist.getCnpj());
			stmt.setString(3, assist.getEmail());
			stmt.setString(4, assist.getTelefone_assistencia());
			stmt.setString(5, assist.getEndereco());
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			LOGGER.error("Erro ao inserir assistencia ", assist.getRazao_social());
			throw new RuntimeException(e);
		}
		
		
	}
	
	public void update(Assistencia assist) {
		
		String sql = "update assistencia set razao_social = ?, cnpj = ?, email = ?, "
				+ "telefone_assistencia = ?, endereco = ? where id_assistencia =?";
		
		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, assist.getRazao_social());
			stmt.setString(2, assist.getCnpj());
			stmt.setString(3, assist.getEmail());
			stmt.setString(4, assist.getTelefone_assistencia());
			stmt.setString(5, assist.getEndereco());
			stmt.setInt(6, assist.getId_assistencia());
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			LOGGER.error("Erro ao atualizar dados da assistencia ", assist.getRazao_social());
			throw new RuntimeException(e);
		}
	}

	public List<Assistencia> getList() {

		List<Assistencia> listaDeAssistencias = new ArrayList<>();

		String sql = "select * from assistencia";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Assistencia assistencia = new Assistencia();
				
				assistencia.setId_assistencia(rs.getInt("id_assistencia"));
				assistencia.setRazao_social(rs.getString("razao_social"));
				assistencia.setCnpj(rs.getString("cnpj"));
				assistencia.setEmail(rs.getString("email"));
				assistencia.setTelefone_assistencia(rs.getString("telefone_assistencia"));
				assistencia.setEndereco(rs.getString("endereco"));
				
				listaDeAssistencias.add(assistencia);

			}

		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		return listaDeAssistencias;
	}
	
	public Assistencia getAssistenciaById(int id) {
		Assistencia assistenciaProcurada = new Assistencia();
		List<Assistencia> assistencias = this.getList();

		for (Assistencia assistencia : assistencias) {

			if (assistencia.getId_assistencia() == id) {
				assistenciaProcurada = assistencia;
			}

		}
		return assistenciaProcurada;
	}
	

}
