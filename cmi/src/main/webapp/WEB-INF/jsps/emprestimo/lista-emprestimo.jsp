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
				class="w3-button w3-block w3-left-align w3-padding-small w3-white w3-border w3-border-blue w3-round-large">

				<div class="w3-row">

					<div class="w3-row">
						<div class="w3-col w3-container" style="width: 12%">
							<h4>Empréstimo :</h4>
						</div>
						<div class="w3-col w3-container" style="width: 8%">
							<h4>
								<b>${emprestimo.idEmprestimo}</b>
							</h4>
						</div>
						<div class="w3-col w3-container" style="width: 7%">
							<h4>Loja :</h4>
						</div>
						<div class="w3-col w3-container" style="width: 35%">
							<h4>
								<b>${emprestimo.loja}</b>
							</h4>
						</div>
						<div class="w3-col w3-container" style="width: 11%">
							<h4>Situação :</h4>
						</div>
						<div class="w3-rest w3-container">
							<h4>
								<b>${emprestimo.situacao}</b>
							</h4>
						</div>
					</div>
				</div>
			</button>

			<div id="demo${emprestimo.idEmprestimo}" class="w3-hide ">
				<br>

				<div class="container w3-white">

					<div class="w3-light-grey w3-tiny">
						<div class="w3-container w3-center w3-green"
							style="width:${emprestimo.situacao.porcentagem}">
							<c:out value="${emprestimo.situacao.porcentagem}" />
						</div>
					</div>			
														
					
					<div class="w3-row">
						<div class="w3-col w3-center w3-container" style="width: 10%">
							<p>
								Iniciado <b>${emprestimo.dataInicioFormatada}</b>
							</p>

						</div>
						<div class="w3-col w3-container" style="width: 20%">
							<p>
								<c:set var="btn1" value="" />
								<c:if test="${emprestimo.situacao.porcentagem != '20%'}">
									<c:set var="btn1" value="disabled" />
								</c:if>	
							
								<c:import url="modal-nfe.jsp">
									 <c:param name="b1" value="${btn1}"/>
								</c:import>
							</p>
						</div>
						
						<div class="w3-col w3-container" style="width: 20%">
							<p>
								<c:set var="btn2" value="" />
								<c:if test="${emprestimo.situacao.porcentagem != '40%'}">
									<c:set var="btn2" value="disabled" />
								</c:if>					
							
								<c:import url="modal-transporte.jsp" >
									 <c:param name="b2" value="${btn2}"/>
								</c:import>
							</p>
						</div>
						
						<div class="w3-col w3-container" style="width: 20%">
							<p>
								<c:set var="btn3" value="" />
								<c:if test="${emprestimo.situacao.porcentagem != '60%'}">
									<c:set var="btn3" value="disabled" />
								</c:if>	
							
								<button class="w3-button w3-khaki" ${btn3}>Entrega</button>
							</p>
						</div>
						
						<div class="w3-col w3-container" style="width: 20%">												
							<p>
								<c:set var="btn4" value="" />
								<c:if test="${emprestimo.situacao.porcentagem != '80%'}">
									<c:set var="btn4" value="disabled" />
								</c:if>	
							
								<c:import url="modal-devolucao.jsp">
									 <c:param name="b4" value="${btn4}"/>
								</c:import>
							</p>
						</div>
						
						<div class="w3-col w3-container w3-center" style="width: 10%">
							<p>
								Encerrado <b>${emprestimo.dataFimFormatada}</b>
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

						<ul class="w3-ul w3-border w3-center w3-hover-shadow">
							<li class="w3-green w3-large">Transporte</li>
							<li><b>10GB</b> Storage</li>
							<li><b>10</b> Domains</li>
							<li><b>10</b> Domains</li>
							<li><b>Endless</b> Support</li>
						</ul>
					</div>

					<div class="w3-third w3-margin-bottom">
						<ul class="w3-ul w3-border w3-center w3-hover-shadow">
							<li class="w3-black w3-large">Devolução</li>
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