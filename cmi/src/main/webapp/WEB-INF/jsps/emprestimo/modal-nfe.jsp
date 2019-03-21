<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<button onclick="document.getElementById('idnfe${param.idEmprestimo}').style.display='block'"
	class="w3-button" style="background:#ffeead" <c:out value="${param.b1}" />><b>Solicitar Nfe</b></button>

<div id="idnfe${param.idEmprestimo}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-khaki">
			<span onclick="document.getElementById('idnfe${param.idEmprestimo}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Solicitação de NFE</h2>			
		</header>

		<div class="w3-panel w3-padding-large">
			<h5><b>ASSUNTO:</b> Solicitação de emissão de nota fiscal.</h5>
			
			<form action="controle" method="post">
								
					<p>Poderia emitir uma nota fiscal para a devolução de impressora para a filial ${param.nomeLoja} .</p>
					<br>	
					<p><b>Emitir NFe tipo:</b> Empréstimo</p>
					<p><b>Empresa:</b> ${param.nomeLoja}</p>
					<p><b>CNPJ:</b> ${param.cnpjLoja}</p>
					<p><b>Valor:</b> </p>
					<p><b>Quantidade:</b> 1</p>
					<hr>
					<h5><b>Informações</b></h5>
					<p>1- O item está registrado como ativo? R: </p>					
					<p>2- Em qual razão social? R: </p>					
					<p>3- Qual previsão de retorno? R: ${param.prazo_devolucao}</p>					
					
			
				<br> <input type="hidden" name="logica" value="AtualizarEmprestimo" />
				
				<input type="hidden" name="idEmprestimo" value="${param.idEmprestimo}" />
				<input type="hidden" name="idImpressora" value="${param.idImpressora}" />
				<input type="hidden" name="situacao" value="aguardando transporte" />
				<input type="hidden" name="dtFim" value="${param.dtFim}" />
				

				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Enviar
				</button>
			</form>
		</div>


		<footer class="w3-container w3-khaki">
			<p>O email será enviado pelo servidor</p>
		</footer>
	</div>
</div>
