<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
	<title>Serviços</title>
</head>
<body>
	
	<a href="cadastro-servicos.jsp" class="button">Novo Serviço</a>
	
	<table  class="tbl" border="1">
		<thead>
			<tr>
				<th>NOME</th>
				<th>EDITAR</th>
				<th>EXCLUIR</th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach items="${servicos}" var="a">
 				<tr class="tblHover">
 					<td>${a.nome}</td>
 					<td><a class="btnEditar" href="servicos?id=${a.id}&acao=editar"> <img alt="" src="edit.png" width="25px"> </a></td>
 					<td><a class="btnExcluir" href="servicos?id=${a.id}&acao=excluir"> <img alt="" src="delete.png" width="25px"></a></td>
 				</tr>
 				</c:forEach>
		</tbody>
	</table>
	
</body>
</html>