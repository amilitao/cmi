<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="w3-container">
    <h5>Menu</h5>
  </div>
  <div class="w3-bar-block">
   
  <form action="controle" method="post">
  
  	<button class="w3-bar-item w3-button w3-padding  w3-hover-white"  style="background:#78bd5d" name="logica" value="LoadDashboard"><i class="fa fa-dashboard"></i> Dashboard</button>
  	<button class="w3-bar-item w3-button w3-padding" name="logica" value="EmprestimoPage"><i class="fa fa-handshake-o"></i> Novo empréstimo</button> 
    <button class="w3-bar-item w3-button w3-padding" name="logica" value="ListarEmprestimo"><i class="fa fa-cubes"></i> Meus empréstimos</button>

    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-wrench"></i> Manutenção</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-edit"></i> Lista de espera</a>
     <div class="w3-bar-item w3-button w3-padding" onclick="myAccFunc()"><i class="fa fa-plus-square-o"></i> Cadastros</div>
 		 <div id="demoAcc" class="w3-hide w3-white w3-card-4">
   			 <button class="w3-bar-item w3-button w3-padding" name="logica" value="ImpressoraPage"><i class="fa fa-print"></i> Impressora</button>
   			 <button class="w3-bar-item w3-button w3-padding" name="logica" value="LojaPage"><i class="fa fa-home"></i> Loja</button>
 		 </div>   
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-database"></i> Historico</a>   	
    <br><br>
    </form>
  </div>
