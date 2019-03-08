<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/style/css/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Acesso</title>
</head>

<body class="w3-light-grey">


	<div
		class="w3-card-4 w3-col m3 w3-display-middle w3-white w3-padding-large">

		<c:if test="${erroLogin}">
			<div class="w3-panel w3-center  w3-pale-yellow"
				style="background: #b5e7a0">
				<p><i class="fa fa-exclamation-triangle"></i> Login ou senha incorretos!!!</p>
			</div>

		</c:if>

		<div class="w3-center">

			<h1 class="w3-xxxlarge">
				<i class="fa fa-exchange"></i> CMI
			</h1>

		</div>

		<form class="w3-container" action="acesso" method="post">
			<div class="w3-section">
				<label><b>Login</b></label> <input
					class="w3-input w3-border w3-margin-bottom" type="text"
					name="login" required> <label><b>Senha</b></label> <input
					class="w3-input w3-border" type="password" name="senha" required>
					
				<input type="hidden" name="logica" value="AutenticarUsuario" />
					
				<button class="w3-button w3-block w3-section w3-padding" type="submit"
					style="background: #78bd5d">Entrar</button>
			</div>
		</form>
		<hr>

	</div>


</body>
</html>