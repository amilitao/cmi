<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<br>
		<div class="w3-container">
			<h2>
				<i class="fa fa-bed w3-margin-right"></i>Novo Empréstimo
			</h2>
		</div>
		<div class="w3-panel w3-padding-large">

			<form action="controle" method="post">

				<div class="w3-row-padding" style="margin: 0 -16px;">
					<div class="w3-third w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Loja</label>
							
						 <select class="w3-input w3-border" name="id_loja" required>
							<c:forEach var="loja" items="${lojas}">
								<option value="${loja.id_loja}">${loja}</option>
							</c:forEach>						
						</select>

					</div>
					<div class="w3-third">
						<label><i class="fa fa-calendar-o"></i> Impressora</label> 
						<select class="w3-input w3-border" name="id_impressora" required>
							<c:forEach var="impressora" items="${impressoras}">
								<option value="${impressora.id_impressora}">${impressora}</option>
							</c:forEach>						
						</select>
						
					</div>
					<div class="w3-third">
						<label><i class="fa fa-calendar-o"></i> Número do chamado</label>
						<input class="w3-input w3-border" type="text" name="num_chamado" required>
					</div>
				</div>
				<br>
				<input type="hidden" name="logica" value="SalvarEmprestimo" />
				
				<button class="w3-button w3-blue" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>




</t:mainpage>