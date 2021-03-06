<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:mainpage>


	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-home"></i> Cadastro de regionais
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

			<div class="w3-row-padding w3-margin-top" style="margin: 0 -16px;">
				<div class="w3-col m3 w3-margin-bottom">
					<label><i class="fa fa-pencil-square-o"></i> Nome da
						regional</label> <input class="w3-input w3-border" type="text"
						name="nome_regional" id="inp_nome" disabled required>
				</div>
				<div class="w3-col m3 w3-margin-bottom">
					<label><i class="fa fa-pencil-square-o"></i> Número da
						filial base</label> <input class="w3-input w3-border" type="text"
						name="num_filial_base" id="inp_num_filial_base" disabled required>
				</div>
				<div class="w3-col m3 w3-margin-bottom">
					<label><i class="fa fa-pencil-square-o"></i> Quantidade de
						impressora</label> <input class="w3-input w3-border" type="text"
						name="qtd_impressora" id="inp_qtd_impressora" disabled required>
				</div>
			</div>

			<hr>

			<input type="hidden" name="id_regional" id="inp_id" /> <input
				type="hidden" name="logica" value="SalvarRegional" />

			<button class="w3-button w3-green" type="button"
				onclick="f_adicionar()">Nova regional</button>
			<button class="w3-button w3-deep-orange" type="button"
				onclick="f_alterar()">Alterar</button>
			<button class="w3-button w3-blue" type="submit">
				<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
			</button>

		</form>

		<div class="w3-container" style="margin: 0 -16px;">

			<div class="w3-center w3-white">
				<h4><b>Lista de Regionais</b></h4>
			</div>
			<div style="height: 300px; overflow: auto;">
				<table class="w3-table-all w3-hoverable">
					<thead>
						<tr class="w3-dark-grey">
							<th>Nome</th>
							<th>Numero da filial base</th>
							<th>Quantidade de impressora</th>
						</tr>
					</thead>
					<c:forEach var="r" items="${regionais}">
						<tr
							onclick="f_selecionar('${r.id_regional}','${r.nome_regional}', '${r.num_filial_base}', '${r.qtd_impressora}')">
							<td>${r.nome_regional}</td>
							<td>${r.num_filial_base}</td>
							<td>${r.qtd_impressora}</td> 
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>


	<script>
		function f_selecionar(id, no, nu, qtd) {

			desabilitar_campos(true);
			alterar_campos(id, no, nu, qtd);

		}

		function f_adicionar() {

			desabilitar_campos(false);
			alterar_campos('', '', '', '');

		}

		function f_alterar() {
			var id_regional = document.getElementById("inp_id").value;

			if (id_regional != '') {

				desabilitar_campos(false);

			} else {
				alert("Nenhum registro foi selecionado!");
			}
		}

		function desabilitar_campos(opcao) {

			document.getElementById("inp_nome").disabled = opcao;
			document.getElementById("inp_num_filial_base").disabled = opcao;
			document.getElementById("inp_qtd_impressora").disabled = opcao;

		}

		function alterar_campos(id, no, nu, qtd) {

			document.getElementById("inp_id").value = id;
			document.getElementById("inp_nome").value = no;
			document.getElementById("inp_num_filial_base").value = nu;
			document.getElementById("inp_qtd_impressora").value = qtd;

		}
	</script>


</t:mainpage>