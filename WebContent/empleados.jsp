<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="hibernate.clase.DTO.Employees"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista De Empleados Departamentos</title>
</head>
<body>

<%-- 
<%! Employees emp = new Employees(); %>

<% 
		List<Employees> lista_empleados = new ArrayList<Employees>();

		lista_empleados = (ArrayList)request.getAttribute("listaempleados");
		%>
		<p>"EMPLEADOS DEL DEPARTAMENTO"</p>
		<%
		Iterator<Employees> ite = lista_empleados.iterator();
		
		if(lista_empleados != null){
				while (ite.hasNext()){
			
				emp = ite.next();
				%>
				
				
				Nombre: <%= emp.getFirstName() %>
				<%= "<br>" %>
				Apellido: <%= emp.getLastName() %>
				<%= "<br>" %>
				<%= "<br>" %>
				
				
				<% 
				}
		}
		
		
%>
--%>

	
	<p>Lista De Empleados Del Departamento</p>
<c:forEach items="${listaempleados}" var="empleado" varStatus="i" > 	
	

	Nombre: <c:out value="${empleado.firstName}"></c:out><br> 
	Apellido: <c:out value="${empleado.lastName}"></c:out>
	<br>
	<br>
	
</c:forEach> 



</body>
</html>