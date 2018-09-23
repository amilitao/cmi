<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<div class="w3-container">
		<h2>
			<i class="fa fa-bed w3-margin-right"></i>Meus Empréstimos
		</h2>
	</div>

	<div class="w3-container w3-padding-large">

		<c:forEach var="emprestimo" items="${listaDeEmprestimos}">

			<button onclick="myFunction('demo${emprestimo.idEmprestimo}')"
				class="w3-button w3-block w3-left-align w3-padding-small w3-border" style="background:#ffeead">

				<div class="w3-row">
					<div class="w3-col m3">
						<h4>
							<i class="fa fa-handshake-o"></i> Empréstimo :
							${emprestimo.idEmprestimo}
						</h4>
					</div>
					<div class="w3-col m5">
						<h4>
							<i class="fa fa-home"></i> Loja : ${emprestimo.loja}
						</h4>
					</div>
					<div class="w3-col m3">
						<h4>
							<i class="fa fa-search"></i> Situação :
							${emprestimo.situacao.descricao}
						</h4>
					</div>

				</div>
			</button>

			<div id="demo${emprestimo.idEmprestimo}" class="w3-hide ">
				<br>

				<div class="container w3-white">

					
					<div class="w3-row">
						
							<div class="w3-container w3-center w3-text-white"
							style="width:${emprestimo.situacao.porcentagem}; background:#ff6f69">
							<c:out value="${emprestimo.situacao.porcentagem}" />
							</div>
						
					</div>
					<div class="w3-row">
						<div class="w3-col m2 w3-center">
							<p>
								Iniciado <br /><b>${emprestimo.dataInicioFormatada}</b>
							</p>
						</div>
						<div class="w3-col m2 w3-center">
							<p>
								<c:set var="btn1" value="" />
								<c:if test="${emprestimo.situacao.porcentagem != '25%'}">
									<c:set var="btn1" value="disabled" />
								</c:if>

								<c:import url="modal-nfe.jsp">
									<c:param name="b1" value="${btn1}" />
									<c:param name="idEmprestimo" value="${emprestimo.idEmprestimo}" />
									<c:param name="idLoja" value="${emprestimo.loja.idLoja}" />
									<c:param name="nomeLoja" value="${emprestimo.loja.nome}" />
									<c:param name="cnpjLoja" value="${emprestimo.loja.cnpj}" />
									<c:param name="idImpressora"
										value="${emprestimo.impressora.idImpressora}" />
									<c:param name="impressora" value="${emprestimo.impressora}" />
									<c:param name="dtFim" value="${emprestimo.dtFim}" />
									<c:param name="prazo_devolucao"
										value="${emprestimo.prazoDevolucao}" />
								</c:import>
							</p>
						</div>
						<div class="w3-col m2 w3-center">
							<p>
								<c:set var="btn2" value="" />
								<c:if test="${emprestimo.situacao.porcentagem != '40%'}">
									<c:set var="btn2" value="disabled" />
								</c:if>

								<c:import url="modal-transporte.jsp">
									<c:param name="b2" value="${btn2}" />
									<c:param name="idEmprestimo" value="${emprestimo.idEmprestimo}" />
								</c:import>
							</p>
						</div>
						<div class="w3-col m2 w3-center">
							<p>
								<c:set var="btn3" value="" />
								<c:if test="${emprestimo.situacao.porcentagem != '60%'}">
									<c:set var="btn3" value="disabled" />
								</c:if>

								<button class="w3-button" style="background:#ffeead" ${btn3}>Entrega</button>
							</p>
						</div>
						<div class="w3-col m2 w3-center">
							<p>
								<c:set var="btn3" value="" />
								<c:if test="${emprestimo.situacao.porcentagem != '60%'}">
									<c:set var="btn3" value="disabled" />
								</c:if>

								<button class="w3-button" style="background:#ffeead" ${btn3}>Devolução</button>
							</p>
						</div>
						<div class="w3-col m2 w3-center">
							<p>
								Encerrado <br /><b>${emprestimo.dataFimFormatada}</b>
							</p>
						</div>
					</div>


				</div>

				<hr>

				<div class="w3-row-padding">

					<div class="w3-third w3-margin-bottom">
						<ul class="w3-ul w3-border w3-hover-shadow">
							<li class="w3-large w3-center"><b>Dados do empréstimo</b></li>
							<li>Loja: <b>${emprestimo.loja}</b></li>
							<li>Impressora: <b>${emprestimo.impressora}</b></li>
							<li>Chamado: <b>${emprestimo.num_chamado}</b></li>
							<li>Prazo devolução: <b>${emprestimo.prazoDevolucaoFormatada}</b></li>
						</ul>
					</div>

					<div class="w3-third w3-margin-bottom">

						<ul class="w3-ul w3-border w3-hover-shadow">
							<li class="w3-large w3-center" style="background:#ffcc5c">Transporte</li>
							<li>Transportadora: <b></b></li>
							<li><b>10</b> Domains</li>
							<li><b>10</b> Domains</li>
							<li><b>Endless</b> Support</li>
						</ul>
					</div>

					<div class="w3-third w3-margin-bottom">
						<ul class="w3-ul w3-border w3-hover-shadow">
							<li class="w3-large w3-center" style="background:#96ceb4">Devolução</li>
							<li><b>10GB</b> Storage</li>
							<li><b>10</b> Domains</li>
							<li><b>10</b> Domains</li>
							<li><b>Endless</b> Support</li>
						</ul>
					</div>
				</div>
			</div>

		</c:forEach>

	</div>

	<script>
		function myFunction(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>



</t:mainpage>