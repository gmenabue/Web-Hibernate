<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Empleado JSP</title>
</head>
<body>

<%--  
<jsp:useBean id="empleado" type="hibernate.clase.DTO.Employees" scope="request"/>


	Nombre: <jsp:getProperty name="empleado" property="firstName"/><br>
	Apellido: <jsp:getProperty name="empleado" property="lastName"/><br>
	Salario: <jsp:getProperty name="empleado" property="salary"/><br>
--%>

<UL>
<LI><B>First Name:</B> ${empleado.firstName}	
<LI><B>Last Name:</B> ${empleado.lastName}
	





</body>
</html>