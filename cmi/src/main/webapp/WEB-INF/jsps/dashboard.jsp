<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="com" tagdir="/WEB-INF/tags/componente"%>


<t:mainpage>

	<!-- Header -->
	<header class="w3-container">
		<h5>
			<b><i class="fa fa-dashboard"></i> Meu Dashboard</b>
		</h5>
	</header>
	
	<com:painel-status
		qtdDisponivel="${painelStatusImpressora.qtdDisponivel}"
		qtdEmprestimo="${painelStatusImpressora.qtdEmprestimo}"
		qtdManutencao="${painelStatusImpressora.qtdManutencao}"
		qtdDefeito="${painelStatusImpressora.qtdDefeito}" />


	<div class="w3-row w3-container">
		<div class="w3-row-padding" style="margin: 0 -16px">
			<div class="w3-half">
				<h5>
					<b>Status de movimentação</b>
				</h5>
				Empréstimos finalizados
				<div class="w3-grey w3-margin-bottom">
					<div class="w3-container w3-center w3-padding"
						style="width: 95%; background: #59c4e4">95%</div>
				</div>
				Manutenções finalizadas
				<div class="w3-grey w3-margin-bottom">
					<div class="w3-container w3-center w3-padding"
						style="width: 100%; background: #f4ab43">100%</div>
				</div>
				Impressoras devolvidas no prazo
				<div class="w3-grey w3-margin-bottom">
					<div class="w3-container w3-center w3-padding"
						style="width: 80%; background: #92A8D1">80%</div>
				</div>
			</div>
			<div class="w3-half">
				<h5><b>Visão Geral</b></h5>
				<table class="w3-table w3-striped w3-white">
					<tr>
						<td><i class="fa fa-user w3-text-blue w3-large"></i></td>
						<td>Total de impressoras.</td>
						<td><i>10</i></td>
					</tr>
					<tr>
						<td><i class="fa fa-bell w3-text-red w3-large"></i></td>
						<td>Total de emprestimos</td>
						<td><i>15</i></td>
					</tr>
					<tr>
						<td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
						<td>Total de manutenções</td>
						<td><i>17</i></td>
					</tr>
					<tr>
						<td><i class="fa fa-comment w3-text-red w3-large"></i></td>
						<td>Total de emprestimos cancelados</td>
						<td><i>1</i></td>
					</tr>
					<tr>
						<td><i class="fa fa-bookmark w3-text-blue w3-large"></i></td>
						<td>Total de notas fiscais emitidas</td>
						<td><i>28</i></td>
					</tr>
					<tr>
						<td><i class="fa fa-laptop w3-text-red w3-large"></i></td>
						<td>Total de custo com manunteção</td>
						<td><i>35</i></td>
					</tr>					
				</table>
			</div>
		</div>
	</div>

	<hr>
	
	<com:painel-ultimas-atualizacoes
	ultima_id_emprestimo="${painelUltimasAtualizacoes.ultima_id_emprestimo}" 
	ultima_usuario="${painelUltimasAtualizacoes.ultima_usuario}" 
	ultima_ocorrencia="${painelUltimasAtualizacoes.ultima_ocorrencia}" 
	ultima_data="${painelUltimasAtualizacoes.ultima_dt_ocorrencia}" 
	penultima_id_emprestimo="${painelUltimasAtualizacoes.penultima_id_emprestimo}" 
	penultima_usuario="${painelUltimasAtualizacoes.penultima_usuario}" 
	penultima_ocorrencia="${painelUltimasAtualizacoes.penultima_ocorrencia}" 
	penultima_data="${painelUltimasAtualizacoes.penultima_dt_ocorrencia}" />
	
	<!-- Footer -->
	<footer class="w3-container w3-padding-16 w3-light-grey">
		<p>
			©2019 Atacadão - Desenvolvido por Produção Informática
		</p>
	</footer>

	<!-- End page content -->


</t:mainpage>