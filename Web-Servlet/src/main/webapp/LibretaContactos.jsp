<%@page import="pucese.edu.web.Contactos"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
ArrayList<Contactos> contactos;
%>

<body>

<%

//creamos un obj contactos y que obtiene los parametros de la session "contactos"
contactos = (ArrayList<Contactos>)session.getAttribute("contactos");

if (contactos ==null){ //si esta vacio creamos un nuevo objeto
	contactos = new ArrayList<Contactos>(); //estamos un nuevo objeto llaamdo contactos de tipo contactos
	session.setAttribute("contactos", contactos); // la session creada con el nuevo obj se llama "contactos"
}

//obtener los atributos de la pagina web
String metodo = request.getMethod();

//se obtienen los atributos del formulario web
if ("POST".equals(metodo)){
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String telefono = request.getParameter("telefono");
	
	//agregar los datos obtenidos a mi clase Contactos para que se guarden.
	
	Contactos contacto = new Contactos();
	contacto.setNombre(nombre);
	contacto.setApellido(apellido);
	contacto.setTelefono(telefono);
	
//agregalos los datos en el arraylist Contactos

	contactos.add(contacto);
		
}




%>

<h1>Libreta de Contactos</h1>
<form method="post">
<label>Nombre</label>
<input type="text" name= "nombre"/>
<label>Apellido</label>
<input type="text" name= "apellido"/>
<label>Telefono</label>
<input type="text" name= "telefono"/>

<button type="submit">Guardar</button>

</form>

<h1>Contactos Registrados</h1>
<table>
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Telefono</th>
		</tr>
	</thead>
	<tbody>
	<% for (Contactos c:contactos){
	%>
		<tr>
			<th><%=c.getNombre() %></th>
			<th><%=c.getApellido() %></th>
			<th><%=c.getTelefono()%></th>
		</tr>
	<%
	}
	%>
	</tbody>
	</table>

</body>
</html>