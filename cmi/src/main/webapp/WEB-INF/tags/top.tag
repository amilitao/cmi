<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="w3-bar w3-top w3-large w3-text-white"
	style="background: #293949" style="z-index: 4">
	<div class="w3-bar w3-theme-d2 w3-left-align w3-large">

		<button
			class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey"
			onclick="w3_open();">
			<i class="fa fa-bars"></i>  Menu
		</button>

		<span class="w3-bar-item w3-margin-left w3-margin-right w3-theme-d4"><i
			class="fa fa-exchange"></i><b> CMI</b></span> <a href="#"
			class="w3-bar-item w3-button "><i class="fa fa-user"></i></a> <a
			href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
		<button
			onclick="document.getElementById('id01').style.display='block'"
			class="w3-button w3-bar-item">
			<i class="fa fa-bell"></i><span
				class="w3-badge w3-right w3-small w3-green">3</span>
		</button>

		<div id="id01" class="w3-modal">
			<div class="w3-modal-content w3-card-4">
				<header class="w3-container w3-khaki">
					<span
						onclick="document.getElementById('id01').style.display='none'"
						class="w3-button w3-large w3-display-topright">&times;</span>
					<h2>Notificações</h2>
				</header>
				<div class="w3-container w3-text-black">
					<p>Some text..</p>
					<p>Some text..</p>
				</div>
				<footer class="w3-container w3-khaki">
					<p>Modal Footer</p>
				</footer>
			</div>
		</div>
	</div>

</div>
