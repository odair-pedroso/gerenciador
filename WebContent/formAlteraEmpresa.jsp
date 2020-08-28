<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<c:url value="/alteraEmpresa" var="LinkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Empresa</title>
</head>
<body>

	<form action="${LinkServletNovaEmpresa}" method="post">
	
		Nome: <input type = "text" name = "nome" value="${empresa.nome}"/>
		Data Abertura: <input type = "text" name = "data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${empresa.id}">
		
		<input type="submit"/>	
	
	</form>

</body>
</html>