<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Randomico</title>
</head>
<body>

<%
	double num = Math.random();
	if (num > 0.95){
%>
	<h2>tenga un buen dia:  </h2> <p> <%= num %> </p>

<% }
	else{ 
%>

	<h2>la variable num es:  </h2>
<p>
	<%= num %>
</p>
<% 
}
%>

<a href="<%= request.getRequestURI() %>"> Intenta otra vez </a> 


</body>
</html>