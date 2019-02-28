<%@tag description="Painel de Regionais" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="regionais" required="true"%>



<div class="w3-twothird">
	<h5>Ultimas</h5>
	<table class="w3-table w3-striped w3-white">
		<c:forEach var="lista" items="${painelRegionais.lista}">
			<tr>
				<td><i class="fa fa-user"></i></td>
				<td>${lista.nome_regional}</td>
			</tr>
		</c:forEach>
	</table>
</div>