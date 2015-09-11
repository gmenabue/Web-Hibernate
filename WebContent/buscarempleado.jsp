<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Empleado JSP</title>
</head>
<body>

<form action="hibernateServlet" method="get">

	<p>Introduce el ID del empleado que deseas buscar</p>
	<input type="text" name="id"/>
	<input type="submit" value="Buscar"/>
	</form>

</body>
</html>