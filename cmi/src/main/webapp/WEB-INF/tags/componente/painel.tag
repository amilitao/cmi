<%@tag description="Painel de status" pageEncoding="UTF-8"%>
<%@attribute name="qtdDisponivel" required="true" %>
<%@attribute name="qtdEmprestimo" required="true" %>
<%@attribute name="qtdManutencao" required="true" %>
<%@attribute name="qtdDefeito" required="true" %>


<div class="w3-row-padding w3-margin-bottom">
	
	<div class="w3-quarter">
		<div class="w3-container w3-padding-16" style="background:#96ceb4">
			<div class="w3-left">
				<i class="fa fa-thumbs-o-up w3-xxxlarge"></i>
			</div>
			<div class="w3-right">
				<h3>${qtdDisponivel}</h3>
			</div>
			<div class="w3-clear"></div>
			<h4>Disponivel</h4>
		</div>
	</div>	
	<div class="w3-quarter">
		<div class="w3-container w3-padding-16" style="background:#ffcc5c">
			<div class="w3-left">
				<i class="fa fa-handshake-o w3-xxxlarge"></i>
			</div>
			<div class="w3-right">
				<h3>${qtdEmprestimo}</h3>
			</div>
			<div class="w3-clear"></div>
			<h4>Em empréstimo</h4>
		</div>
	</div>	
	<div class="w3-quarter">
		<div class="w3-container w3-padding-16" style="background:#ffeead">
			<div class="w3-left">
				<i class="fa fa-wrench w3-xxxlarge"></i>
			</div>
			<div class="w3-right">
				<h3>${qtdManutencao}</h3>
			</div>
			<div class="w3-clear"></div>
			<h4>Manutenção</h4>
		</div>
	</div>
	<div class="w3-quarter">
		<div class="w3-container w3-padding-16" style="background:#ff6f69">
			<div class="w3-left">
				<i class="fa fa-times-circle-o w3-xxxlarge"></i>
			</div>
			<div class="w3-right">
				<h3>${qtdDefeito}</h3>
			</div>
			<div class="w3-clear"></div>
			<h4>Com defeito</h4>
		</div>
	</div>
</div>