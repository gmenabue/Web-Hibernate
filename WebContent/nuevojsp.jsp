
<%@page import="java.util.List"%>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%> 
<%@ page import='java.util.Date' %> 
	<html> 
		<head> 
			<title>Hola Mundo</title> 
		</head> 
		<body>
		
		<%-- Con el errorPage redirijo a una pagina de error --%>
		<%@ page errorPage="error.jsp"%>
		 
		 
		 <% 
		 /*
		 Object nuevo = null;
		 List nuevalista= null;
		 
		 int arraynum[] = new int[2];
		 arraynum[5] = 3;
		 */
		  %>
		
		<%-- Con el page session nos hace o no la sesión --%>
		<%@ page session="false"%>
		
			 <p>Hola, esto es una página JSP.</p> 
			<p>La hora del servidor es <%= new Date() %></p> 
			
			<jsp:include page="/sesionesActivasServlet"></jsp:include>
			
		</body> 
</html> 
