package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.ListaDeEspera;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusListaDeEsperaEnum;

public class ListaDeEsperaDao{
	
	
	public void update(ListaDeEspera lojaEmLista) {
		
		String sql = "update lista_de_espera set situacao=? where id_reserva=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, lojaEmLista.getStatus().getDescricao());
			stmt.setInt(2, lojaEmLista.getId_reserva());
			
			stmt.executeUpdate();
	
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao salvar em lista de espera" + e);
		}
	}
	
	public void insert(ListaDeEspera lista) {
	
		String sql = "insert into lista_de_espera (loja_id_loja, situacao) values (?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, lista.getLoja().getIdLoja());
			stmt.setString(2, lista.getStatus().getDescricao());

			stmt.executeUpdate();


		} catch (SQLException e) {
	
			throw new RuntimeException("Erro ao salvar em lista de espera" + e);
		}

	}


	public List<ListaDeEspera> getList() {
		List<ListaDeEspera> lista = new ArrayList<>();
		
		String sql = "select lista.id_reserva, lo.id_loja, lo.numero_loja, lo.nome, lista.situacao from lista_de_espera lista "
				+ "inner join loja lo where lista.loja_id_loja = lo.id_loja and lista.situacao = 'aguardando' ";
		
		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				ListaDeEspera listaDeEspera = new ListaDeEspera();
				Loja loja = new Loja();

				listaDeEspera.setId_reserva(rs.getInt("id_reserva"));
				loja.setIdLoja(rs.getInt("id_loja"));
				loja.setNumero_loja(rs.getInt("numero_loja"));
				loja.setNome(rs.getString("nome"));
				listaDeEspera.setLoja(loja);
				listaDeEspera.setStatus(StatusListaDeEsperaEnum.getByDescricao(rs.getString("situacao")));

				lista.add(listaDeEspera);

			}

		} catch (SQLException | NullPointerException e) {

			throw new RuntimeException("Erro ao importar dados de Lista de Espera!!!", e);
		}

		return lista;
	}


	public ListaDeEspera getByNumberLoja(int numero) {
		ListaDeEspera lojaProcurada = null;
		List<ListaDeEspera> registros = this.getList();

		for (ListaDeEspera loja : registros) {
	
			if (loja.getLoja().getIdLoja() == numero && loja.getStatus().getDescricao() == "aguardando" ) {
				lojaProcurada = loja;
			}

		}
		return lojaProcurada;
	}

}
