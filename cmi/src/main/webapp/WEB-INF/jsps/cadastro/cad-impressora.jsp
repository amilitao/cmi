<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:mainpage>

	<div class="w3-panel w3-padding-large">
		<h3>
			<i class="fa fa-print"></i> Cadastro de impressora
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
				<div class="w3-col m3">
					<label><i class="fa fa-pencil-square-o"></i> Número da
						impressora</label> <input class="w3-input w3-border" type="text"
						name="num_impressora" id="inp_numero" disabled required>
				</div>
				<div class="w3-col m3">
					<label><i class="fa fa-pencil-square-o"></i> Modelo</label> <input
						class="w3-input w3-border" type="text" name="modelo"
						id="inp_modelo" disabled required>
				</div>
				<div class="w3-col m3">
					<label><i class="fa fa-pencil-square-o"></i> Pip</label> <input
						class="w3-input w3-border" type="text" name="pip" id="inp_pip"
						disabled required>
				</div>
				<div class="w3-col m3">
					<label><i class="fa fa-pencil-square-o"></i> Número de
						serie</label> <input class="w3-input w3-border" type="text"
						name="num_serie" id="inp_serie" disabled required>
				</div>
			</div>
			<div class="w3-row-padding w3-margin-top" style="margin: 0 -16px;">
			
				<div class="w3-col m3">
					<label><i class="fa fa-pencil-square-o"></i> Valor
					</label> <input class="w3-input w3-border" type="text"
						name="valor" id="inp_valor" disabled required>
				</div>			
				<div class="w3-col m3">
					<label><i class="fa fa-home"></i> Estado</label> <select
						class="w3-select w3-border" name="estado" id="inp_estado" disabled
						required>
						<option value="" disabled selected>Escolha o estado</option>
						<c:forEach var="estado" items="${lista_estado}">
							<option value="${estado}" id="${estado.descricao}">${estado.descricao}</option>
						</c:forEach>
					</select>
				</div>
				<div class="w3-col m3 w3-margin-bottom">
					<label><i class="fa fa-home"></i> Situacao</label> <select
						class="w3-select w3-border" name="situacao" id="inp_situacao"
						disabled required>
						<option value="" disabled selected>Escolha a situacao</option>
						<c:forEach var="situacao" items="${lista_situacao}">
							<option value="${situacao}" id="${situacao.descricao}">${situacao.descricao}</option>
						</c:forEach>
					</select>

				</div>
				<div class="w3-col m3 w3-margin-bottom">
					<label><i class="fa fa-home"></i> Loja responsavel</label> <select
						class="w3-select w3-border" name="id_loja" id="inp_loja" disabled
						required>
						<option value="" disabled selected>Escolha a loja</option>
						<c:forEach var="loja" items="${lojas}">
							<option value="${loja.idLoja}" id="${loja}">${loja}</option>
						</c:forEach>
					</select>

				</div>
			</div>
				<hr>
			
			<input type="hidden" name="id_impressora" id="inp_id" value="0" /> <input
				type="hidden" name="logica" value="SalvarImpressora" />


			<button class="w3-button w3-green" type="button"
				onclick="f_adicionar()">Nova impressora</button>
			<button class="w3-button w3-deep-orange" type="button"
				onclick="f_alterar()">Alterar</button>
			<button class="w3-button w3-blue" type="submit">
				<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
			</button>
		</form>	

		<div class="w3-container" style="margin: 0 -16px;">

			<div class="w3-center w3-white">
				<h4><b>Lista de impressoras</b></h4>
			</div>
			<div style="height: 370px; overflow: auto;">
				<table class="w3-table-all w3-hoverable">
					<thead>
						<tr class="w3-dark-grey">
							<th>Numero</th>
							<th>Modelo</th>
							<th>Pip</th>
							<th>Nº Serie</th>
							<th>Valor</th>
							<th>Estado</th>
							<th>Situacao</th>
							<th>Loja responsavel</th>
						</tr>
					</thead>
					<c:forEach var="i" items="${impressoras}">
						<tr
							onclick="f_selecionar('${i.id_impressora}', '${i.numero}', '${i.modelo}', '${i.pip}', '${i.numero_serie}', 
							'<fmt:formatNumber type="number" maxFractionDigits = "2" value="${i.valor}" />',
							'${i.estado.descricao}','${i.situacao.descricao}', '${i.loja}')">
							
							<td><b>${i.numero}</b></td>
							<td>${i.modelo}</td>
							<td>${i.pip}</td>
							<td>${i.numero_serie}</td>
							<td><fmt:formatNumber type="number" maxFractionDigits = "2" value="${i.valor}" /></td>
							<td>${i.estado.descricao}</td>
							<td class="w3-text-${i.situacao.cor}"><b>${i.situacao.descricao}</b></td>
							<td>${i.loja}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>


	<script>
		function f_selecionar(id, nu, m, p, s, v, e, si, l) {

			desabilitar_campos(true);
			alterar_campos(id, nu, m, p, s, v, e, si, l);

		}

		function f_adicionar() {

			desabilitar_campos(false);
			alterar_campos('0', '', '', '', '', '', '', '', '');

		}

		function f_alterar() {
			var id_impressora = document.getElementById("inp_id").value;

			if (id_impressora != '0') {

				desabilitar_campos(false);

			} else {
				alert("Nenhum registro foi selecionado!");
			}
		}

		function desabilitar_campos(opcao) {

			document.getElementById("inp_numero").disabled = opcao;
			document.getElementById("inp_modelo").disabled = opcao;
			document.getElementById("inp_pip").disabled = opcao;
			document.getElementById("inp_serie").disabled = opcao;
			document.getElementById("inp_valor").disabled = opcao;
			document.getElementById("inp_estado").disabled = opcao;
			document.getElementById("inp_situacao").disabled = opcao;
			document.getElementById("inp_loja").disabled = opcao;

		}

		function alterar_campos(id, nu, m, p, s, v, e, si, l) {

			document.getElementById("inp_id").value = id;
			document.getElementById("inp_numero").value = nu;
			document.getElementById("inp_modelo").value = m;
			document.getElementById("inp_pip").value = p;
			document.getElementById("inp_serie").value = s;
			document.getElementById("inp_valor").value = v;			
			document.getElementById(e).selected = true;
			document.getElementById(si).selected = true;
			document.getElementById(l).selected = true;
		}
	</script>

</t:mainpage>