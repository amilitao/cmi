<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:mainpage>


<div class="w3-container">
		<h2>
			<i class="fa fa-print"></i> Cadastro de lojas
		</h2>
	</div>

	<div class="w3-panel w3-padding-large">
		
		<c:if test="${confirmaDao}">
			<c:set var="teste" value="disabled" />
			<div class="w3-panel w3-display-container" style="background:#b5e7a0">
				<span onclick="this.parentElement.style.display='none'"
					class="w3-button w3-display-topright w3-large" style="background:#b5e7a0">&times;</span>
				<p>Os dados foram salvos com sucesso!!!</p>
			</div>

		</c:if>	

		<form action="controle" method="post">

			<div class="w3-row-padding" style="margin: 0 -16px;">
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Número da loja</label> <input
						class="w3-input w3-border" type="text" name="num_loja" required>
				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> Nome</label> <input
						class="w3-input w3-border" type="text" name="nome" required>
				</div>
				<div class="w3-third">
					<label><i class="fa fa-pencil-square-o"></i> cnpj</label> <input
						class="w3-input w3-border" type="text" name="cnpj" required>
				</div>
			</div>
			<div class="w3-row-padding w3-margin-top" style="margin: 0 -16px;">
				<div class="w3-third ">
					<label><i class="fa fa-pencil-square-o"></i> telefone</label> <input
						class="w3-input w3-border" type="text" name="telefone" required>
				</div>			
				<div class="w3-third w3-margin-bottom">
					<label><i class="fa fa-pencil-square-o"></i> endereco</label> <input
						class="w3-input w3-border" type="text" name="endereco" required>
				</div>
			</div>		
			
						
			<input type="hidden" name="logica" value="SalvarLoja" />

			<button class="w3-button w3-blue" type="submit"	>
				<i class="fa fa-floppy-o w3-margin-right"></i>Salvar
			</button>
		</form>	
		
  <div class="w3-container" style="margin: 0 -16px;">
		
  <div class="w3-center w3-gray w3-text-white">		
  <h4>Lista de Lojas</h4>
  </div>
  <div style="height: 370px; overflow: auto;">
  <table class="w3-table-all w3-hoverable">
    <thead>
      <tr class="w3-light-grey">
        <th>Numero</th>
        <th>Nome</th>
        <th>Cnpj</th>
        <th>Telefone</th>
        <th>Endereco</th>        
      </tr>
    </thead>
    <c:forEach var="l" items="${lojas}">
    <tr>
      <td><b>${l.numero_loja}</b></td>
      <td>${l.nome}</td>
      <td>${l.cnpj}</td>
      <td>${l.telefone}</td>
      <td>${l.endereco}</td>      
    </tr>   
    </c:forEach>
  </table>
 </div> 
</div>
		
</div>


</t:mainpage>