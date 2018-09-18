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

	<div class="w3-container w3-padding-large">

		<c:forEach var="emprestimo" items="${listaDeEmprestimos}">

			<button onclick="myFunction('demo${emprestimo.idEmprestimo}')"
				class="w3-button w3-block w3-left-align w3-khaki w3-border w3-border-white">

				<div class="w3-row">

					<div class="w3-row">
						<div class="w3-col w3-container" style="width: 10%">
							<p>
								<strong>Empréstimo :</strong>
							</p>
						</div>
						<div class="w3-col w3-container" style="width: 6%">
							<p>${emprestimo.idEmprestimo}</p>
						</div>
						<div class="w3-col w3-container" style="width: 5%">
							<p>
								<strong>Loja :</strong>
							</p>
						</div>
						<div class="w3-col w3-container" style="width: 15%">
							<p>${emprestimo.loja}</p>
						</div>
						<div class="w3-col w3-container" style="width: 9%">
							<p>
								<strong>Impressora :</strong>
							</p>
						</div>
						<div class="w3-col w3-container" style="width: 23%">
							<p>${emprestimo.impressora}</p>
						</div>
						<div class="w3-col w3-container" style="width: 9%">
							<p>
								<strong>Situação :</strong>
							</p>
						</div>
						<div class="w3-rest w3-container">
							<p>${emprestimo.situacao}</p>
						</div>
					</div>
				</div>


			</button>
		
				<div id="demo${emprestimo.idEmprestimo}" class="w3-hide ">


					<h2>Dynamic Progress Bar with Labels</h2>
					<p>Centered label:</p>

					<div class="w3-light-grey">
						<div id="myBar${emprestimo.idEmprestimo}"
							class="w3-container w3-green w3-center" style="width: 20%">20%</div>
					</div>
					<br>
					<button class="w3-button w3-green"
						onclick="move('myBar${emprestimo.idEmprestimo}')">Click
						Me</button>				
					<hr>
					<table class="w3-table-all w3-hoverable">
						<thead>
							<tr>
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
					</table>
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
	<script>
		function move(id) {
			var elem = document.getElementById(id);
			var width = 20;
			var id = setInterval(frame, 10);
			function frame() {
				if (width >= 100) {
					clearInterval(id);
				} else {
					width++;
					elem.style.width = width + '%';
					elem.innerHTML = width * 1 + '%';
				}
			}
		}
	</script>


</t:mainpage>