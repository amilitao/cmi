<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<button onclick="document.getElementById('identrega${emprestimo.id_emprestimo}').style.display='block'"
	class="w3-button" style="background:#ffeead" <c:out value="${param.b3}" />><b>Entrega</b></button>

<div id="identrega${emprestimo.id_emprestimo}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-khaki">
			<span onclick="document.getElementById('identrega${emprestimo.id_emprestimo}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Entrega</h2>			
		</header>		

		<div class="w3-panel w3-padding-large">			
			
			<p>Deseja confirmar a entrega da impressora na filial?</p><br>
			
			<form action="controle" method="post">					
			
				<input type="hidden" name="logica" value="AtualizarEmprestimo" />
				<input type="hidden" name="id_emprestimo" value="${emprestimo.id_emprestimo}" />
				<input type="hidden" name="id_impressora" value="${emprestimo.impressora.id_impressora}" />
				<input type="hidden" name="situacao" value="em emprestimo" />				

				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Confirmar
				</button>
			</form>
		</div>		
	</div>
</div>
