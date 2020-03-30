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

<style type="text/css">
.img1 {
	padding: 10px;
	width: 100px;
	-moz-transform: rotate(20deg);
	-ms-transform: rotate(20deg); /* IE 9 */
	-webkit-transform: rotate(20deg); /* Chrome, Safari, Opera */
	transform: rotate(20deg);
}

.img2 {
	padding: 10px;
	width: 100px;
	-moz-transform: rotate(-20deg);
	-ms-transform: rotate(-20deg); /* IE 9 */
	-webkit-transform: rotate(-20deg); /* Chrome, Safari, Opera */
	transform: rotate(-20deg);
}

.img-p1 {
	padding: 10px;
	width: 70px;
	-moz-transform: rotate(20deg);
	-ms-transform: rotate(20deg); /* IE 9 */
	-webkit-transform: rotate(20deg); /* Chrome, Safari, Opera */
	transform: rotate(20deg);
}

.img-p2 {
	padding: 10px;
	width: 70px;
	-moz-transform: rotate(-20deg);
	-ms-transform: rotate(-20deg); /* IE 9 */
	-webkit-transform: rotate(-20deg); /* Chrome, Safari, Opera */
	transform: rotate(-20deg);
}
</style>


</head>


<body class="w3-light-gray">


	<div class="w3-row">

		<div class="w3-display-right w3-padding-large w3-col m3"
			style="height: 100%; background: #d8dddf">

			<div class="container" style="margin-top: 50%">			

				<div class="w3-center">

					<h1 class="w3-xxxlarge" style="color: #293949">
						<i class="fa fa-exchange" style="color: #293949"></i> CMI
					</h1>
				</div>

				<form class="w3-container" action="${linkControleServlet}" method="post">
					<div class="w3-section">
						<label><b>Login</b></label> <input
							class="w3-input w3-border w3-margin-bottom" type="text"
							name="login" required> <label><b>Senha</b></label> <input
							class="w3-input w3-border" type="password" name="senha" required>

						<input type="hidden" name="logica" value="Login" />

						<button class="w3-button w3-block w3-section w3-padding"
							type="submit" style="background: #78bd5d">
							<b>Entrar</b>
						</button>
					</div>
				</form>
			</div>
		</div>

		<div class="w3-col m9 w3-opacity-max">
			<span style="position: absolute; top: 40px; left: 60px"> <img
				src="resources/style/images/icons-index/icon1.png" class="img1">
			</span> <span style="position: absolute; top: 150px; left: 300px"> <img
				src="resources/style/images/icons-index/icon8.png" class="img-p1">
			</span> <span style="position: absolute; top: 40px; left: 500px"> <img
				src="resources/style/images/icons-index/icon2.png" class="img2">
			</span> <span style="position: absolute; top: 150px; left: 750px"> <img
				src="resources/style/images/icons-index/icon5.png" class="img-p2">
			</span> <span style="position: absolute; top: 40px; left: 900px"> <img
				src="resources/style/images/icons-index/icon3.png" class="img1">



			</span> <span style="position: absolute; top: 300px; left: 200px"> <img
				src="resources/style/images/icons-index/icon4.png" class="img2">
			</span> <span style="position: absolute; top: 300px; left: 600px"> <img
				src="resources/style/images/icons-index/icon1.png" class="img1">
			</span> <span style="position: absolute; top: 300px; left: 1000px"> <img
				src="resources/style/images/icons-index/icon2.png" class="img-p1">
			</span> <span style="position: absolute; top: 500px; left: 40px"> <img
				src="resources/style/images/icons-index/icon4.png" class="img2">
			</span> <span style="position: absolute; top: 480px; left: 250px"> <img
				src="resources/style/images/icons-index/icon5.png" class="img-p2">
			</span> <span style="position: absolute; top: 500px; left: 400px"> <img
				src="resources/style/images/icons-index/icon7.png" class="img1">
			</span> <span style="position: absolute; top: 450px; left: 600px"> <img
				src="resources/style/images/icons-index/icon1.png" class="img-p1">
			</span> <span style="position: absolute; top: 500px; left: 900px"> <img
				src="resources/style/images/icons-index/icon8.png" class="img2">
			</span>
		</div>
	</div>

</body>
</html>