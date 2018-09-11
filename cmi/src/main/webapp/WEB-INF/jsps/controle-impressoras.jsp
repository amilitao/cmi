<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<div id="impressora" class="w3-modal">

	<div class="w3-modal-content">
		<header class="w3-container">
			<span onclick="document.getElementById('impressora').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<h2>
				<i class="fa fa-cubes w3-margin-right"></i>Controle de Impressoras
			</h2>
		</header>

		<div class="w3-container">
			<form action="/ControllerServlet" method="post">

				<div class="w3-row-padding w3-padding-32" style="margin: 0 -16px;">
					<div class="w3-third">
						<input class="w3-input w3-border" type="text"
							placeholder="Número da impressora">
					</div>
					<div class="w3-third">
						<button class="w3-button w3-dark-grey" type="submit">
							<i class="fa fa-search w3-margin-right"></i>Buscar
						</button>
					</div>
				</div>
			</form>
			<br>

			<form action="/ControllerServlet" method="post">

				<div class="w3-row-padding" style="margin: 0 -16px;">
					<div class="w3-third w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Check In</label> <input
							class="w3-input w3-border" type="text" placeholder="One">
					</div>
					<div class="w3-third">
						<label><i class="fa fa-calendar-o"></i> Check In</label> <input
							class="w3-input w3-border" type="text" placeholder="Two">
					</div>
					<div class="w3-third">
						<label><i class="fa fa-calendar-o"></i> Check In</label> <input
							class="w3-input w3-border" type="text" placeholder="Three">
					</div>
				</div>

				<div class="w3-row-padding" style="margin: 0 -16px;">
					<div class="w3-half w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Check In</label> <input
							class="w3-input w3-border" type="text" placeholder="DD MM YYYY"
							name="CheckIn" required>
					</div>
					<div class="w3-half">
						<label><i class="fa fa-calendar-o"></i> Check Out</label> <input
							class="w3-input w3-border" type="text" placeholder="DD MM YYYY"
							name="CheckOut" required>
					</div>

				</div>
				<div class="w3-row-padding" style="margin: 0 -16px;">
					<div class="w3-half w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Check In</label> <input
							class="w3-input w3-border" type="text" placeholder="DD MM YYYY"
							name="CheckIn" required>
					</div>
					<div class="w3-half">
						<label><i class="fa fa-calendar-o"></i> Check Out</label> <input
							class="w3-input w3-border" type="text" placeholder="DD MM YYYY"
							name="CheckOut" required>
					</div>
				</div>
				<div class="w3-row-padding" style="margin: 0 -16px;">
					<div class="w3-half w3-margin-bottom">
						<label><i class="fa fa-calendar-o"></i> Check In</label> <input
							class="w3-input w3-border" type="text" placeholder="DD MM YYYY"
							name="CheckIn" required>
					</div>
					<div class="w3-half">
						<label><i class="fa fa-calendar-o"></i> Check Out</label> <input
							class="w3-input w3-border" type="text" placeholder="DD MM YYYY"
							name="CheckOut" required>
					</div>
				</div>


				<button class="w3-button w3-blue" type="submit">
					<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
				</button>
			</form>
		</div>

		<footer class="w3-container">
			<p></p>
		</footer>
	</div>
</div>

</html>