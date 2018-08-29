<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<div class="w3-row-padding w3-margin-bottom">
	
	<div class="w3-quarter">
		<div class="w3-container w3-teal w3-padding-16">
			<div class="w3-left">
				<i class="fa fa-thumbs-o-up w3-xxxlarge"></i>
			</div>
			<div class="w3-right">
				<h3>${numImpDisponivel}</h3>
			</div>
			<div class="w3-clear"></div>
			<h4>Disponivel</h4>
		</div>
	</div>	
	<div class="w3-quarter">
		<div class="w3-container w3-blue w3-padding-16">
			<div class="w3-left">
				<i class="fa fa-handshake-o w3-xxxlarge"></i>
			</div>
			<div class="w3-right">
				<h3>${numImpEmprestimo}</h3>
			</div>
			<div class="w3-clear"></div>
			<h4>Em empréstimo</h4>
		</div>
	</div>	
	<div class="w3-quarter">
		<div class="w3-container w3-orange w3-text-white w3-padding-16">
			<div class="w3-left">
				<i class="fa fa-wrench w3-xxxlarge"></i>
			</div>
			<div class="w3-right">
				<h3>${numImpManutencao}</h3>
			</div>
			<div class="w3-clear"></div>
			<h4>Manutenção</h4>
		</div>
	</div>
	<div class="w3-quarter">
		<div class="w3-container w3-red w3-padding-16">
			<div class="w3-left">
				<i class="fa fa-times-circle-o w3-xxxlarge"></i>
			</div>
			<div class="w3-right">
				<h3>${numImpDefeito}</h3>
			</div>
			<div class="w3-clear"></div>
			<h4>Com defeito</h4>
		</div>
	</div>
</div>

</html>