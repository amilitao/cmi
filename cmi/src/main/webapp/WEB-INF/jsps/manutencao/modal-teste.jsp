<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<button onclick="document.getElementById('idteste${param.id_manutencao}').style.display='block'"
	class="w3-button w3-circle w3-border w3-${param.cor}" <c:out value="${param.b1}" />><b>+</b></button>
<br /> <b>Solicitar NFE</b>

<div id="idteste${param.id_manutencao}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-khaki">
			<span onclick="document.getElementById('idteste${param.id_manutencao}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Solicitação de NFE</h2>			
		</header>

		<div class="w3-panel w3-padding-large">
			<h5><b>ASSUNTO:</b> Solicitação de emissão de nota fiscal.</h5>
			
			<form action="controle" method="post">		
				

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
