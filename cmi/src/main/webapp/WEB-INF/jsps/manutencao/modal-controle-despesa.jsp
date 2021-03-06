<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<button
	onclick="document.getElementById('idDesp${manutencao.id_manutencao}').style.display='block'"
	class="w3-button w3-circle w3-border w3-yellow"
	<c:out value="${param.b5}" />>
	<b>+</b>
</button>
<br />
<b>Controle de Despesa</b>

<div id="idDesp${manutencao.id_manutencao}" class="w3-modal">
	<div class="w3-modal-content w3-animate-top w3-card-4 w3-left-align">
		<header class="w3-container w3-center w3-khaki">
			<span
				onclick="document.getElementById('idDesp${manutencao.id_manutencao}').style.display='none'"
				class="w3-button w3-display-topright w3-xlarge">&times;</span>
			<h2> Controle de Despesa</h2>
		</header>
		<div class="w3-panel w3-padding-large">			

			<form action="controle" method="post">	
			
			<div class="w3-row-padding" style="margin: 0 -16px;">
				
					<div class="w3-col m3 w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Controle de despesa: </label> 
						<input class="w3-input w3-border" type="number" name="numero_despesa" required>
					</div>										
				</div>							
				
				<br> <input type="hidden" name="logica" value="SalvarControleDespesa" /> 
				<input type="hidden" name="id_manutencao" value="${manutencao.id_manutencao}" />			
			
				<button class="w3-button w3-khaki" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>

	</div>
</div>
