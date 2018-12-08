<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>
	<c:set var="teste" value="" />

	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-handshake-o"></i> Novo Empréstimo
		</h3>
	</div>

	<div class="w3-panel w3-padding-large">

		<c:if test="${empty impressoras}">
			<c:set var="teste" value="disabled" />
			<div class="w3-panel w3-pale-yellow w3-border w3-border-yellow">
				<p>Nenhuma impressora disponível no momento!!!</p>
			</div>

		</c:if>

		<c:if test="${confirmaDao}">
			<c:set var="teste" value="disabled" />
			<div class="w3-panel w3-display-container" style="background:#b5e7a0">
				<span onclick="this.parentElement.style.display='none'"
					class="w3-button w3-display-topright w3-large" style="background:#b5e7a0">&times;</span>
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
				<div class="w3-third w3-margin-bottom">
					<label><i class="fa fa-print"></i> Impressora</label> <select
						class="w3-select w3-border" name="id_impressora" required>
						<option value="" disabled selected>Escolha a impressora</option>
						<c:forEach var="impressora" items="${impressoras}">
							<option value="${impressora.idImpressora}">${impressora}</option>
						</c:forEach>
					</select>

				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Número do chamado</label> <input
						class="w3-input w3-border" type="text" name="num_chamado" required>
				</div>
			</div>
			<hr>
			<input type="hidden" name="logica" value="SalvarEmprestimo" />

			<button class="w3-button w3-blue" type="submit"
				<c:out value="${teste}" />>
				<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
			</button>
		</form>
	</div>




</t:mainpage>