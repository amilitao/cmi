<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/style/css/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Acesso</title>
</head>

<body class="w3-light-grey">

	<div class="w3-card-4 w3-col m3 w3-white w3-display-middle">
		<div class="w3-center">

			<h1 class="w3-xxxlarge" >
				<i class="fa fa-exchange"></i> CMI
			</h1>

		</div>

		<form class="w3-container" action="controle" method="post">
			<div class="w3-section">
				<label><b>Login</b></label> <input
					class="w3-input w3-border w3-margin-bottom" type="text"	name="login" required> <label><b>Senha</b></label>
				<input class="w3-input w3-border" type="password" name="senha" required>
				<button class="w3-button w3-block w3-section w3-padding" name="logica" value="AutenticarUsuario" style="background:#78bd5d">Entrar</button>
				<input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Lembre-me
			</div>
		</form>


	</div>


</body>
</html>