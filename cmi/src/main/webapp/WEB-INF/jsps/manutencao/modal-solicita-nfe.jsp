<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<button
	onclick="document.getElementById('idnfe${manutencao.id_manutencao}').style.display='block'"
	class="w3-button w3-circle w3-border w3-yellow"
	<c:out value="${param.b2}" />>
	<b>+</b>
</button>
<br />
<b>Solicitação de NFE</b>

<div id="idnfe${manutencao.id_manutencao}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-center w3-khaki">
			<span
				onclick="document.getElementById('idnfe${manutencao.id_manutencao}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Relatório de Teste</h2>
		</header>
		<div class="w3-panel w3-padding-large">
			<h5>
				<b>ASSUNTO:</b> Solicitação de emissão de nota fiscal.
			</h5>

			<form action="controle" method="post">

				<p>Poderia emitir uma nota fiscal para envio de impressora para orçamento.</p>
				<br>
				<p>
					<b>Emitir NFe tipo:</b> Remessa para conserto.
				</p>
				<p>
					<b>Empresa:</b> ${manutencao.assistencia.razao_social}
				</p>
				<p>
					<b>CNPJ:</b> ${manutencao.assistencia.cnpj}
				</p>				
				<p>
					<b>Quantidade:</b> 1
				</p>
				<p>
					<b>Valor:</b> ${manutencao.impressora.valor}
				</p>
				<hr>
				
				<br> <input type="hidden" name="logica" value="AtualizarManutencao" /> 
				<input type="hidden" name="id_manutencao" value="${manutencao.id_manutencao}" /> 
				<input type="hidden" name="status_manutencao" value="ENVIO" />
			
				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>

	</div>
</div>
