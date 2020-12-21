<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
	<title>Servi�os</title>
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
						<li><a href="servicos"> SERVI�OS </a></li>
						
					</ul>
				</nav>
				
			</div>

		</div>

	</header>
	
	<a href="cadastro-servicos.jsp" class="button">Novo Servi�o</a>
	
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
 					<td><a class="btnEditar" href="servicos?id=${a.id}&acao=editar">editar</a></td>
 					<td><a class="btnExcluir" href="servicos?id=${a.id}&acao=excluir">excluir</a></td>
 				</tr>
 				</c:forEach>
		</tbody>
	</table>
	
	<footer>
		<div class="containertFooter">
			<div class="footer_menu">
				<div class="div1"> 
									SISTEMA DE COBRAN�A || DESENVOLVIDO POR: ALDO PEREIRA E JO�O VICTOR GONTIJO
				 </div>
				
			</div>
		</div>
	</footer>
</body>
</html>