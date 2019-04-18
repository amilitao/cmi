<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:mainpage>


	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-home"></i> Cadastro de Assistência
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
					<label><i class="fa fa-pencil-square-o"></i> Razao Social</label>
					<input class="w3-input w3-border" type="text" name="razao_social" id="inp_razao" disabled required>
				</div>				
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> cnpj</label> <input
						class="w3-input w3-border" type="text" name="cnpj" id="inp_cnpj" disabled required>
				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Email</label> <input
						class="w3-input w3-border" type="text" name="email" id="inp_email" disabled required>
				</div>
			</div>
			<div class="w3-row-padding w3-margin-top" style="margin: 0 -16px;">
				<div class="w3-third ">
					<label><i class="fa fa-pencil-square-o"></i> telefone</label> <input
						pattern="^(\d{2})\d{4}-\d{4}$" class="w3-input w3-border" type="text" 
						name="telefone" placeholder="(XX) XXXX-XXXX" id="inp_telefone" disabled required>
				</div>
				<div class="w3-third w3-margin-bottom">
					<label><i class="fa fa-pencil-square-o"></i> endereco</label> <input
						class="w3-input w3-border" type="text" name="endereco"
						id="inp_endereco" disabled required>
				</div>
				
			</div>

				<hr>

			<input type="hidden" name="id_assistencia" id="inp_id" />
			<input type="hidden" name="logica" value="SalvarAssistencia" />

			<button class="w3-button w3-green" type="button"
				onclick="f_adicionar()">Nova Assistência</button>
			<button class="w3-button w3-deep-orange" type="button"
				onclick="f_alterar()">Alterar</button>
			<button class="w3-button w3-blue" type="submit">
				<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
			</button>

		</form>	

		<div class="w3-container" style="margin: 0 -16px;">

			<div class="w3-center w3-white">
				<h4><b>Lista de Assistências</b></h4>
			</div>
			<div style="height: 370px; overflow: auto;">
				<table class="w3-table-all w3-hoverable">
					<thead>
						<tr class="w3-dark-grey">							
							<th>Razão Social</th>
							<th>Cnpj</th>
							<th>Email</th>
							<th>Telefone</th>
							<th>Endereço</th>							
						</tr>
					</thead>
					<c:forEach var="ass" items="${assistencias}">
						<tr
							onclick="f_selecionar('${ass.id_assistencia}', '${ass.razao_social}', '${ass.cnpj}', '${ass.email}','${ass.telefone}', '${ass.endereco}')">
							<td><b>${ass.razao_social}</b></td>
							<td>${ass.cnpj}</td>
							<td>${ass.email}</td>
							<td>${ass.telefone}</td>
							<td>${ass.endereco}</td>							
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>


	<script>
function f_selecionar(id, rz, cn, em, tel, end) {
	
	desabilitar_campos(true);
	alterar_campos(id,rz,cn,em,tel,end);
	 
}

function f_adicionar(){
	
	desabilitar_campos(false);
	alterar_campos('','','','','','');
	
	
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
	
	document.getElementById("inp_razao").disabled = opcao;
	document.getElementById("inp_cnpj").disabled = opcao;
	document.getElementById("inp_email").disabled = opcao;
	document.getElementById("inp_telefone").disabled = opcao;
	document.getElementById("inp_endereco").disabled = opcao;
		
	
}

function alterar_campos(id,rz,cn,em,tel,end){
	
	document.getElementById("inp_id").value = id; 	
	document.getElementById("inp_razao").value = rz; 	
	document.getElementById("inp_cnpj").value = cn; 	
	document.getElementById("inp_email").value = em;  	
	document.getElementById("inp_telefone").value = tel; 	
	document.getElementById("inp_endereco").value = end; 	
	
}
</script>


</t:mainpage>