<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<div class="w3-container">
		<h2>
			<i class="fa fa-print"></i> Cadastro de impressora
		</h2>
	</div>

	<div class="w3-panel w3-padding-large">
		
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
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Número da impressora</label> <input
						class="w3-input w3-border" type="text" name="num_impressora" required>
				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Modelo</label> <input
						class="w3-input w3-border" type="text" name="modelo" required>
				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Pip</label> <input
						class="w3-input w3-border" type="text" name="pip" required>
				</div>
			</div>
			<div class="w3-row-padding w3-margin-top" style="margin: 0 -16px;">
				<div class="w3-third ">
					<label><i class="fa fa-pencil-square-o"></i> Número de serie</label> <input
						class="w3-input w3-border" type="text" name="num_serie" required>
				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Estado</label> <input
						class="w3-input w3-border" type="text" name="estado" required>
				</div>
				<div class="w3-third w3-margin-bottom">
					<label><i class="fa fa-home"></i> Situacao</label> <select
						class="w3-select w3-border" name="situacao" required>
						<option value="" disabled selected>Escolha a situacao</option>
						<c:forEach var="situacao" items="${lista_situacao}">
							<option value="${situacao}">${situacao.descricao}</option>
						</c:forEach>
					</select>

				</div>
			</div>
			<hr>
			<input type="hidden" name="logica" value="SalvarImpressora" />

			<button class="w3-button w3-blue" type="submit"	>
				<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
			</button>
		</form>
	</div>




</t:mainpage>>