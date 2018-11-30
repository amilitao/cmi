<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.time.LocalDate"%>
<%@page import="br.com.militao.cmi.util.FormatadorDeData"%>


<%
	String dataAtual = FormatadorDeData.formata(LocalDate.now());
%>

<button
	onclick="document.getElementById('idtransporte${param.idEmprestimo}').style.display='block'"
	class="w3-button w3-khaki" <c:out value="${param.b2}" />>
	<b>Transporte</b>
</button>

<div id="idtransporte${param.idEmprestimo}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-khaki">
			<span
				onclick="document.getElementById('idtransporte${param.idEmprestimo}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Transporte</h2>
		</header>



		<div class="w3-panel w3-padding-large">

			<form action="controle" method="post">

				<div class="w3-row-padding" style="margin: 0 -16px;">
					<div class="w3-col m3 w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Número do
							empréstimo</label> <input class="w3-input w3-border" type="text"
							value="${param.idEmprestimo}" name="idEmprestimo" readonly required>
					</div>
					<div class="w3-col m3 w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Data de envio</label> <input
							class="w3-input w3-border" type="text" value="<%=dataAtual%>"
							name="dtEnvio" readonly required>
					</div>
					<div class="w3-col m3 w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Nome da
							transportadora</label> <input class="w3-input w3-border" type="text"
							name="nomeTransportadora" required>
					</div>
					<div class="w3-col m3 w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Nfe de envio</label> <input
							class="w3-input w3-border" type="text" name="nfeEnvio" required>
					</div>
				</div>
				<hr>
				<input type="hidden" name="logica" value="SalvarTransporte" />

				<button class="w3-button w3-khaki" type="submit"
					<c:out value="${teste}" />>
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>

		<footer class="w3-container w3-khaki">
			<p>Obs.: A impressora deve ser devidamente embalada para o envio</p>
		</footer>
	</div>
</div>


