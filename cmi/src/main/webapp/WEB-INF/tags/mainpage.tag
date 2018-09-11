<%@tag description="Main Page template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:genericpage>
	<jsp:attribute name="top">     	
		<t:top />	
    </jsp:attribute>
    

	<jsp:attribute name="sidebar">
      
     <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
   
   		<t:userbar />
   		<t:sidebar />
   
	</nav>
    <!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div> 
 
    </jsp:attribute>


	<jsp:body>
		<div class="w3-main" style="margin-left:300px;margin-top:43px;">
       		 <jsp:doBody />
        </div>
    </jsp:body>
</t:genericpage>
