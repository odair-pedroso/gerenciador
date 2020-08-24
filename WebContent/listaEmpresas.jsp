
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
</head>

<body>
	Lista de Empresas cadastradas : <br/>

	<ul>
		<% 	List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
			
			for (Empresa empresa : lista) {
		
		%>
			<li><%= empresa.getNome() %></li>
			
		<%
		
			}
		%>	
	
	</ul>



</body>



</html>