<%@tag description="Painel de Ultimas Atualizaçoes" pageEncoding="UTF-8"%>
<%@attribute name="ultima_id_emprestimo" %>
<%@attribute name="ultima_usuario" required="true" %>
<%@attribute name="ultima_ocorrencia" required="true" %>
<%@attribute name="ultima_data" required="true" %>
<%@attribute name="penultima_id_emprestimo" required="true" %>
<%@attribute name="penultima_usuario" required="true" %>
<%@attribute name="penultima_ocorrencia" required="true" %>
<%@attribute name="penultima_data" required="true" %>


<div class="w3-container w3-white">
		<h5>Ultimas atualizações</h5>
		<div class="w3-row">
			<div class="w3-col m2 text-center">
				<img class="w3-circle" src="resources/style/images/avatar2.png"
					style="width: 106px; height: 106px">
			</div>
			<div class="w3-col m10 w3-container">
				<h4>
					${ultima_usuario}<span class="w3-opacity w3-medium"> ${ultima_data}</span>
				</h4>
				<p><b>Empréstimo nº </b>${ultima_id_emprestimo}</p>
				<p><i class="fa fa-comments-o" style="font-size:24px"></i> <b>Comentário:</b> ${ultima_ocorrencia}</p>				
				<br>
			</div>
		</div>
		<hr>
		<div class="w3-row">
			<div class="w3-col m2 text-center">
				<img class="w3-circle" src="resources/style/images/user_ava.png"
					style="width: 106px; height: 106px">
			</div>
			<div class="w3-col m10 w3-container">
				<h4>
					${penultima_usuario} <span class="w3-opacity w3-medium"> ${penultima_data}</span>
				</h4>
				<p><b>Empréstimo nº </b>${penultima_id_emprestimo}</p>
				<p><i class="fa fa-comments-o" style="font-size:24px"></i> <b>Comentário:</b> ${penultima_ocorrencia}</p>
				<br>				
			</div>
		</div>
	</div>
