<%@ tag import="javax.servlet.http.HttpSession" %>
<%@ tag import="br.com.militao.cmi.modelo.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag language="java" pageEncoding="UTF-8"%>


<%
HttpSession sessao = request.getSession();
Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
%>

<div class="w3-container w3-row">
	<div class="w3-col s4">
		<img src="resources/style/images/avatar2.png"
			class="w3-circle w3-margin-right" style="width: 65px">
	</div>
	<div class="w3-col s8 w3-bar w3-left w3-padding-large">
		<span>Bem-vindo, <br> <strong><%= usuario%></strong></span> 		

	</div>
</div>
<hr>