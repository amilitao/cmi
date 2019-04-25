<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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

		<!--  Mensagem de gravação de dados no banco --------------------------------------------------------------------->

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
		<!----------------------------------------------------------------------------------------------------------------->

		<div class="container">
			<div class="w3-col m3 w3-margin-bottom">
				<ul class="w3-ul">
					<li><i class="fa fa-handshake-o"></i> Empréstimo :<b>${emprestimo.id_emprestimo}</b></li>
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
					<li class="w3-border w3-border-${emprestimo.situacao.cor}"><i
						class="fa fa-search"></i> Situação : <b>${emprestimo.situacao.descricao}</b></li>
				</ul>
			</div>
			<div class="w3-col m3 w3-margin-bottom">

				<!-- botão CANCELAR emprestimo ------------------------------------------------------------------------------->

				<c:set var="btnCancelar" value="" />
				<c:if
					test="${emprestimo.situacao.porcentagem != '25%' && emprestimo.situacao.porcentagem != '40%'}">
					<c:set var="btnCancelar" value="disabled" />
				</c:if>

				<button
					onclick="document.getElementById('idCancel').style.display='block'"
					class="w3-button w3-border w3-border-red w3-right"
					<c:out value="${btnCancelar}"></c:out>>Cancelar empréstimo</button>

				<div id="idCancel" class="w3-modal">
					<div class="w3-modal-content w3-padding-large w3-khaki">
						<div class="w3-container w3-padding-large">
							<h4>Deseja realmente cancelar o empréstimo?</h4>
						</div>

						<div class="w3-bar">

							<form action="controle" method="post">

								<input type="hidden" name="id_emprestimo"
									value="${emprestimo.id_emprestimo}" /> <input type="hidden"
									name="id_impressora"
									value="${emprestimo.impressora.id_impressora}" /> <input
									type="hidden" name="situacao" value="cancelado" /><input
									type="hidden" name="statusImpressora" value="disponivel" /> <input
									type="hidden" name="logica" value="CancelarEmprestimo" />

								<button class="w3-button w3-text-white" type="submit"
									style="background: #ff6f69">
									<b>Cancelar empréstimo</b>
								</button>
								<button
									onclick="document.getElementById('idCancel').style.display='none'"
									class="w3-button w3-gray w3-text-white w3-right" type="button">
									<b>Voltar</b>
								</button>

							</form>

						</div>
					</div>
				</div>

				<!------------------------------------------------------------------------------------------------------------>

			</div>
		</div>


		<div class="container">

			<div class="w3-row">
				<p class="w3-center w3-border">
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

		<br>


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
						test="${devol.emprestimo.id_emprestimo == emprestimo.id_emprestimo}">
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
			<div class="w3-third w3-margin-bottom">

				<div class="w3-bar-block">

					<c:set var="btnPdf" value="" />
					<c:if test="${emprestimo.situacao.porcentagem != '60%'}">
						<c:set var="btnPdf" value="disabled" />
					</c:if>

					<form action="controle/pdf" method="post" target="_blank">
						<input type="hidden" name="loja" value="${emprestimo.loja.nome}" />
						<input type="hidden" name="numero_loja"
							value="${emprestimo.loja.numero_loja}" /> <input type="hidden"
							name="endereco" value="${emprestimo.loja.endereco}" /> <input
							type="hidden" name="telefone" value="${emprestimo.loja.telefone}" />
						<input type="hidden" name="modelo"
							value="${emprestimo.impressora}" /> <input type="hidden"
							name="nfe" value="${transporte.numNfeEnvio}" />

						<button
							class="w3-bar-item w3-button w3-padding w3-text-purple w3-margin-bottom"
							<c:out value="${btnPdf}" />>
							<i class="fa fa-file-pdf-o"></i><b> Papeleta em PDF</b>
						</button>
					</form>

				</div>

			</div>

		</div>

		<div class="container w3-border">
			<div class="w3-row-padding">

				<div class="w3-bar">
					<button class="w3-bar-item w3-button tablink w3-light-blue"
						onclick="openCity(event,'London')">
						<b>Comentário</b>
					</button>
					<button class="w3-bar-item w3-button tablink"
						onclick="openCity(event,'Paris')">
						<b>Histórico</b>
					</button>
				</div>

				<div class="container">
					<div id="London" class="city">
						<form action="controle" method="post">
							<div class="w3-row w3-padding-16">

								<div class="w3-col m8">
									<textarea class="w3-col" style="width: 100%" rows="3"
										name="comentario"></textarea>
									<input type="hidden" name="id_emprestimo"
										value="${emprestimo.id_emprestimo}" />
								</div>
								<div class="w3-col m1 w3-row-padding w3-margin-top w3-center">
									<button class="w3-button w3-margin-left w3-dark-grey"
										name="logica" value="SalvarComentario">
										<b>Salvar</b>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div id="Paris" class="w3-border city" style="display: none">
					<c:forEach var="historico" items="${historicos}">
						<ul class="w3-ul">
							<li>
								<div class="w3-row">
									<div class="w3-col m8">
										<b>Ocorrência:</b> ${historico.ocorrencia}
									</div>
									<div class="w3-col m2">
										<b>Data:</b> ${historico.dtRegistroFormatada}
									</div>
									<div class="w3-col m2">
										<b>Usuario:</b> ${historico.usuario.login}
									</div>
								</div>
							</li>
						</ul>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>


	<script>
		function openCity(evt, cityName) {
			var i, x, tablinks;
			x = document.getElementsByClassName("city");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < x.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" w3-light-blue", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " w3-light-blue";
		}
	</script>
</t:mainpage>