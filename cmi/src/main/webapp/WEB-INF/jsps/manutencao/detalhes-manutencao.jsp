<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<div class="w3-panel w3-padding-large">
		<div class="w3-col m9">
			<h3>
				<i class="fa fa-cubes"></i> Detalhes de Manutenção
			</h3>
		</div>
		<div class="w3-col m3">
			<form action="controle" method="post">
				<button class="w3-button w3-right" name="logica"
					value="ListarManutencao">
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
			<div class="w3-col m2 w3-margin-bottom">
				<ul class="w3-ul">
					<li><i class="fa fa-handshake-o"></i> Manutenção :<b>${manutencao.id_manutencao}</b></li>
					<li><i class="fa fa-phone-square"></i> Chamado: <b>Livre</b></li>
				</ul>
			</div>
			<div class="w3-col m4 w3-margin-bottom">
				<ul class="w3-ul">
					<li><i class="fa fa-home"></i> Assistencia: <b>${manutencao.assistencia.razao_social}</b></li>
					<li><i class="fa fa-calendar"></i> Email: <b>${manutencao.assistencia.email}</b></li>
				</ul>
			</div>
			<div class="w3-col m3 w3-margin-bottom">
				<ul class="w3-ul">
					<li><i class="fa fa-print"></i> Impressora: <b>${manutencao.impressora}</b></li>
					<li class="w3-border w3-border-${manutencao.status_manutencao.cor}"><i
						class="fa fa-search"></i> Situação : <b>${manutencao.status_manutencao.descricao}</b></li>
				</ul>
			</div>
		</div>

		<div class="container">

			<div class="w3-row">
				<p class="w3-center w3-border">
					<b>Processo de manutenção</b>
				</p>
			</div>

			<div class="w3-row">

				<c:choose>

					<c:when test="${manutencao.status_manutencao.porcentagem == '0%'}">

						<div class="w3-container w3-center w3-text-white"
							style="width: 100%; background: gray">
							<c:out value="${manutencao.status_manutencao.porcentagem}" />
							- Cancelado
						</div>

					</c:when>

					<c:otherwise>

						<div class="w3-container w3-center w3-text-white"
							style="width:${manutencao.status_manutencao.porcentagem}; background:#ff6f69">
							<c:out value="${manutencao.status_manutencao.porcentagem}" />
						</div>

					</c:otherwise>
				</c:choose>
			</div>

			<div class="w3-row w3-center">
				<div class="w3-col m1">
					<p>
						Iniciado <br /> <b>${manutencao.dtInicioFormatada}</b>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<b><i class="fa fa-chevron-right"></i></b>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<c:set var="btn1" value="" />
						<c:if test="${manutencao.status_manutencao.porcentagem != '20%'}">
							<c:set var="btn1" value="disabled" />
						</c:if>

						<c:import url="modal-teste.jsp">
							<c:param name="b1" value="${btn1}" />
						</c:import>

					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<c:set var="btn2" value="" />
						<c:if test="${manutencao.status_manutencao.porcentagem != '30%'}">
							<c:set var="btn2" value="disabled" />
						</c:if>
						<c:import url="modal-solicita-nfe.jsp">
							<c:param name="b2" value="${btn2}" />
						</c:import>

					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<c:set var="btn3" value="" />
						<c:if test="${manutencao.status_manutencao.porcentagem != '40%'}">
							<c:set var="btn3" value="disabled" />
						</c:if>
						<c:import url="modal-envio-de-impressora.jsp">
							<c:param name="b3" value="${btn3}" />
						</c:import>

					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<c:set var="btn4" value="" />
						<c:if test="${manutencao.status_manutencao.porcentagem != '45%'}">
							<c:set var="btn4" value="disabled" />
						</c:if>
						<c:import url="modal-orcamento.jsp">
							<c:param name="b4" value="${btn4}" />
						</c:import>

					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<c:set var="btn5" value="" />
						<c:if test="${manutencao.status_manutencao.porcentagem != '55%'}">
							<c:set var="btn5" value="disabled" />
						</c:if>
						<c:import url="modal-controle-despesa.jsp">
							<c:param name="b5" value="${btn5}" />
						</c:import>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<button class="w3-button w3-circle w3-gray">+</button>
						<br /> <b>Aprovado?</b>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<button class="w3-button w3-circle w3-gray">+</button>
						<br /> <b>Retorno</b>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<button class="w3-button w3-circle w3-gray">+</button>
						<br /> <b>Nota fiscal de pagamento</b>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<i class="fa fa-chevron-right"></i>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						Encerrado <br /> <b>${manutencao.dtFimFormatada}</b>
					</p>
				</div>

			</div>
		</div>

		<br>


		<div class="w3-row-padding">

			<div class="w3-third w3-margin-bottom">

				<ul class="w3-ul w3-border w3-hover-shadow">
					<li class="w3-large w3-center" style="background: #f4ab43"><b>Problema
							da impressora</b></li>
					<li><b>${checklist_teste.desc_problema}</b></li>

				</ul>
			</div>
			
			
			<c:set var="orcamento" value="${null}" />			
			
			<div class="w3-third w3-margin-bottom">			
				<ul class="w3-ul w3-border w3-hover-shadow">				
					<li class="w3-large w3-center" style="background: #5ebf99"><b>Orçamento</b></li>
				
						<c:if test="${empty listaDeOrcamento}">
							<li><b>Sem orçamento</b></li>
						</c:if>
						<c:if test="${not empty listaDeOrcamento}">
							<c:forEach var="orc" items="${listaDeOrcamento}">
								<c:set var="orcamento" value="${orc}" />							
								<li><b>Número: </b>${orcamento.numero_orcamento}
					  			 | <b>Valor: </b>${orcamento.valor_total}
								 | <b>Status: </b>
										 <a class="w3-text-${orcamento.status.cor}">
											 <b>${orcamento.status.descricao}</b>
										 </a>								 
									
								</li>
							</c:forEach>				
						</c:if>																						
				</ul>
			</div>				
			
			<div class="w3-third w3-margin-bottom">

				<ul class="w3-ul w3-border w3-hover-shadow">
					<li class="w3-large w3-center w3-light-blue"><b>Despesa</b></li>
					<li><b>Numero: </b></li>
					<li><b>Valor: </b></li>
					<li><b>Data: </b></li>

				</ul>
			</div>
		</div>
	</div>
</t:mainpage>