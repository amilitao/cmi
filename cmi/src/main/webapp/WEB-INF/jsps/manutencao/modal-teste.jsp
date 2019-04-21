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

			<table class="w3-table">
				<tr>
					<td class="w3-border w3-center">IMPRESSORA TERMICA<br>ATACADAO<br><%=hoje%></td>
				</tr>
				<tr>
					<td class="w3-border">FILIAL: ${param.loja}</td>
				</tr>
				<tr>
					<td class="w3-border">OPERADOR: <input type="text"
						style="width: 30%" required></td>
				</tr>
				<tr>
					<td class="w3-border">CONTATO: ${param.telefone_loja}</td>
				</tr>
			</table>

			<div class="w3-row w3-margin-top">
				<div class="w3-col m12 w3-center">
					<b>DADOS DO EQUIPAMENTO</b>
				</div>
			</div>

			<div class="w3-row">
				<div class="w3-col s6 w3-border w3-center">
					<p>CHAMADO</p>
				</div>
				<div class="w3-col s6 w3-border w3-center">
					<p>IMPRESSORA</p>
				</div>
			</div>
			<div class="w3-row">
				<div class="w3-col s6 w3-border w3-center">
					<p>?????</p>
				</div>
				<div class="w3-col s6 w3-border w3-center">
					<p>?????</p>
				</div>
			</div>
			<div class="w3-row w3-padding-large">
				<div class="w3-col s6 w3-border w3-center">
					<p>ANÁLISE/DESCRIÇÃO DOS PROBLEMAS</p>
				</div>
				<div class="w3-col s6 w3-border">
					<textarea class="w3-col" style="width: 100%" rows="3"
						name="descricao"></textarea>
					<input type="hidden" name="desc_problema" value="" />
				</div>
			</div>
			<div class="w3-row w3-padding-large">
				<div class="w3-col s6 w3-border w3-center">
					ANÁLISE/DESCRIÇÃO DOS PROBLEMAS
				</div>
				<div class="w3-col s6 w3-border">
					<select>
						<option value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="opel">Opel</option>
						<option value="audi">Audi</option>
					</select>
				</div>
			</div>
			<div class="w3-row w3-padding-large">
				<div class="w3-col s6 w3-border w3-center">
					ANÁLISE/DESCRIÇÃO DOS PROBLEMAS
				</div>
				<div class="w3-col s6 w3-border">
					<select>
						<option value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="opel">Opel</option>
						<option value="audi">Audi</option>
					</select>
				</div>
			</div>
			<div class="w3-row w3-padding-large">
				<div class="w3-col s6 w3-border w3-center">
					<p>ANÁLISE/DESCRIÇÃO DOS PROBLEMAS</p>
				</div>
				<div class="w3-col s6 w3-border">
					<p>????</p>
				</div>
			</div>
			<div class="w3-row w3-padding-large">
				<div class="w3-col s6 w3-border w3-center">
					ANÁLISE/DESCRIÇÃO DOS PROBLEMAS
				</div>
				<div class="w3-col s6 w3-border">
					<select>
						<option value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="opel">Opel</option>
						<option value="audi">Audi</option>
					</select>
				</div>
			</div>
			<div class="w3-row w3-padding-large">
				<div class="w3-col s6 w3-border w3-center">
					<p>ANÁLISE/DESCRIÇÃO DOS PROBLEMAS</p>
				</div>
				<div class="w3-col s6 w3-border">
					<textarea class="w3-col" style="width: 100%" rows="3"
						name="descricao"></textarea>
					<input type="hidden" name="desc_problema" value="" />
				</div>
			</div>

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
