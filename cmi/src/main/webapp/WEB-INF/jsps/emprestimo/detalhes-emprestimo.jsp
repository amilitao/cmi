<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<div class="w3-container">
		<h2>
			<i class="fa fa-cubes"></i> Detalhes de Empréstimo
		</h2>
	</div>
	
	<hr>

	<div class="w3-container w3-padding-large">



		<div class="w3-row">

			<div class="w3-container w3-center w3-text-white"
				style="width:${emprestimo.situacao.porcentagem}; background:#ff6f69">
				<c:out value="${emprestimo.situacao.porcentagem}" />
			</div>

		</div>
		<div class="w3-row">
			<div class="w3-col m2 w3-center">
				<p>
					Iniciado <br /> <b>${emprestimo.dtInicioFormatada}</b>
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
							value="${emprestimo.prazoDevolucaoFormatada}" />
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
						<c:param name="dtEnvio" value="now.getDate()" />
					</c:import>
				</p>
			</div>
			<div class="w3-col m2 w3-center">
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
			<div class="w3-col m2 w3-center">
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
			<div class="w3-col m2 w3-center">
				<p>
					Encerrado <br /> <b>${emprestimo.dtFimFormatada}</b>
				</p>
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
					<li>Prazo devolução: <b><font color="green">${emprestimo.prazoDevolucaoFormatada}</font></b></li>
				</ul>
			</div>

			<c:set var="transporte" value="${null}" />
			<c:if test="${not empty listaDeTransportes}">
				<c:forEach var="transp" items="${listaDeTransportes}">
					<c:set var="transporte" value="${transp}" />
				</c:forEach>
			</c:if>

			<div class="w3-third w3-margin-bottom">

				<ul class="w3-ul w3-border w3-hover-shadow">
					<li class="w3-large w3-center w3-text-white"
						style="background: #f4ab43">Transporte</li>
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
					<li class="w3-large w3-center w3-text-white"
						style="background: #5ebf99">Devolução</li>
					<li>Número da NFe: <b>${devolucao.numNfeDevolucao}</b></li>
					<li>Recebedor: <b>${devolucao.recebedor}</b></li>
					<li>Data da devolução: <b>${devolucao.dtDevolucaoFormatada}</b></li>
				</ul>
			</div>
		</div>
	</div>
</t:mainpage>

