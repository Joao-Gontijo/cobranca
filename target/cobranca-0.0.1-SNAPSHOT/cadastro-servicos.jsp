<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
	<title>Cadastro de Servi�os</title>
</head>
<body>

	<header>
		<div class="container">
			<div class="logo">
				<a href="index.jsp">
				<img alt="" src="logo1.png">
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
	
	<form action="servicos" method="post">
		<input type="hidden" name="id" id="id" value="${servico.getId()}" />
		<p><input required type="text" name="input-nome" placeholder="Digite o nome" size="70" value="${servico.getNome() }"/></p>
		
		<p><input type="submit" class="button" name="btn-salva" value="salvar"/></p>
	</form>

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