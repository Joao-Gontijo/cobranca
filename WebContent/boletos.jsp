<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>Insert title here</title>
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
						<li><a href="boletos"> BOLETOS</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	
	<a href="cadastro-boletos.jsp" class="button">Novo Boleto</a>
	<table class="tbl" border="1">
		<thead>
			<tr>
				<th>CÓDIGO</th>
				<th>VALOR</th>
				<th>CLIENTE</th>
				<th>SERVICO</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach items="${boletos}" var="a">
			<tr class="tblHover">
				<td>${a.codigo}</td>
				<td>${a.valor}</td>
				<td>${a.cliente}</td>
				<td>${a.servico}</td>
				<td><a class="btnEditar" href="boletos?codigo=${a.codigo}&acao=editar"> <img alt="" src="edit.png" width="25px"></a></td>
				<td><a class="btnExcluir" href="boletos?codigo=${a.codigo}&acao=excluir"> <img alt="" src="delete.png" width="25px"></a></td>
				</tr>
		</c:forEach>
	</tbody>
	</table>
	
	<footer>
		<div class="containertFooter">
			<div class="footer_menu">
				<div class="div1"> 
									SISTEMA DE COBRANÇA || DESENVOLVIDO POR: ALDO PEREIRA E JOÃO VICTOR GONTIJO
				 </div>
				
			</div>
		</div>
	</footer>
</body>
</html>