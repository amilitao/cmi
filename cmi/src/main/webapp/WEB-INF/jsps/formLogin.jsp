<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<c:url value="/controle" var="linkControleServlet" />

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/style/css/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>CMI</title>
</head>

<body class="w3-light-gray">

	<div class="w3-row">

		<div class="w3-display-right w3-padding-large w3-col m4"
			style="height: 100%; background: #d8dddf">

			<div class="container" style="margin-top: 50%">			

				<div class="w3-center">

					<h1 class="w3-xxxlarge" style="color: #293949">
						<i class="fa fa-exchange" style="color: #293949"></i> CMI
					</h1>
				</div>

				<form class="w3-container" action="${linkControleServlet}" method="post">
					<div class="w3-section">
						<label><b>Login</b></label> 
						<input class="w3-input w3-border w3-margin-bottom" type="text"
							name="login" required> <label><b>Senha</b></label>
						<input class="w3-input w3-border" type="password" name="senha" required>

						<input type="hidden" name="logica" value="Login" />

						<button class="w3-button w3-block w3-section w3-padding"
							type="submit" style="background: #78bd5d">
							<b>Entrar</b>
						</button>
					</div>
				</form>
			</div>
		</div>		
	</div>

</body>
</html>