
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
</head>

<body>
	Lista de Empresas cadastradas : <br/>
	
	<ul>
		
		<c:forEach items="${empresas}" var="empresa">		
		<li>${empresa.nome}</li>		
		</c:forEach>
		
	
	
	</ul>	

</body>


</html>