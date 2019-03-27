<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>


	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-cubes"></i> Lista de manutenções
		</h3>
	</div>

	<div class="w3-panel w3-padding-large">		

		<c:forEach var="manutencao" items="${listaDeManutencao}">

			<form action="controle" method="post">

				<div class="w3-row w3-border-bottom">
					<div class="w3-col m2">
						<h5>
							<i class="fa fa-handshake-o"></i> Manutencao :
							${manutencao.id_manutencao}
						</h5>
					</div>
					<div class="w3-col m2">
						<h5>
							<i class="fa fa-home"></i> Assistência : ${manutencao.assistencia.razao_social}
						</h5>
					</div>
					<div class="w3-col m3">
						<h5>
							<i class="fa fa-print"></i> Impressora : ${manutencao.impressora.modelo}
						</h5>
					</div>
					<div class="w3-col m4">
						<h5>
							<i class="fa fa-search w3-text-${manutencao.status_manutencao.cor}"> </i>
							Situação : ${manutencao.status_manutencao.descricao}
						</h5>
					</div>
					<div class="w3-col m1 w3-text-indigo w3-center">

						<input type="hidden" name="id_manutencao"
							value="${manutencao.id_manutencao}" />

						<button class="w3-button w3-padding" name="logica"
							value="ManutencaoDetalhada">
							<i class="fa fa-print"></i> Detalhes
						</button>
					</div>
				</div>
			</form>
		</c:forEach>
	</div>

</t:mainpage>