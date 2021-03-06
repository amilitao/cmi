<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:mainpage>


	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-home"></i> Cadastro de lojas
		</h3>
	</div>

	<div class="w3-panel w3-padding-large">

		<c:if test="${confirmaDao}">
			<c:set var="teste" value="disabled" />
			<div class="w3-panel w3-display-container"
				style="background: #b5e7a0">
				<span onclick="this.parentElement.style.display='none'"
					class="w3-button w3-display-topright w3-large"
					style="background: #b5e7a0">&times;</span>
				<p>Os dados foram salvos com sucesso!!!</p>
			</div>

		</c:if>

		<form action="controle" method="post">

			<div class="w3-row-padding" style="margin: 0 -16px;">
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Número da loja</label>
					<input class="w3-input w3-border" type="number"  pattern="[0-9]+$" 
					title="O campo deve conter somente numeros" name="num_loja" id="inp_numero" disabled required>
				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Nome</label> <input
						class="w3-input w3-border" type="text" pattern="[a-zA-Z\s]+$"
						 title="O campo deve conter somente letras" name="nome" id="inp_nome" disabled required>
				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> cnpj</label> <input
						class="w3-input w3-border" type="text" name="cnpj" id="inp_cnpj" disabled required>
				</div>
			</div>
			<div class="w3-row-padding w3-margin-top" style="margin: 0 -16px;">
				<div class="w3-third ">
					<label><i class="fa fa-pencil-square-o"></i> telefone</label> <input
						pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" class="w3-input w3-border" type="tel" 
						name="telefone" placeholder="(XX) XXXX-XXXX" id="inp_telefone" disabled required>
				</div>
				<div class="w3-third w3-margin-bottom">
					<label><i class="fa fa-pencil-square-o"></i> endereco</label> <input
						class="w3-input w3-border" type="text" name="endereco"
						id="inp_endereco" disabled required>
				</div>
				<div class="w3-third w3-margin-bottom">
					<label><i class="fa fa-home"></i> Regional</label> <select
						class="w3-select w3-border" name="id_regional" id="inp_regional"
						disabled required>
						<option value="" disabled selected>Escolha a regional</option>
						<c:forEach var="regional" items="${regionais}">
							<option value="${regional.id_regional}"
								id="${regional.nome_regional}">${regional.nome_regional}</option>
						</c:forEach>
					</select>
				</div>

			</div>

				<hr>

			<input type="hidden" name="id_loja" id="inp_id" />
			<input type="hidden" name="logica" value="SalvarLoja" />

			<button class="w3-button w3-green" type="button"
				onclick="f_adicionar()">Nova loja</button>
			<button class="w3-button w3-deep-orange" type="button"
				onclick="f_alterar()">Alterar</button>
			<button class="w3-button w3-blue" type="submit">
				<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
			</button>

		</form>	

		<div class="w3-container" style="margin: 0 -16px;">

			<div class="w3-center w3-white">
				<h4><b>Lista de Lojas</b></h4>
			</div>
			<div style="height: 300px; overflow: auto;">
				<table class="w3-table-all w3-hoverable">
					<thead>
						<tr class="w3-dark-grey">
							<th>Número</th>
							<th>Nome</th>
							<th>Cnpj</th>
							<th>Telefone</th>
							<th>Endereço</th>
							<th>Regional
							<th>
						</tr>
					</thead>
					<c:forEach var="l" items="${lojas}">
						<tr
							onclick="f_selecionar(${l.id_loja}, ${l.numero_loja}, '${l.nome}', '${l.cnpj}', '${l.telefone}', '${l.endereco}', '${l.regional.nome_regional}')">
							<td><b>${l.numero_loja}</b></td>
							<td>${l.nome}</td>
							<td>${l.cnpj}</td>
							<td>${l.telefone}</td>
							<td>${l.endereco}</td>
							<td>${l.regional.nome_regional}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>


	<script>
function f_selecionar(id, nu, no, c, t, e, r) {
	
	desabilitar_campos(true);
	alterar_campos(id,nu,no,c,t,e,r);
	 
}

function f_adicionar(){
	
	desabilitar_campos(false);
	alterar_campos('','','','','','','');
	
	
}

function f_alterar(){
	var id_loja = document.getElementById("inp_id").value;
	
	if(id_loja != ''){
		
		desabilitar_campos(false);
		
	}else{
		alert("Nenhum registro foi selecionado!");
	}	
}

function desabilitar_campos(opcao){
	
	document.getElementById("inp_numero").disabled = opcao;
	document.getElementById("inp_nome").disabled = opcao;
	document.getElementById("inp_cnpj").disabled = opcao;
	document.getElementById("inp_telefone").disabled = opcao;
	document.getElementById("inp_endereco").disabled = opcao;
	document.getElementById("inp_regional").disabled = opcao;	
	
	
}

function alterar_campos(id, nu, no, c, t, e, r){
	
	document.getElementById("inp_id").value = id; 	
	document.getElementById("inp_numero").value = nu; 	
	document.getElementById("inp_nome").value = no; 	
	document.getElementById("inp_cnpj").value = c;  	
	document.getElementById("inp_telefone").value = t; 
	document.getElementById("inp_endereco").value = e; 
	document.getElementById(r).selected = true; 
}
</script>


</t:mainpage>