<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<button
	onclick="document.getElementById('idSolOrcam${manutencao.id_manutencao}').style.display='block'"
	class="w3-button w3-circle w3-border w3-yellow"
	<c:out value="${param.b3}" />>
	<b>+</b>
</button>
<br />
<b>Envio de Impressora</b>

<div id="idSolOrcam${manutencao.id_manutencao}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-center w3-khaki">
			<span
				onclick="document.getElementById('idSolOrcam${manutencao.id_manutencao}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Envio de Impressora</h2>
		</header>
		<div class="w3-panel w3-padding-large">
			<h5>
				<b>ASSUNTO:</b> Solicitação de orçamento.
			</h5>

			<form action="controle" method="post">

				<p>Poderia retirar uma impressora modelo ${manutencao.impressora.modelo} para orçamento?</p>
						
				<hr>
				
				<br> <input type="hidden" name="logica" value="AtualizarManutencao" /> 
				<input type="hidden" name="id_manutencao" value="${manutencao.id_manutencao}" /> 
				<input type="hidden" name="status_manutencao" value="ORCAMENTO" />
			
				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>

	</div>
</div>
