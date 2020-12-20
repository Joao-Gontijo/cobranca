<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>Serviços</title>
</head>
<body>
<header>
		<div class="container">
			<div class="logo">
				<a href="index.jsp"> <img alt="" src="logo1.png">
				</a>
			</div>

			<div class="menu">

				<nav>
					<ul>
						<li><a href="index.jsp"> INICIO </a></li>
						
						
						<li><a href="clientes"> CLIENTES </a></li>
						<li><a href="servicos"> SERVIÇOS </a></li>
						
					</ul>
				</nav>
				
			</div>

		</div>

	</header>
<h1>Servicos</h1>
	
	<a href="cadastro-cliente.jsp" class="button">Novo Cliente</a>
	
	<table border="1">
		<thead>
			<tr>
<!-- 				<th>ID</th> -->
				<th>NOME</th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach items="${servicos}" var="a">
 				<tr>
<%--  					<td>${a.id}</td> --%>
 					<td>${a.nome}</td>
 					<td><a href="servicos?id=${a.id}&acao=editar">editar</a></td>
 					<td><a href="servicos?id=${a.id}&acao=excluir">excluir</a></td>
 				</tr>
 				</c:forEach>
		</tbody>
	</table>
</body>
</html>