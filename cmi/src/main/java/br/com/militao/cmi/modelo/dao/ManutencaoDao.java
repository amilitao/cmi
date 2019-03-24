package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Assistencia;
import br.com.militao.cmi.modelo.EstadoImpressoraEnum;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.StatusManutencaoEnum;
import br.com.militao.cmi.util.FormatadorDeData;

public class ManutencaoDao {
	
	
	public void insert(Manutencao manutencao) {

		String sql = "insert into manutencao (assistencia_id_assistencia,impressora_id_impressora,"
				+ "status_manutencao) values (?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, manutencao.getAssistencia().getId_assistencia());
			stmt.setInt(2, manutencao.getImpressora().getIdImpressora());			
			stmt.setString(3, manutencao.getStatus_manutencao().getDescricao());			

			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao gravar manutencao " + e);
		}

	}

	public List<Manutencao> getList() {
		
		List<Manutencao> manutencoes = new ArrayList<>();

		String sql = "select * from manutencao m join assistencia a on m.assistencia_id_assistencia = a.id_assistencia "
				+ "join impressora i on m.impressora_id_impressora = i.id_impressora "
				+ "order by id_manutencao desc;";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				
				Manutencao manutencao = new Manutencao();
				Assistencia assistencia = new Assistencia();
				Impressora impressora = new Impressora();
				
				manutencao.setId_manutencao(rs.getInt("id_manutencao"));
				
				assistencia.setId_assistencia(rs.getInt("id_assistencia"));
				assistencia.setRazao_social(rs.getString("razao_social"));
				assistencia.setRazao_social(rs.getString("razao_social"));
				assistencia.setCnpj(rs.getString("cnpj"));
				assistencia.setEmail(rs.getString("email"));
				assistencia.setTelefone(rs.getString("telefone"));
				assistencia.setEndereco(rs.getString("endereco"));
				
				manutencao.setAssistencia(assistencia);
				
				impressora.setIdImpressora(rs.getInt("id_impressora"));				
				impressora.setNumero(rs.getInt("numero"));
				impressora.setModelo(rs.getString("modelo"));
				impressora.setPip(rs.getInt("pip"));
				impressora.setNumero_serie(rs.getString("numero_serie"));
				impressora.setValor(rs.getDouble("valor"));
				impressora.setEstado(EstadoImpressoraEnum.getByDescricao(rs.getString("estado")));
				impressora.setSituacao(StatusImpressoraEnum.getByDescricao(rs.getString("situacao")));
				
				manutencao.setImpressora(impressora);
				
				manutencao.setDt_envio(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_envio")));
				manutencao.setNfe_envio(rs.getString("nfe_envio"));
				manutencao.setDt_devolucao(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_devolucao")));
				manutencao.setNfe_devolucao(rs.getString("nfe_devolucao"));
				manutencao.setStatus_manutencao(StatusManutencaoEnum.getByDescricao(rs.getString("status_manutencao")));
				manutencao.setNumero_despesa(rs.getInt("numero_despesa"));
				manutencao.setNfe_pagamento(rs.getString("nfe_pagamento"));
				manutencao.setDt_inicio(FormatadorDeData.toLocalDate(rs.getDate("dt_inicio")));
				manutencao.setDt_fim(FormatadorDeData.toLocalDate(rs.getDate("dt_fim")));
				
				manutencoes.add(manutencao);
				
			}			
		
			} catch (SQLException e) {

				throw new RuntimeException("Erro ao listar manutencoes " + e);
			}
		
		return manutencoes;
	}

	public Object getManutencaoById(int id_manutencao) {
		
		Manutencao manutencaoProcurada = new Manutencao();
		List<Manutencao> manutencoes = this.getList();

		for (Manutencao manutencao : manutencoes) {

			if (manutencao.getId_manutencao() == id_manutencao) {
				manutencaoProcurada = manutencao;
			}

		}
		return manutencaoProcurada;
	}

}
