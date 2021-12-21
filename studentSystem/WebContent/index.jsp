<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR">
<head>
  <title>Sistema Estudantil</title>
  <script src="https://apis.google.com/js/platform.js" async defer></script>
  <meta name="google-signin-client_id" content="664313578549-rknjkd783j5p0sgqn0e0rhtf87rgmpof.apps.googleusercontent.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#myPage">Início</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="cadastrarCurso.jsp">Cadastrar Matéria</a></li>
        <li><a href="buscarCurso.jsp">Listar Matérias</a></li>
        <li><a href="cadastrarNota.jsp">Cadastrar Avaliação</a></li>
        <li><a href="buscarNota.jsp">Listar Avaliações</a></li>
      </ul>
    </div>
  </div>
</nav>
<br/>
<br/>
<br/>
<br/>
<br/>
<div class="container text-center" >

	<div class="g-signin2" data-onsuccess="onSignIn" id="myP" align="center"></div>
	   <img id="myImg"><br/></br>
	   <p id="name"></p>
	   <div id="status">
	</div> 
	
	<div id="exit">
	
	</div>
</div>
<footer class="page-footer font-small blue navbar-fixed-bottom">
  <div class="footer-copyright text-center py-3">© 2021 Copyright:
    GU301262X & GU3012573
  </div>
</footer>
  
	<script type="text/javascript">     
		function onSignIn(googleUser) {
	   	 	
			var profile = googleUser.getBasicProfile();
			var imagurl=profile.getImageUrl();
			var name=profile.getName();
			var email=profile.getEmail();
			document.getElementById("myImg").src = imagurl;
			document.getElementById("name").innerHTML = name;
			document.getElementById("myP").style.visibility = "hidden";
			document.getElementById("status").innerHTML = '<a href=success.jsp?email='+email+'&name='+name+'/>Acessar através do google</a><br/>'
			document.getElementById("exit").innerHTML = '<br/><button onclick="signOut()">Desconectar</button>'

		}
		
		function signOut() {
			var auth2 = gapi.auth2.getAuthInstance();
			auth2.signOut().then(function () {
			    auth2.disconnect();
			    window.location.href = 'exit.jsp';
			});
		}
   </script>


</body>
</html>
