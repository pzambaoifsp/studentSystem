<%@page import="curso.model.Curso" %>
<%@page import="java.util.List" %>
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
		<form action="buscarCursos" method="post">
			<div class="form-group">
				<label for="name">Buscar por matéria:</label>
				<input type="hidden" name="idUser" value="<%= userId %>">
				<input type="text" class="form-control" name="name" placeholder="Ex.: Administração">
				<small id="name" class="form-text text-muted">Digite o nome da matéria a ser pesquisada.</small>
			</div>
			<br>
			<div class="form-group">
				<button type="submit" name="salvar" class="btn btn-primary">Listar matérias</button>
			</div>
			<%
				String mensagem = (String) request.getAttribute("mensagem");
				if (mensagem != null)
					out.print(mensagem);
			%>
		</form>
	
		<form action="modificarCurso" method="post">
			
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Matéria</th>
			      <th scope="col">Semestre</th>
			      <th scope="col">Editar</th>
			      <th scope="col">Apagar</th>
			    </tr>
			  </thead>
			  <tbody>
			  <% 
				if(request.getAttribute("cursos") != null) {
				List<?> cursos = (List<?>) request.getAttribute("cursos");
				for(int contador = 0; contador<= (cursos.size()-1); contador++) {
					Curso curso = (Curso) cursos.get(contador);
			  %>
			    <tr>
			      <th scope="row">
			      	<input type="hidden" name="idCourse" value="<%out.print(curso.getIdCourse());%>">
			      	<%out.print(curso.getIdCourse());%>
			      </th>
			      <td><%out.print(curso.getName()); %></td> 
			      <td><%out.print(curso.getSemester()); %></td> 
			      <td><input id="input" type="submit" name="alterar" value="alterar"></td>
			      <td><input id="input" type="submit" name="apagar" value="apagar"></td>
			    </tr>
			    <% }} %>
			  </tbody>
			</table>
		</form>
	</div>
	<footer class="page-footer font-small blue navbar-fixed-bottom">
		<div class="footer-copyright text-center py-3">
			© 2021 Copyright: GU301262X & GU3012573
		</div>
	</footer>
<footer class="page-footer font-small blue navbar-fixed-bottom">
  <div class="footer-copyright text-center py-3">© 2021 Copyright:
    GU301262X & GU3012573
  </div>
</footer>
</body>
</html>