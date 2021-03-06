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
import br.com.militao.cmi.modelo.EstadoImpressoraEnum;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.StatusManutencaoEnum;
import br.com.militao.cmi.util.FormatadorDeData;

public class ManutencaoDao {
	
	final Logger LOGGER = LoggerFactory.getLogger(ManutencaoDao.class);
	
	public void updateEnvioImpressora(Manutencao manutencao) {
		
		String sql = "update manutencao set dt_envio=? , nfe_envio=?, "
				+ "status_manutencao=? where id_manutencao=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setTimestamp(1, FormatadorDeData.toTimeStamp(manutencao.getDt_envio()));
			stmt.setString(2, manutencao.getNfe_envio());
			stmt.setString(3, manutencao.getStatus_manutencao().name());		
			stmt.setInt(4, manutencao.getId_manutencao());

			stmt.executeUpdate();

		} catch (SQLException e) {
			
			LOGGER.error("Erro ao atualizar manutenção após envio de impressora nº ", manutencao.getId_manutencao());
			throw new RuntimeException("Erro ao atualizar manutencao após envio de impressora!!!" + e);
		}
	}
	
	public void update(Manutencao manutencao) {

		String sql = "update manutencao set status_manutencao=? where id_manutencao=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, manutencao.getStatus_manutencao().name());		
			stmt.setInt(2, manutencao.getId_manutencao());

			stmt.executeUpdate();

		} catch (SQLException e) {
			
			LOGGER.error("Erro ao atualizar manutenção nº ", manutencao.getId_manutencao());
			throw new RuntimeException("Erro ao atualizar manutencao!!!" + e);
		}

	}	
	
	public void updateControleDespesa(Manutencao manutencao) {
		
		String sql = "update manutencao set numero_despesa=?, "
				+ "status_manutencao=? where id_manutencao=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
						
			stmt.setInt(1, manutencao.getNumero_despesa());
			stmt.setString(2, manutencao.getStatus_manutencao().name());		
			stmt.setInt(3, manutencao.getId_manutencao());

			stmt.executeUpdate();

		} catch (SQLException e) {
			
			LOGGER.error("Erro ao atualizar manutenção após lançamento de despesa: nº ", manutencao.getId_manutencao());
			throw new RuntimeException("Erro ao atualizar manutencao após após lançamento de despesa!!!" + e);
		}
		
	}
	
	public void insert(Manutencao manutencao) {

		String sql = "insert into manutencao ("
				+ "assistencia_id_assistencia,impressora_id_impressora, "
				+ "status_manutencao, dt_inicio) "
				+ "values (?,?,?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, manutencao.getAssistencia().getId_assistencia());
			stmt.setInt(2, manutencao.getImpressora().getId_impressora());	
			stmt.setString(3, manutencao.getStatus_manutencao().name());
			stmt.setDate(4, FormatadorDeData.toDate(manutencao.getDt_inicio()));
			

			stmt.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("Erro ao gravar manutencao ", manutencao.getId_manutencao());
			throw new RuntimeException("Erro ao gravar manutencao " + e);
		}

	}

	public List<Manutencao> getList() {
		
		List<Manutencao> manutencoes = new ArrayList<>();

		String sql = "select * from manutencao m join assistencia a on m.assistencia_id_assistencia = a.id_assistencia "
				+ "join impressora i on m.impressora_id_impressora = i.id_impressora "			
				+ "join loja l on i.loja_id_loja = l.id_loja "
				+ "order by id_manutencao desc;";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				
				Manutencao manutencao = new Manutencao();
				Assistencia assistencia = new Assistencia();
				Impressora impressora = new Impressora();
				Loja loja = new Loja();
				
				manutencao.setId_manutencao(rs.getInt("id_manutencao"));
				
				assistencia.setId_assistencia(rs.getInt("id_assistencia"));
				assistencia.setRazao_social(rs.getString("razao_social"));
				assistencia.setRazao_social(rs.getString("razao_social"));
				assistencia.setCnpj(rs.getString("cnpj"));
				assistencia.setEmail(rs.getString("email"));
				assistencia.setTelefone_assistencia(rs.getString("telefone_assistencia"));
				assistencia.setEndereco(rs.getString("endereco"));
				
				manutencao.setAssistencia(assistencia);
				
				impressora.setId_impressora(rs.getInt("id_impressora"));
				
				loja.setId_loja(rs.getInt("loja_id_loja"));
				loja.setNumero_loja(rs.getInt("numero_loja"));
				loja.setNome(rs.getString("nome"));
				loja.setTelefone(rs.getString("telefone"));
				impressora.setLoja(loja);
				
				impressora.setNumero(rs.getInt("numero"));
				impressora.setModelo(rs.getString("modelo"));
				impressora.setPip(rs.getInt("pip"));
				impressora.setNumero_serie(rs.getString("numero_serie"));
				impressora.setValor(rs.getDouble("valor"));
				impressora.setEstado(EstadoImpressoraEnum.valueOf(rs.getString("estado")));
				impressora.setSituacao(StatusImpressoraEnum.getByDescricao(rs.getString("situacao")));
				
				manutencao.setImpressora(impressora);
				
				manutencao.setDt_envio(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_envio")));
				manutencao.setNfe_envio(rs.getString("nfe_envio"));
				manutencao.setDt_devolucao(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_devolucao")));
				manutencao.setNfe_devolucao(rs.getString("nfe_devolucao"));
				manutencao.setStatus_manutencao(StatusManutencaoEnum.valueOf(rs.getString("status_manutencao")));
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
