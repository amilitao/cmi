<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="w3-container">
    <h5>Menu</h5>
  </div>
  <div class="w3-bar-block">
   
  <form action="controle" method="post">
  
  	<button class="w3-bar-item w3-button w3-padding  w3-hover-white"  style="background:#78bd5d" name="logica" value="LoadDashboard"><i class="fa fa-dashboard"></i> Dashboard</button>
  	<button class="w3-bar-item w3-button w3-padding" name="logica" value="EmprestimoPage"><i class="fa fa-handshake-o"></i> Novo empréstimo</button> 
    <button class="w3-bar-item w3-button w3-padding" name="logica" value="ListarEmprestimo"><i class="fa fa-cubes"></i> Meus empréstimos</button>

    <button class="w3-bar-item w3-button w3-padding" name="logica" value="ListarManutencao"><i class="fa fa-wrench"></i> Manutenção</button>
	<button class="w3-bar-item w3-button w3-padding" name="logica" value="ListaDeEsperaPage"><i class="fa fa-edit"></i> Lista de Espera</button>
    <div class="w3-bar-item w3-button w3-padding" onclick="myAccFunc()"><i class="fa fa-plus-square-o"></i> Cadastros</div>
 		 <div id="demoAcc" class="w3-hide w3-white w3-card-4">
   			 <button class="w3-bar-item w3-button w3-padding" name="logica" value="ImpressoraPage"><i class="fa fa-print"></i> Impressora</button>
   			 <button class="w3-bar-item w3-button w3-padding" name="logica" value="LojaPage"><i class="fa fa-home"></i> Loja</button>
   			 <button class="w3-bar-item w3-button w3-padding" name="logica" value="RegionalPage"><i class="fa fa-home"></i> Regional</button>
   			  <button class="w3-bar-item w3-button w3-padding" name="logica" value="AssistenciaPage"><i class="fa fa-home"></i> Assistência</button>
 		 </div>     
    </form>
    <a href="controle?logica=Logout" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out"></i> Sair</a>
   
  </div>
