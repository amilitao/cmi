<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.time.LocalDate"%>
<%@page import="br.com.militao.cmi.util.FormatadorDeData"%>

<%
	String hoje = FormatadorDeData.formata(LocalDate.now());
%>

<button
	onclick="document.getElementById('idteste${param.id_manutencao}').style.display='block'"
	class="w3-button w3-circle w3-border w3-${param.cor}"
	<c:out value="${param.b1}" />>
	<b>+</b>
</button>
<br />
<b>Teste Local</b>

<div id="idteste${param.id_manutencao}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-center w3-khaki">
			<span
				onclick="document.getElementById('idteste${param.id_manutencao}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Relatório de Teste</h2>
		</header>

		<div class="w3-panel w3-padding-large">

			<table class="w3-table w3-centered">
				<tr>
					<td>IMPRESSORA TERMICA</td>
				</tr>
				<tr>
					<td>ATACADAO</td>
				</tr>
				<tr>
					<td><%=hoje%></td>
				</tr>
			</table>

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
