<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
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
			<div class="w3-col m3 w3-margin-bottom">
				<ul class="w3-ul">
					<li><i class="fa fa-handshake-o"></i> Manutenção :<b>${manutencao.id_manutencao}</b></li>
					<li><i class="fa fa-phone-square"></i> Chamado: <b>Livre</b></li>
				</ul>
			</div>
			<div class="w3-col m3 w3-margin-bottom">
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
						<button class="w3-button w3-circle w3-border w3-gray">+</button>
						<br /> <b>Teste local</b>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<button class="w3-button w3-circle w3-gray">+</button>
						<br /> <b>Solicitar NFE</b>

					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<button class="w3-button w3-circle w3-gray">+</button>
						<br /> <b>Solicitar Orçamento</b>

					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<button class="w3-button w3-circle w3-gray">+</button>
						<br /> <b>Orçamento</b>
					</p>
				</div>
				<div class="w3-col m1">
					<p>
						<button class="w3-button w3-circle w3-gray">+</button>
						<br /> <b>Controle de despesa</b>
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

			<br>


			<div class="w3-row-padding">

				<div class="w3-third w3-margin-bottom">

					<ul class="w3-ul w3-border w3-hover-shadow">
						<li class="w3-large w3-center" style="background: #f4ab43"><b>Problema da impressora</b></li>
						<li><b>Problema  1</b></li>
						<li><b>Problema  2</b></li>
						<li><b>Problema  3</b></li>

					</ul>
				</div>
				<div class="w3-third w3-margin-bottom">

					<ul class="w3-ul w3-border w3-hover-shadow">
						<li class="w3-large w3-center" style="background: #5ebf99"><b>Orçamento</b></li>
						<li><b>Orçamento 1</b><h6 class="w3-green w3-right">Aprovado</h6></li>
						<li><b>Orçamento 2</b></li>
						<li><b>Orçamento 3</b></li>
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
</t:mainpage>