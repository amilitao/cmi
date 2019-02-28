<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:mainpage>

	<div class="w3-container">
		<ul class="w3-ul">
			<c:forEach var="n" items="${notificacoes}">
				<li class="w3-bar">
					<div class="w3-bar-item">
						<span class="w3-large"> <i class="fa fa-bell-o"
							style="font-size: 25px"></i> ${n.descricao}
						</span>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>

</t:mainpage>