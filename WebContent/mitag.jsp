<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="mitag" uri="/WEB-INF/etiqueta.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ETIQUETA SIMPLE! <br>
<mitag:holaMundo nombre="Raul"/>
<br>
<br>
<mitag:nveces  num="3">Es esto!</mitag:nveces>
<br>
<br>
<mitag:atrDinamico  num="5">${count}</mitag:atrDinamico>
<br>
<br>
<br>ETIQUETA CLASSIC! <br>
<mitag:classic  num="5" idcountry="${count}">${count}</mitag:classic>
<br>
<br>
<br>ETIQUETA EMPLEADOS <br>
<mitag:empleados id="80"/>
</body>
</html>