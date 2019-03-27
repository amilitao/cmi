<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>


	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-cubes"></i> Meus Empréstimos
		</h3>
	</div>

	<div class="w3-panel w3-padding-large">		

		<c:forEach var="emprestimo" items="${listaDeEmprestimos}">

			<form action="controle" method="post">

				<div class="w3-row w3-border-bottom">
					<div class="w3-col m3">
						<h4>
							<i class="fa fa-handshake-o"></i> Empréstimo :
							${emprestimo.id_emprestimo}
						</h4>
					</div>
					<div class="w3-col m3">
						<h4>
							<i class="fa fa-home"></i> Loja : ${emprestimo.loja}
						</h4>
					</div>
					<div class="w3-col m4">
						<h4>
							<i class="fa fa-search w3-text-${emprestimo.situacao.cor}"> </i>
							Situação : ${emprestimo.situacao.descricao}
						</h4>
					</div>
					<div class="w3-col m2 w3-text-indigo w3-center">

						<input type="hidden" name="id_emprestimo"
							value="${emprestimo.id_emprestimo}" />

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