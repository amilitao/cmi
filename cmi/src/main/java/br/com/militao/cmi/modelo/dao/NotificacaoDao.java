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
import br.com.militao.cmi.modelo.Notificacao;
import br.com.militao.cmi.util.FormatadorDeData;

public class NotificacaoDao {
	
	final Logger LOGGER = LoggerFactory.getLogger(NotificacaoDao.class);
	
	public void insert(Notificacao notificacao) {		

		String sql = "insert into notificacao (descricao, visualizado, dt_visualizacao)"
				+ " values (?,?,?)";	

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {
			
			stmt.setString(1, notificacao.getDescricao());
			stmt.setInt(2, notificacao.getVizualizado());
			stmt.setTimestamp(3, FormatadorDeData.toTimeStamp(notificacao.getDt_visualizacao()));
			
			stmt.executeUpdate();


		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	public List<Notificacao> getList() {

		List<Notificacao> notificacoes = new ArrayList<>();
		
		String sql = "select * from notificacao where visualizado = 0 ";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Notificacao notificacao = new Notificacao();
					
				
				notificacao.setDescricao(rs.getString("descricao"));
				notificacao.setVizualizado(rs.getInt("visualizado"));
				notificacao.setDt_visualizacao(FormatadorDeData.toLocalDateTime(rs.getTimestamp("dt_visualizacao")));
				
				notificacoes.add(notificacao);

			}

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de Loja!!!", e);
		}

		return notificacoes;

	}


}
