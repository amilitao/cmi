<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>


	<div class="w3-container">
		<h2>
			<i class="fa fa-cubes"></i> Meus Empréstimos
		</h2>
	</div>

	<div class="w3-container w3-padding-large">

		<c:if test="${confirmaDao}">
			<c:set var="teste" value="disabled" />
			<div class="w3-panel w3-display-container"
				style="background: #b5e7a0">
				<span onclick="this.parentElement.style.display='none'"
					class="w3-button  w3-large w3-display-topright"
					style="background: #b5e7a0">&times;</span>
				<p>Os dados foram salvos com sucesso!!!</p>
			</div>

		</c:if>

		<hr>
		<c:forEach var="emprestimo" items="${listaDeEmprestimos}">

			<form action="controle" method="post">

				<div class="w3-row w3-border-bottom w3-border-green">
					<div class="w3-col m3">
						<h4>
							<i class="fa fa-handshake-o"></i> Empréstimo :
							${emprestimo.idEmprestimo}
						</h4>
					</div>
					<div class="w3-col m3">
						<h4>
							<i class="fa fa-home"></i> Loja : ${emprestimo.loja}
						</h4>
					</div>
					<div class="w3-col m3">
						<h4>
							<i class="fa fa-search w3-text-${emprestimo.situacao.cor}"> </i>
							Situação : ${emprestimo.situacao.descricao}
						</h4>
					</div>
					<div class="w3-col m2 w3-text-indigo w3-center">

						<input type="hidden" name="id_emprestimo"
							value="${emprestimo.idEmprestimo}" />

						<button class="w3-button w3-padding" name="logica"
							value="EmprestimoDetalhado">
							<i class="fa fa-print"></i> Detalhes
						</button>
					</div>
				</div>
			</form>
		</c:forEach>

	</div>

</t:mainpage>