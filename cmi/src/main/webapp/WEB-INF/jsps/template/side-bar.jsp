<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
	style="z-index: 3; width: 300px;" id="mySidebar">
	<br>
	<div class="w3-container w3-row">
		<div class="w3-col s4">
			<img src="resources/style/images/avatar2.png" class="w3-circle w3-margin-right"
				style="width: 70px">
		</div>
		<div class="w3-col s8 w3-bar">
			<span>Bem-vindo, <strong>Usuario</strong></span>
			<br> 
			<a href="#"	class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a> 
			<a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
			<a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
		</div>
	</div>
	<hr>
	<div class="w3-container">
		<h5>Menu</h5>
	</div>
	<div class="w3-bar-block">
		<a href="#"
			class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
			onclick="w3_close()" title="close menu"><i
			class="fa fa-remove fa-fw"></i>  Fechar Menu</a> 
			
			<form class="w3-container" action="ControllerServlet" method="post">
			<button class="w3-button w3-padding w3-blue w3-bar-item" name="logica" value="EmprestimoPage"><i class="w3-margin-right fa fa-plus"></i>Novo Empréstimo</button>
			
			<button onclick="document.getElementById('impressora').style.display='block'" 
			class="w3-button w3-padding w3-bar-item"><i class="w3-margin-right fa fa-home"></i>Impressora</button>
				
			
			
			<a href="#"	
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-eye fa-fw"></i>  Views</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-users fa-fw"></i>  Traffic</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-bullseye fa-fw"></i>  Geo</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-diamond fa-fw"></i>  Orders</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-bell fa-fw"></i>  News</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-bank fa-fw"></i>  General</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-history fa-fw"></i>  History</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-cog fa-fw"></i>  Settings</a><br> <br>
			</form>
	</div>
</nav>

<c:import url="/WEB-INF/jsps/emprestimo/emprestimo.jsp" />
<c:import url="/WEB-INF/jsps/impressora/controle-impressoras.jsp" />




<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity"
	onclick="w3_close()" style="cursor: pointer" title="close side menu"
	id="myOverlay"></div>


</html>