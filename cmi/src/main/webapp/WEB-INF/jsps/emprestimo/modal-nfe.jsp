<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<button onclick="document.getElementById('idnfe${emprestimo.id_emprestimo}').style.display='block'"
	class="w3-button" style="background:#ffeead" <c:out value="${param.b1}" />><b>Solicitar Nfe</b></button>

<div id="idnfe${emprestimo.id_emprestimo}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-khaki">
			<span onclick="document.getElementById('idnfe${emprestimo.id_emprestimo}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Solicitação de NFE</h2>			
		</header>

		<div class="w3-panel w3-padding-large">
			<h5><b>ASSUNTO:</b> Solicitação de emissão de nota fiscal.</h5>
			
			<form action="controle" method="post">
								
					<p>Poderia emitir uma nota fiscal para a devolução de impressora para a filial ${emprestimo.loja.nome} .</p>
					<br>	
					<p><b>Emitir NFe tipo:</b> Empréstimo</p>
					<p><b>Empresa:</b> ${emprestimo.loja}</p>
					<p><b>CNPJ:</b> ${emprestimo.loja.cnpj}</p>
					<p><b>Valor:</b> ${emprestimo.impressora.valor}</p>
					<p><b>Quantidade:</b> 1</p>
					<hr>
					<h5><b>Informações</b></h5>
					<p>1- O item está registrado como ativo? R: SIM</p>					
					<p>2- Em qual razão social? R: ATACADAO S.A </p>					
					<p>3- Qual previsão de retorno? R: ${emprestimo.prazoDevolucaoFormatada}</p>					
					
			
				<br> <input type="hidden" name="logica" value="AtualizarEmprestimo" />
				
				<input type="hidden" name="id_emprestimo" value="${emprestimo.id_emprestimo}" />
				<input type="hidden" name="id_impressora" value="${emprestimo.impressora.id_impressora}" />
				<input type="hidden" name="situacao" value="AGUARDANDO_TRANSPORTE" />
				<input type="hidden" name="dtFim" value="${emprestimo.dtFim}" />
				

				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>
		
	</div>
</div>
