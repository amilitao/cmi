<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
	isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/style/css/w3.css">
<link href="https://fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">

<style>
.w3-poiret {
	font-family: 'Poiret One', cursive;
}
</style>

<title>Erro</title>
</head>
<body>

	<div class="w3-container w3-display-middle w3-center ">
		<div class="w3-container w3-center">
			<h1 class="w3-poiret">500</h1>

			<img src="resources/style/images/skull.png" class="w3-opacity"
				width="100" />
			<h3 class="w3-poiret">Internal Server Error!!!</h3>

			<div class="w3-container" style="margin: 0 -16px;">

				<div class="w3-center w3-white">
					<h4>
						<b>${pageContext.exception}</b>
					</h4>
				</div>
				<div style="height: 350px; overflow: auto;">

					<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
						<p>${trace}</p>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

</body>
</html>