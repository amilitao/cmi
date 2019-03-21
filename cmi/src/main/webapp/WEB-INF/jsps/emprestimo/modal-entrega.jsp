<%@ page language="java" contentType="text/html"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<button onclick="document.getElementById('identrega${param.idEmprestimo}').style.display='block'"
	class="w3-button" style="background:#ffeead" <c:out value="${param.b3}" />><b>Entrega</b></button>

<div id="identrega${param.idEmprestimo}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-khaki">
			<span onclick="document.getElementById('identrega${param.idEmprestimo}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2>Entrega</h2>			
		</header>		

		<div class="w3-panel w3-padding-large">			
			
			<p>Deseja confirmar a entrega da impressora na filial?</p><br>
			
			<form action="controle" method="post">					
			
				<input type="hidden" name="logica" value="AtualizarEmprestimo" />
				<input type="hidden" name="idEmprestimo" value="${param.idEmprestimo}" />
				<input type="hidden" name="idImpressora" value="${param.idImpressora}" />
				<input type="hidden" name="situacao" value="em emprestimo" />				

				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Confirmar
				</button>
			</form>
		</div>		
	</div>
</div>
