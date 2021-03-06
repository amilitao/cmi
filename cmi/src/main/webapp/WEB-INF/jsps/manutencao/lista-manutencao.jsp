<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-cubes"></i> Lista de manutenções
		</h3>

		<c:if test="${confirmaDao}">
			<c:set var="teste" value="disabled" />
			<div class="w3-panel w3-display-container"
				style="background: #b5e7a0">
				<span onclick="this.parentElement.style.display='none'"
					class="w3-button w3-display-topright w3-large"
					style="background: #b5e7a0">&times;</span>
				<p>Os dados foram salvos com sucesso!!!</p>
			</div>

		</c:if>

	</div>

	<div class="w3-panel w3-padding-large w3-center">
		<button
			onclick="document.getElementById('id01').style.display='block'"
			class="w3-button w3-amber w3-hover-blue">Nova manutenção</button>
	</div>

	<div id="id01" class="w3-modal">
		<div class="w3-modal-content w3-animate-top">
			<header class="w3-container w3-khaki">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="w3-button w3-display-topright w3-large">&times;</span>
				<h2>Nova manutenção</h2>
			</header>
			<div class="w3-container w3-padding-large">

				<form action="controle" method="post">

					<div class="w3-row-padding" style="margin: 0 -16px;">

						<div class="w3-third w3-margin-bottom">
							<label><i class="fa fa-print"></i> Impressora</label> <select
								class="w3-select w3-border" name="id_impressora" required>
								<option value="" disabled selected>Escolha a impressora</option>
								<c:forEach var="impressora" items="${listaDeImpressoras}">
									<option value="${impressora.id_impressora}">${impressora}</option>
								</c:forEach>
							</select>

						</div>

						<div class="w3-third w3-margin-bottom">
							<label><i class="fa fa-home"></i> Assistência</label> <select
								class="w3-select w3-border" name="id_assistencia" required>
								<option value="" disabled selected>Escolha a
									Assistência</option>
								<c:forEach var="assistencia" items="${listaDeAssistencias}">
									<option value="${assistencia.id_assistencia}">${assistencia}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<hr>
					<input type="hidden" name="logica" value="SalvarManutencao" />

					<button class="w3-button w3-blue" type="submit"
						<c:out value="${teste}" />>
						<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
					</button>
				</form>
			</div>
		</div>
	</div>

	<div class="w3-panel w3-padding-large" style="height:550px; overflow: auto;">

		<c:forEach var="manutencao" items="${listaDeManutencao}">

			<form action="controle" method="post">

				<div class="w3-row w3-border-bottom">
					<div class="w3-col m1">
						<h6>
							<i class="fa fa-handshake-o"></i> Nº :
							${manutencao.id_manutencao}
						</h6>
					</div>
					<div class="w3-col m3">
						<h6>
							<i class="fa fa-home"></i> Assistência :
							${manutencao.assistencia.razao_social}
						</h6>
					</div>
					<div class="w3-col m3">
						<h6>
							<i class="fa fa-print"></i> Impressora :
							${manutencao.impressora}
						</h6>
					</div>
					<div class="w3-col m4">
						<h6>
							<i class="fa fa-rss w3-text-${manutencao.status_manutencao.cor}">
							</i> Situação : ${manutencao.status_manutencao.descricao}
						</h6>
					</div>
					<div class="w3-col m1 w3-text-indigo w3-center">

						<input type="hidden" name="id_manutencao"
							value="${manutencao.id_manutencao}" />

						<button class="w3-button w3-padding" name="logica"
							value="ManutencaoDetalhada">
							<i class="fa fa-search"></i> Detalhes
						</button>
					</div>
				</div>
			</form>
		</c:forEach>
	</div>


</t:mainpage>