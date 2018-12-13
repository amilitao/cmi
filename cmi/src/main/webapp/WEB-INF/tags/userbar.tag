<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="w3-container w3-row">
	<div class="w3-col s4">
		<img src="resources/style/images/avatar2.png"
			class="w3-circle w3-margin-right" style="width: 46px">
	</div>
	<div class="w3-col s8 w3-bar">
		<span>Bem-vindo, <strong>Producao</strong></span> <br> <a
			href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
		<a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>

		<button
			onclick="document.getElementById('id01').style.display='block'"
			class="w3-button w3-bar-item">
			<i class="fa fa-envelope"></i><span
				class="w3-badge w3-right w3-small w3-green">3</span>
		</button>

		<div id="id01" class="w3-modal">
			<div class="w3-modal-content w3-card-4">
				<header class="w3-container w3-teal">
					<span
						onclick="document.getElementById('id01').style.display='none'"
						class="w3-button w3-large w3-display-topright">&times;</span>
					<h2>Modal Header</h2>
				</header>
				<div class="w3-container">
					<p>Some text..</p>
					<p>Some text..</p>
				</div>
				<footer class="w3-container w3-teal">
					<p>Modal Footer</p>
				</footer>
			</div>
		</div>


	</div>
</div>
<hr>