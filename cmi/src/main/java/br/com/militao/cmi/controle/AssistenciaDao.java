package br.com.militao.cmi.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Assistencia;

public class AssistenciaDao {

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
				assistencia.setTelefone(rs.getString("telefone"));
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
