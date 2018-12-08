<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:mainpage>

	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-database"></i> Histórico de emprestimo
		</h3>
	</div>

	<div class="w3-panel w3-padding-large">

		<c:forEach var="emprestimo" items="${emprestimos}">

			<button onclick="myFunction('Demo${emprestimo.idEmprestimo}')"
				class="w3-button w3-block w3-left-align">

				<div class="w3-row">
					<div class="w3-col m3">
						<h5>
							<i class="fa fa-handshake-o"></i> Empréstimo :
							${emprestimo.idEmprestimo}
						</h5>
					</div>
					<div class="w3-col m5">
						<h5>
							<i class="fa fa-home"></i> Loja : ${emprestimo.loja}
						</h5>
					</div>
					<div class="w3-col m2">
						<h5>
							<i class="fa fa-search w3-text-${emprestimo.situacao.cor}"> </i>
							Situação : ${emprestimo.situacao.descricao}
						</h5>
					</div>
				</div>

			</button>

			<div id="Demo${emprestimo.idEmprestimo}" class="w3-hide w3-container">

				<c:forEach var="historico" items="${historicos}">
					<c:if
						test="${historico.emprestimo.idEmprestimo == emprestimo.idEmprestimo}">

						<ul class="w3-ul">
							<li>
								<div class="w3-row w3-text-indigo">									
									<div class="w3-col m9">
										<b>Ocorrencia:</b> ${historico.ocorrencia}
									</div>
									<div class="w3-col m3">
										<b>Data:</b> ${historico.dtRegistroFormatada}
									</div>
								</div>
							</li>
						</ul>

					</c:if>
				</c:forEach>

			</div>

		</c:forEach>

	</div>


	<script>
		function myFunction(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace("w3-black", "w3-red");
			} else {
				x.className = x.className.replace(" w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace("w3-red", "w3-black");
			}
		}
	</script>



</t:mainpage>