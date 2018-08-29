<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<div id="emprestimo" class="w3-modal">

	<div class="w3-modal-content">
		<header class="w3-container">
			<span
				onclick="document.getElementById('emprestimo').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<h2>
				<i class="fa fa-handshake-o w3-margin-right"></i>Novo empréstimo
			</h2>
		</header>

		<div class="w3-container">
			
			<div class="w3-panel w3-padding-large">
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
		</div>

		<footer class="w3-container">
			<p></p>
		</footer>
	</div>
</div>

</html>