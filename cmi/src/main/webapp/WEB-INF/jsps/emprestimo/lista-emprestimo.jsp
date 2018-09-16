<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:mainpage>

	<br>
		<div class="w3-container">
			<h2>
				<i class="fa fa-bed w3-margin-right"></i>Meus Empréstimos
			</h2>
		</div>
		<div class="w3-container w3-padding-large" style="overflow: auto; height: 300px">

			<table class="w3-table-all w3-hoverable" >
				<thead>
					<tr class="w3-blue"> 
						<th>ID</th> 
						<th>data de inicio</th>	
						<th>chamado</th>
						<th>Loja</th>
						<th>Impressora</th>											
						<th>situação</th>						
						<th>data do fim</th>
						<th>prazo devolução</th>
					</tr>
				</thead>
				<c:forEach var="emprestimo" items="${listaDeEmprestimos}">
				<tr>
					<td>${emprestimo.idEmprestimo}</td>
					<td>${emprestimo.dataInicioFormatada}</td>
					<td>${emprestimo.num_chamado}</td>
					<td>${emprestimo.loja}</td> 
					<td>${emprestimo.impressora}</td>
					<td>${emprestimo.situacao}</td>		
					<td>${emprestimo.dataFimFormatada}</td>
					<td>${emprestimo.prazoDevolucaoFormatada}</td>								
					
				</tr>
				</c:forEach>				
			</table>
		</div>




</t:mainpage>