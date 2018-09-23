<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<button onclick="document.getElementById('idnfe${param.idEmprestimo}').style.display='block'"
	class="w3-button w3-khaki" <c:out value="${param.b1}" />>Solicitar Nfe</button>

<div id="idnfe${param.idEmprestimo}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4">
		<header class="w3-container w3-khaki">
			<span onclick="document.getElementById('idnfe${param.idEmprestimo}').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<h4>Modelo de Email</h4>
			<h5><b>ASSUNTO:</b> Solicita��o de emiss�o de nota fiscal.</h5>
		</header>

		<div class="w3-panel w3-padding-large">

			<form action="controle" method="post">
								
					<p>Poderia emitir uma nota fiscal para a devolu��o de impressora para a filial ${param.nomeLoja} .</p>
					<br>	
					<p><b>Emitir NFe tipo:</b> Empr�stimo</p>
					<p><b>Empresa:</b> ${param.nomeLoja}</p>
					<p><b>CNPJ:</b> ${param.cnpjLoja}</p>
					<p><b>Valor:</b> </p>
					<p><b>Quantidade:</b> 1</p>
					<hr>
					<h5><b>Informa��es</b></h5>
					<p>1- O item est� registrado como ativo? R: </p>					
					<p>2- Em qual raz�o social? R: </p>					
					<p>3- Qual previs�o de retorno? R: ${param.prazo_devolucao}</p>					
					
			
				<br> <input type="hidden" name="logica" value="AtualizarEmprestimo" />
				
				<input type="hidden" name="idEmprestimo" value="${param.idEmprestimo}" />
				<input type="hidden" name="situacao" value="TRANSPORTE" />
				<input type="hidden" name="dtFim" value="${param.dtFim}" />
				

				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Enviar
				</button>
			</form>
		</div>


		<footer class="w3-container w3-khaki">
			<p>O email ser� enviado pelo servidor</p>
		</footer>
	</div>
</div>
