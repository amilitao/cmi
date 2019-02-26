package br.com.militao.cmi.controle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.ControleDeAcesso;
import br.com.militao.cmi.modelo.Usuario;

class SalvarComentarioTest {

		
	/*@Test
	void inserirUsuario() {
		Usuario user = new Usuario();
		user.setLogin("producao");
		user.setSenha("producao");
		
		ControleDeAcesso.salvarUsuario(user);
	}
*/
	
	@Test
	void autenticaUsuario() {
		Usuario user = new Usuario();
		user.setLogin("producao");
		user.setSenha("producao");
		
		
			System.out.println(ControleDeAcesso.autentica(user));
		}
	
}
