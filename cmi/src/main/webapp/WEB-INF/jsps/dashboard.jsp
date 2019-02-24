<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="com" tagdir="/WEB-INF/tags/componente"%>


<t:mainpage>

	<!-- Header -->
	<header class="w3-container">
		<h5>
			<b><i class="fa fa-dashboard"></i> Meu Dashboard</b>
		</h5>
	</header>

	<com:painel-status qtdDisponivel="${painelStatus.qtdDisponivel}"
		qtdEmprestimo="${painelStatus.qtdEmprestimo}"
		qtdManutencao="${painelStatus.qtdManutencao}"
		qtdDefeito="${painelStatus.qtdDefeito}" />
	
	
	<div class="w3-container">
		<h5>Status de atendimento</h5>
		<p>Empréstimos</p>
		<div class="w3-grey">
			<div class="w3-container w3-center w3-padding w3-green"
				style="width: 25%">+25%</div>
		</div>

		<p>Manutenção</p>
		<div class="w3-grey">
			<div class="w3-container w3-center w3-padding w3-orange"
				style="width: 50%">50%</div>
		</div>

		<p>Lista de espera</p>
		<div class="w3-grey">
			<div class="w3-container w3-center w3-padding w3-red"
				style="width: 75%">75%</div>
		</div>
	</div>
	<hr>	
	

	<div class="w3-container">
		<h5>Comentários recentes</h5>
		<div class="w3-row">
			<div class="w3-col m2 text-center">
				<img class="w3-circle" src="resources/style/images/user_system.png"
					style="width: 96px; height: 96px">
			</div>
			<div class="w3-col m10 w3-container">
				<h4>
					John <span class="w3-opacity w3-medium">Sep 29, 2014, 9:12
						PM</span>
				</h4>
				<p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum
					dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
					incididunt ut labore et dolore magna aliqua.</p>
				<br>
			</div>
		</div>

		<div class="w3-row">
			<div class="w3-col m2 text-center">
				<img class="w3-circle" src="resources/style/images/avatar2.png"
					style="width: 96px; height: 96px">
			</div>
			<div class="w3-col m10 w3-container">
				<h4>
					Bo <span class="w3-opacity w3-medium">Sep 28, 2014, 10:15 PM</span>
				</h4>
				<p>Sed do eiusmod tempor incididunt ut labore et dolore magna
					aliqua.</p>
				<br>
			</div>
		</div>
	</div>
	<br>
	<div class="w3-container w3-dark-grey w3-padding-32">
		<div class="w3-row">
			<div class="w3-container w3-third">
				<h5 class="w3-bottombar w3-border-green">Empréstimo</h5>
				<p>Envio</p>
				<p>Country</p>
				<p>City</p>
			</div>
			<div class="w3-container w3-third">
				<h5 class="w3-bottombar w3-border-red">Manutenção</h5>
				<p>Browser</p>
				<p>OS</p>
				<p>More</p>
			</div>
			<div class="w3-container w3-third">
				<h5 class="w3-bottombar w3-border-orange">Relatorios</h5>
				<p>Users</p>
				<p>Active</p>
				<p>Geo</p>
				<p>Interests</p>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="w3-container w3-padding-16 w3-light-grey">	
		<p>
			Powered by <a href="https://www.w3schools.com/w3css/default.asp"
				target="_blank">w3.css</a>
		</p>
	</footer>

	<!-- End page content -->


</t:mainpage>