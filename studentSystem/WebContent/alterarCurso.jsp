<%@page import="curso.model.Curso" %>
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

<%
	String userId=(String)session.getAttribute("user");
	if(userId == null){
		response.sendRedirect("index.jsp");			
	}
%>		

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
    	<a class="navbar-brand" href="index.jsp">Início</a>
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

	<div class="container">
		<form action="modificarCurso" method="post">
			<%
				Curso curso = null;
				if (request.getAttribute("curso") != null){
					curso = (Curso) request.getAttribute("curso");
				}
			%>
					
			<div class="form-group">
			    <input type="hidden" name="idCourse" value="<% out.print(curso.getIdCourse()); %>">
			</div>
			<div class="form-group">
			    <label for="name">Matéria:</label> 
			    <input type="text" class="form-control" name="name" value="<%out.print(curso.getName());%>">
			    <small id="name" class="form-text text-muted">Altere nome da matéria que está sendo cursada.</small>
			</div>
			<div class="form-group">
			    <label for="name">Semestre:</label>
			    <input type="text" class="form-control" name="semester" value="<%out.print(curso.getSemester());%>"
			    	onkeypress="return event.charCode >= 48 && event.charCode <= 57" >
			    <small id="semester" class="form-text text-muted">Altere o semestre em que a matéria está sendo cursada.</small>
			</div>
			<div class="form-group">
				<input type="hidden" name="idUser" value="<%= userId %>">
			</div>
			<div>
				<%
				String mensagem = (String) request.getAttribute("mensagem");
				if (mensagem != null)
					out.print(mensagem);
				%>
		  	</div>
		  <button type="submit" name="salvaalt" class="btn btn-primary">Atualizar Matéria</button>
		</form>
	</div>
<footer class="page-footer font-small blue navbar-fixed-bottom">
  <div class="footer-copyright text-center py-3">© 2021 Copyright:
    GU301262X & GU3012573
  </div>
</footer>
</body>
</html>