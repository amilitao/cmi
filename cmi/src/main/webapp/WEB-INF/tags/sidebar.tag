<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="w3-container">
    <h5>Menu</h5>
  </div>
  <div class="w3-bar-block">
   
  <form action="controle" method="post">
  
  	<button class="w3-bar-item w3-button w3-padding  w3-hover-white"  style="background:#78bd5d" name="logica" value="LoadDashboard"><i class="fa fa-dashboard"></i>  Dashboard</button>
  	<button class="w3-bar-item w3-button w3-padding" name="logica" value="EmprestimoPage"><i class="fa fa-handshake-o"></i>  Novo empréstimo</button> 
    <button class="w3-bar-item w3-button w3-padding" name="logica" value="ListarEmprestimo"><i class="fa fa-cubes"></i>  Meus empréstimos</button>

    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bullseye fa-fw"></i>  Manutenção</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-diamond fa-fw"></i>  Lista de espera</a>
     <div class="w3-bar-item w3-button w3-padding" onclick="myAccFunc()"><i class="fa fa-bell fa-fw"></i> Cadastros</div>
 		 <div id="demoAcc" class="w3-hide w3-white w3-card-4">
   			 <a href="#" class="w3-bar-item w3-button">Impressora</a>
   			 <a href="#" class="w3-bar-item w3-button">Loja</a>
 		 </div>   
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bank fa-fw"></i>  Historico</a>   	
    <br><br>
    </form>
  </div>
