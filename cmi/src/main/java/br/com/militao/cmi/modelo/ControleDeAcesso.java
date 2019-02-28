package br.com.militao.cmi.modelo;

import org.mindrot.jbcrypt.BCrypt;

import br.com.militao.cmi.modelo.dao.UsuarioDao;

public class ControleDeAcesso {

	private static UsuarioDao userDao = new UsuarioDao();

	public static void salvarUsuario(Usuario user) {

		// Gera um sal aleatório
		String salGerado = BCrypt.gensalt();

		// Gera a senha hasheada utilizando o sal gerado
		String senhaHasheada = BCrypt.hashpw(user.getSenha(), salGerado);

		// Atualiza a senha do usuário
		user.setSenha(senhaHasheada);

		// Salva no banco
		userDao.insert(user);
	}

	public static boolean autentica(Usuario user) {
		boolean autenticacaoBateu  = false;	
		
		String loginDoCandidato = user.getLogin();
		String senhaDoCandidato = user.getSenha(); // Essa senha está em texto puro, sem hash.

		Usuario usuarioComSenhaHasheada = userDao.getUsuario(loginDoCandidato);

		if(usuarioComSenhaHasheada != null){
		
			String senhaDoBanco = usuarioComSenhaHasheada.getSenha(); // Essa senha está hasheada.

			// Usa o BCrypt para verificar se a senha passada está correta.
			// Isso envolve ler a senhaDoBanco, separar o que é sal e o que é hash
			// usar o sal para criar um hash da senhaDoCandidato e, por fim
			// verificar se os hashes gerados são iguais.
			autenticacaoBateu = BCrypt.checkpw(senhaDoCandidato, senhaDoBanco);
		}

		return autenticacaoBateu;
	}
}
