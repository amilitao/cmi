<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:mainpage>

	<br>
		<div class="w3-container w3-padding-large">
			<h2>
				<i class="fa fa-bed w3-margin-right"></i>Meus Empréstimos
			</h2>
		</div>
		<div class="w3-container w3-padding-large" style="overflow: auto; height: 300px">

			<table class="w3-table-all w3-hoverable" >
				<thead>
					<tr class="w3-red"> 
						<th>ID</th> 
						<th>Loja</th>
						<th>Impressora</th>
						<th>data de envio</th>
						<th>data de devolução</th>
						<th>situação</th>
						<th>chamado</th>
					</tr>
				</thead>
				<c:forEach var="emprestimo" items="${listaDeEmprestimos}">
				<tr>
					<td>${emprestimo.idEmprestimo}</td>
					<td>${emprestimo.loja}</td> 
					<td>${emprestimo.impressora}</td>
					<td>${emprestimo.dtEnvioFormatada}</td>
					<td>${emprestimo.dtDevolucao}</td>
					<td>${emprestimo.situacao}</td>					
					<td>${emprestimo.num_chamado}</td>
				</tr>
				</c:forEach>				
			</table>
		</div>




</t:mainpage>