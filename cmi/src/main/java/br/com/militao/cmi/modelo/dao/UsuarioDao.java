package br.com.militao.cmi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.militao.cmi.conexao.ConnectionFactory;
import br.com.militao.cmi.modelo.Usuario;

public class UsuarioDao {
	
	final Logger LOGGER = LoggerFactory.getLogger(UsuarioDao.class);

	public void delete(Usuario user) {

		String sql = "delete from usuario where id_usuario=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, user.getId_usuario());

			stmt.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("Erro ao deletar usuario: Id ", user.getId_usuario());
			throw new RuntimeException(e);
		}

	}

	public void update(Usuario user) {

		String sql = "update usuario set senha=? where id_usuario=?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getSenha());

			stmt.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("Erro ao atualizar cadastro de usuario: ", user.getLogin());
			throw new RuntimeException(e);
		}

	}

	public void insert(Usuario user) {

		String sql = "insert into usuario (login, senha) values (?,?)";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getSenha());

			stmt.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("Erro ao inserir dados do usuario: ", user.getLogin());
			throw new RuntimeException(e);
		}

	}

	public Usuario getUsuario(String lgn) {

		String sql = "select * from usuario where login = ?";

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, lgn);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {		
				Usuario user = new Usuario();

				user.setId_usuario(rs.getInt("id_usuario"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
				
				return user;
			}

		} catch (SQLException | NullPointerException e) {
			LOGGER.error("Erro ao buscar usuario por login. Login informado foi: ", lgn);
			throw new RuntimeException(e);
		}

		return null;

	}

}
