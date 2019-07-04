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
import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.Orcamento;
import br.com.militao.cmi.util.FormatadorDeData;

public class OrcamentoDao {

	final Logger LOGGER = LoggerFactory.getLogger(OrcamentoDao.class);	
	
	
	public List<Orcamento> getList() {
		List<Orcamento> orcamentos = new ArrayList<>();
		String sql = "select * from orcamento";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {				
				Orcamento orcamento = new Orcamento();
				Manutencao manutencao = new Manutencao();
				
				orcamento.setId_orcamento(rs.getInt("id_orcamento"));
				manutencao.setId_manutencao(rs.getInt("manutencao_id_manutencao"));
				orcamento.setManutencao(manutencao);
				orcamento.setNumero_orcamento(rs.getInt("numero_orcamento"));
				orcamento.setValor_total(rs.getDouble("valor_total"));
				orcamento.setPrazo(FormatadorDeData.toLocalDate(rs.getDate("prazo")));
				orcamento.setAprovado(rs.getBoolean("aprovado"));
				
				orcamentos.add(orcamento);

			}

		} catch (SQLException | NullPointerException e) {
			LOGGER.error("Erro ao listar tabela orcamento");
			throw new RuntimeException("Erro ao importar dados de Orcamento!!!", e);			
		}
		return orcamentos;
	}
	
	public List<Orcamento> getOrcamentoPorIdManutencao(int id_manutencao) {
		List<Orcamento> orcamentoProcurado = new ArrayList<>();
		List<Orcamento> orcamentos = this.getList();

		for (Orcamento orcamento : orcamentos) {
			if (orcamento.getManutencao().getId_manutencao() == id_manutencao) {
				orcamentoProcurado.add(orcamento);
			}
		}

		return orcamentoProcurado;
	}
	
}
