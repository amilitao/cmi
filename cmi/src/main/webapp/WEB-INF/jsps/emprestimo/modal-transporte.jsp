<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	



<button onclick="document.getElementById('id02').style.display='block'"
	class="w3-button w3-khaki" <c:out value="${param.b2}" /> >Transporte</button>

<div id="id02" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4">
		<header class="w3-container w3-teal">
			<span onclick="document.getElementById('id02').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<h2>Modal Header</h2>
		</header>

		<div class="w3-panel w3-padding-large">

			<form action="controle" method="post">

				<div class="w3-row-padding" style="margin: 0 -16px;">

					<div class="w3-third">
						<label><i class="fa fa-calendar-o"></i> Número do chamado</label>
						<input class="w3-input w3-border" type="text" name="num_chamado"
							required>
					</div>
				</div>
				<br> <input type="hidden" name="logica" value="Teste" />

				<button class="w3-button w3-blue" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>


		<footer class="w3-container w3-teal">
			<p>Modal Footer</p>
		</footer>
	</div>
</div>
