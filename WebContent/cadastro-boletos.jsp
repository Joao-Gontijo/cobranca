<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>Cadastro de Boletos</title>
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
	
	<form action="boletos" method="post">
	
	CÓDIGO <input required type="text" name="input-codigo" size="30" placeholder="000.000.000.000"
	maxlength="15" value="${boleto.getCodigo}"/>
	VALOR <input required type="number" name="input-valor" size="30" placeholder="00,00"
	maxlength="15" value="${boleto.getValor}"/>
	
	
	<%-- <c:forEach items="${livros}" var="livro">
    	<option value="${livro.id_prateleiras.id}">${livro.id_prateleiras.descricao}</option>  
	</c:forEach> --%>
	
	<p> CLIENTE <select required class="select" id="cbx-cliente" name="cbx-cliente" style="width:80px">
		
	</select></p>
	
	<p>SERVIÇO <select required class="select" id="cbx-servico" name="cbx-servico" style="width:80px">
		
	</select></p>
	
	<p> <input type="submit" class="button" name="btn=salva" value="salvar"/></p>
	</form>
	
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