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

public class ListaDeEsperaDao implements GenericDao {
	
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
		ListaDeEspera lista = (ListaDeEspera) obj;

		String sql = "insert into lista_de_espera" + "(loja_id_loja, situacao) values (?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, lista.getLoja().getIdLoja());
			stmt.setString(2, lista.getStatus().getDescricao());

			stmt.executeUpdate();

			resultado = true;

		} catch (SQLException e) {
			resultado = false;
			throw new RuntimeException("Erro ao salvar em lista de espera" + e);
		}
		return resultado;
	}

	@Override
	public List<Object> getList() {
		List<Object> lista = new ArrayList<>();
		
		String sql = "select lista.id_reserva, lo.numero_loja, lo.nome, lista.situacao from lista_de_espera lista "
				+ "inner join loja lo where lista.loja_id_loja = lo.id_loja and lista.situacao = 'aguardando' ";
		
		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				ListaDeEspera listaDeEspera = new ListaDeEspera();
				Loja loja = new Loja();

				listaDeEspera.setId_reserva(rs.getInt("id_reserva"));
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

}
