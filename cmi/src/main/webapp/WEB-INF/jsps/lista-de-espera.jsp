<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-hourglass-o"></i> Lista de Espera
		</h3>
	</div>

	<div class="w3-panel w3-padding-large">

		<c:if test="${confirmaDao}">
			<div class="w3-panel w3-display-container"
				style="background: #b5e7a0">
				<span onclick="this.parentElement.style.display='none'"
					class="w3-button w3-display-topright w3-large"
					style="background: #b5e7a0">&times;</span>
				<p>Os dados foram salvos com sucesso!!!</p>
			</div>

		</c:if>

		<form action="controle" method="post">

			<div class="w3-row-padding" style="margin: 0 -16px;">
				<div class="w3-third w3-margin-bottom">
					<label><i class="fa fa-home"></i> Loja</label> <select
						class="w3-select w3-border" name="id_loja" required>
						<option value="" disabled selected>Escolha a loja</option>
						<c:forEach var="loja" items="${lojas}">
							<option value="${loja.idLoja}">${loja}</option>
						</c:forEach>
					</select>

				</div>
			</div>
			<hr>
			<input type="hidden" name="logica" value="SalvarListaDeEspera" />

			<button class="w3-button w3-blue" type="submit">
				<i class="fa fa-floppy-o w3-margin-right"></i>Adicionar
			</button>
		</form>
		<hr>

		<div class="w3-container" style="margin: 0 -16px;">

			<div class="w3-center w3-white">
				<h4>
					<b>Lista de Espera</b>
				</h4>
			</div>
			<div style="height: 370px; overflow: auto;">
				<table class="w3-table-all w3-hoverable">
					<thead>
						<tr class="w3-dark-grey">
							<th>Id</th>
							<th>Numero</th>
							<th>Filial</th>
							<th>Status</th>
						</tr>
					</thead>
					<c:forEach var="l" items="${listaDeEspera}">
						<tr
							onclick="document.getElementById('idListaEspera').style.display='block'">
							<td><b>${l.id_reserva}</b></td>
							<td>${l.loja.numero_loja}</td>
							<td>${l.loja.nome}</td>
							<td>${l.status.descricao}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


	<div id="idListaEspera" class="w3-modal">
		<div class="w3-modal-content" style="background: #d8dddf">
			<header class="w3-container">
				<span
					onclick="document.getElementById('idListaEspera').style.display='none'"
					class="w3-button w3-display-topright  w3-large">&times;</span>
				<h4>Lista de espera</h4>
			</header>
			<div class="w3-container w3-white">
				<c:if test="${empty impressoras}">
					<div class="w3-panel w3-pale-yellow w3-border w3-border-yellow">
						<p>Nenhuma impressora disponível no momento!!!</p>
					</div>
				</c:if>
				<c:if test="${not empty impressoras}">
					<div class="w3-panel">
						<h4>Lista de impressoras disponíveis:</h4>
						<c:forEach var="lista" items="${impressoras}">
							<p>${lista}</p>
						</c:forEach>

					</div>


					<div class="w3-panel">
						<p>Existe impressora disponível no momento. Deseja ser
							transferido para tela de empréstimos?</p>
							
						<form action="controle" method="post">	
						<input type="hidden" name="logica" value="EmprestimoPage">
						<button class="w3-button w3-green" type="submit">SIM</button>
						<button
							onclick="document.getElementById('idListaEspera').style.display='none'"
							class="w3-button w3-red" type="button">NÃO</button>
						</form>						
					</div>

				</c:if>


			</div>
			<footer class="w3-container">
				<p>Obs.: Você será direcionada para a página de emprestimo e
					deverá escolher a impressora desejada</p>
			</footer>
		</div>
	</div>


</t:mainpage>