<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<div class="w3-panel w3-padding-large">
		<div class="w3-col m9">
			<h3>
				<i class="fa fa-cubes"></i> Detalhes de Empréstimo
			</h3>
		</div>
		<div class="w3-col m3">
			<form action="controle" method="post">
				<button class="w3-button w3-right" name="logica"
					value="ListarEmprestimo">
					<i class="fa fa-mail-reply"></i><b> Voltar</b>
				</button>
			</form>
		</div>
	</div>

	<div class="w3-panel w3-padding-large">

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

		<div class="container w3-padding-large">
			<div class="w3-col m3 w3-margin-bottom">
				<ul class="w3-ul">
					<li><i class="fa fa-handshake-o"></i> Empréstimo :<b>${emprestimo.idEmprestimo}</b></li>
					<li><i class="fa fa-phone-square"></i> Chamado: <b>${emprestimo.num_chamado}</b></li>
				</ul>
			</div>
			<div class="w3-col m3 w3-margin-bottom">
				<ul class="w3-ul">
					<li><i class="fa fa-home"></i> Loja: <b>${emprestimo.loja}</b></li>
					<li><i class="fa fa-calendar"></i> Prazo devolução: <b><font
							color="green">${emprestimo.prazoDevolucaoFormatada}</font></b></li>
				</ul>
			</div>
			<div class="w3-col m3 w3-margin-bottom">
				<ul class="w3-ul">
					<li><i class="fa fa-print"></i> Impressora: <b>${emprestimo.impressora}</b></li>
					<li><i class="fa fa-search"></i> Situação : <b>${emprestimo.situacao.descricao}</b></li>
				</ul>
			</div>
			<div class="w3-col m3 w3-margin-bottom">

				<form action="controle" method="post">
					<button class="w3-button w3-border w3-border-red w3-right">Cancelar
						empréstimo</button>
					<input type="hidden" name="idEmprestimo"
						value="${emprestimo.idEmprestimo}" /> <input type="hidden"
						name="situacao" value="cancelado" /> <input type="hidden"
						name="logica" value="AtualizarEmprestimo" />
				</form>
			</div>
		</div>


		<div class="container w3-padding-large">

			<div class="w3-row">
				<p class="w3-center">
					<b>Processo de empréstimo</b>
				</p>
			</div>

			<div class="w3-row">

				<c:choose>

					<c:when test="${emprestimo.situacao.porcentagem == '0%'}">

						<div class="w3-container w3-center w3-text-white"
							style="width: 100%; background: gray">
							<c:out value="${emprestimo.situacao.porcentagem}" />
							- Cancelado
						</div>

					</c:when>

					<c:otherwise>

						<div class="w3-container w3-center w3-text-white"
							style="width:${emprestimo.situacao.porcentagem}; background:#ff6f69">
							<c:out value="${emprestimo.situacao.porcentagem}" />
						</div>

					</c:otherwise>
				</c:choose>

			</div>
			<div class="w3-row w3-center">
				<div class="w3-col m2">
					<p>
						Iniciado <br /> <b>${emprestimo.dtInicioFormatada}</b>
					</p>
				</div>
				<div class="w3-col m2">
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
								value="${emprestimo.prazoDevolucaoFormatada}" />
						</c:import>
					</p>
				</div>
				<div class="w3-col m2">
					<p>
						<c:set var="btn2" value="" />
						<c:if test="${emprestimo.situacao.porcentagem != '40%'}">
							<c:set var="btn2" value="disabled" />
						</c:if>

						<c:import url="modal-transporte.jsp">
							<c:param name="b2" value="${btn2}" />
							<c:param name="idEmprestimo" value="${emprestimo.idEmprestimo}" />
							<c:param name="dtEnvio" value="now.getDate()" />
						</c:import>
					</p>
				</div>
				<div class="w3-col m2">
					<p>
						<c:set var="btn3" value="" />
						<c:if test="${emprestimo.situacao.porcentagem != '60%'}">
							<c:set var="btn3" value="disabled" />
						</c:if>

						<c:import url="modal-entrega.jsp">
							<c:param name="b3" value="${btn3}" />
							<c:param name="idEmprestimo" value="${emprestimo.idEmprestimo}" />
						</c:import>
					</p>
				</div>
				<div class="w3-col m2">
					<p>
						<c:set var="btn4" value="" />
						<c:if test="${emprestimo.situacao.porcentagem != '75%'}">
							<c:set var="btn4" value="disabled" />
						</c:if>

						<c:import url="modal-devolucao.jsp">
							<c:param name="b4" value="${btn4}" />
							<c:param name="idEmprestimo" value="${emprestimo.idEmprestimo}" />
						</c:import>
					</p>
				</div>
				<div class="w3-col m2 w3-margin-bottom">
					<p>
						Encerrado <br /> <b>${emprestimo.dtFimFormatada}</b>
					</p>
				</div>
			</div>
		</div>


		<div class="container w3-padding-large">

			<div class="w3-row-padding">

				<c:set var="transporte" value="${null}" />
				<c:if test="${not empty listaDeTransportes}">
					<c:forEach var="transp" items="${listaDeTransportes}">
						<c:set var="transporte" value="${transp}" />
					</c:forEach>
				</c:if>

				<div class="w3-third w3-margin-bottom">

					<ul class="w3-ul w3-border w3-hover-shadow">
						<li class="w3-large w3-center" style="background: #f4ab43"><b>Transporte</b></li>
						<li>Transportadora: <b>${transporte.nomeTransportadora}</b></li>
						<li>Número de NFe de envio: <b>${transporte.numNfeEnvio}</b></li>
						<li>Data de envio: <b>${transporte.dtEnvioFormatada}</b></li>
					</ul>
				</div>

				<c:set var="devolucao" value="${null}" />
				<c:if test="${not empty listaDeDevolucoes}">
					<c:forEach var="devol" items="${listaDeDevolucoes}">
						<c:if
							test="${devol.emprestimo.idEmprestimo == emprestimo.idEmprestimo}">
							<c:set var="devolucao" value="${devol}" />
						</c:if>
					</c:forEach>
				</c:if>
				<div class="w3-third w3-margin-bottom">
					<ul class="w3-ul w3-border w3-hover-shadow">
						<li class="w3-large w3-center" style="background: #5ebf99"><b>Devolução</b></li>
						<li>Número da NFe: <b>${devolucao.numNfeDevolucao}</b></li>
						<li>Recebedor: <b>${devolucao.recebedor}</b></li>
						<li>Data da devolução: <b>${devolucao.dtDevolucaoFormatada}</b></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="w3-panel w3-padding-large">

			<button onclick="myFunction('Demo1')"
				class="w3-button w3-block w3-left-align w3-dark-grey w3-border w3-border-black w3-center">
				<b>Histórico do empréstimo</b>
			</button>

			<div id="Demo1" class="w3-hide w3-container w3-pale-yellow">

				<c:forEach var="historico" items="${historicos}">

					<ul class="w3-ul">
						<li>
							<div class="w3-row">
								<div class="w3-col m9">
									<b>Ocorrencia:</b> ${historico.ocorrencia}
								</div>
								<div class="w3-col m3">
									<b>Data:</b> ${historico.dtRegistroFormatada}
								</div>
							</div>
						</li>
					</ul>
				</c:forEach>
			</div>
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

	</div>

</t:mainpage>


