/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.militao.cmi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adriano
 */
public class ConnectionFactory {

	private final String url_bd = "jdbc:mysql://localhost/db_cmi2?useSSL=false";
	private final String login = "root";
	private final String senha = "admin";	
	
	public Connection getConnection(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection( url_bd , login , senha );

			return conexao;

		} catch (SQLException | ClassNotFoundException ex) {
			throw new RuntimeException("Erro na criação da conexao", ex);
		}
	}
}
