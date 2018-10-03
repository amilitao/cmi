<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		
<%@page import="java.time.LocalDate"%>
<%@page import="br.com.militao.cmi.util.FormatadorDeData" %>

<%
String dataAtual = FormatadorDeData.formata(LocalDate.now());
%>

<button onclick="document.getElementById('iddevolucao${param.idEmprestimo}').style.display='block'"
	class="w3-button w3-khaki" <c:out value="${param.b4}" /> >Devolução</button>

<div id="iddevolucao${param.idEmprestimo}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4">
		<header class="w3-container w3-khaki">
			<span onclick="document.getElementById('iddevolucao${param.idEmprestimo}').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<h2>Modal Header</h2>
		</header>

		<div class="w3-panel w3-padding-large">

			<form action="controle" method="post">

				<div class="w3-row-padding" style="margin: 0 -16px;">
					<div class="w3-third w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Número do empréstimo</label>
						<input class="w3-input w3-border" type="text" value="${param.idEmprestimo}" name="idEmprestimo" required >
					</div>
					<div class="w3-third w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Data de envio</label>
						<input class="w3-input w3-border" type="text" value="<%= dataAtual %>" name="dtDevolucao" required>
					</div>								
				</div>
				<div class="w3-row-padding" style="margin: 0 -16px;">
					<div class="w3-third w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Número Nfe de envio</label>
						<input class="w3-input w3-border" type="text" name="numNfeDevolucao" required>
					</div>		
					<div class="w3-third w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Recebedor</label>
						<input class="w3-input w3-border" type="text" name="recebedor" required>
					</div>
										
					
				</div>
				<hr>
				<input type="hidden" name="logica" value="SalvarDevolucao" />
				
				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>

		<footer class="w3-container w3-khaki">
			<p> Footer</p>
		</footer>
	</div>
</div>
