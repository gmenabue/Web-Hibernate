<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adivina Un Número</title>
</head>
<body>

<%-- Inicio del Declaration --%>
<%!
	Integer numeroMedio = 50;
	Integer numeroMaximo = 100;
	Integer numeroMinimo = 0;
	boolean adivinado = false;
	

	
private Integer calcular (Integer superior , Integer inferior){
	Integer calculo = 0;
	calculo = ((superior + inferior) / 2);
	return calculo; 
	
	
}
%>

<p><img alt="" src="http://fotos.miarroba.es/fotos/7/5/75a9f7ca.jpg"></p><br>
<p>Es este su número?</p>
<textarea rows="" cols=""><%= numeroMedio %></textarea><br>

<form action="adivinarnumero.jsp" method="get">
<select name="option">
	<option value="Mayor">Mayor</option>
	<option value="Menor">Menor</option>
	<option value="Igual">Igual</option>
</select><br>

	<input type="submit" value="Adivinar"/>
	</form>




<%-- Inicio Del Scriplet  --%>
<% 

	
	String resultado = request.getParameter("option");
	
	if(resultado == null){
		Integer numeroMedio = 50;
		Integer numeroMaximo = 100;
		Integer numeroMinimo = 0;
	}
	else{
	if (resultado != null){	

		if(resultado.equals("Mayor")){
			numeroMedio = calcular(numeroMaximo, numeroMedio); 
		}
		
		if(resultado.equals("Menor")){
			numeroMedio = calcular(numeroMedio, numeroMinimo);
		}
		
		if(resultado.equals("Igual")){
			adivinado = true;
		}
	}
}	 
	
	%>


</body>
</html>