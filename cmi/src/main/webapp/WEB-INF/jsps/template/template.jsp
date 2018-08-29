<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<title>CMI</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/style/css/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>


<body class="w3-light-grey">
	

	<!-- Top container -->
	<c:import url="top-container.jsp" />
	

	<!-- Sidebar/menu -->
	<c:import url="side-bar.jsp" />

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">

		<!-- Header -->		
		<c:import url="header.jsp" />

		<!--  Painel / Status impressora -->
		<c:import url="painel.jsp" />

		<div class="w3-panel">
			<div class="w3-row-padding" style="margin: 0 -16px">

				<!-- Regions -->
				<c:import url="regions.jsp" /> 

				<!-- Feeds / Emprestimos -->
				<c:import url="feeds.jsp" />

			</div>
		</div>
		<hr>
		<!-- General Stats -->
		<c:import url="general-stats.jsp" />

		<hr>
		<!-- Countries / Lista de espera-->
		<c:import url="countries.jsp" />

		<hr>
		<!-- Recent Users -->
		<c:import url="recent-users.jsp" />

		<hr>
		<!-- Recent Comments / Registros recentes-->
		<c:import url="recent-comments.jsp" />

		<br>

		<!-- Mapa Site -->
		<c:import url="mapa-site.jsp" />

		<!-- Footer -->
		<c:import url="footer.jsp" />


		<!-- End page content -->
	</div>
	
	<script>
		// Get the Sidebar
		var mySidebar = document.getElementById("mySidebar");

		// Get the DIV with overlay effect
		var overlayBg = document.getElementById("myOverlay");

		// Toggle between showing and hiding the sidebar, and add overlay effect
		function w3_open() {
			if (mySidebar.style.display === 'block') {
				mySidebar.style.display = 'none';
				overlayBg.style.display = "none";
			} else {
				mySidebar.style.display = 'block';
				overlayBg.style.display = "block";
			}
		}

		// Close the sidebar with the close button
		function w3_close() {
			mySidebar.style.display = "none";
			overlayBg.style.display = "none";
		}
	</script>

</body>
</html>