<%@ tag import="br.com.militao.cmi.modelo.dao.NotificacaoDao"%>
<%@ tag import="br.com.militao.cmi.modelo.Notificacao"%>
<%@ tag import="java.util.*;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<div id="id01" class="w3-modal w3-text-black">
			<div class="w3-modal-content">

				<header class="w3-container w3-khaki">
					<span
						onclick="document.getElementById('id01').style.display='none'"
						class="w3-button w3-display-topright">Fechar</span>
					<h3>Notificações</h3>
				</header>
				<div class="w3-container">
					<ul class="w3-ul">
						<c:forEach var="n" items="${sessionScope.notificacoes}">
							<li class="w3-bar">
								<div class="w3-bar-item">
									<span class="w3-large"> <i class="fa fa-bell-o"
										style="font-size: 25px"></i> ${n.descricao} 
									</span>
									<button class="w3-button w3-circle w3-green"
										onclick="this.parentElement.style.display='none'">
										<i class="fa fa-check" style="font-size: 15px"></i>
									</button>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>

	</div>

</div>
