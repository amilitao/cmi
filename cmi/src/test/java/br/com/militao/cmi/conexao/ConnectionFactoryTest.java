package br.com.militao.cmi.conexao;



import java.sql.Connection;

import org.junit.jupiter.api.Test;

class ConnectionFactoryTest {

	
	@Test
	public void testeConexao() {
		Connection con = new ConnectionFactory().getConnection();
		
	}

}
