<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Sistema Estudantil</title>
</head> 
<body>
<%

	String email=(String)request.getParameter("email");
	String userId=request.getParameter("email");
	session.setAttribute("user",userId);	

	
	%>
	
	<script>
		    window.location.href = 'cadastrarCurso.jsp';
	</script>
	
</body>


 
 
 
