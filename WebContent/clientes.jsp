<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
	
	<style type="text/css">
		a.button {
			background-color: #9A9898;
    	    border: solid 1px black;
    	    border-radius:5px;
    	    color: black;
    	    padding: 5px 14px;
    	    text-align: center;
    	    text-decoration: none;
    	    display: inline-block;
    	    font-size: 20px;
    	    margin: 4px 2px;
    	    cursor: pointer;
		}
		
		.tbl th {
			border-collapse: collapse;
			padding: 20px;
		}
		
		.tbl td {
			padding: 2px 20px;
		}
	</style>
</head>
<body>



	<h1>Clientes</h1>
	
	

	<a href="cadastro-cliente.jsp" class="button">Novo Cliente</a>
	<table class="tbl" border="1">
		
		<thead>
			<tr>
				<th>CNPJ</th>
				<th>NOME</th>
				<th>NOME FANTASIA</th>
				<th>CEP</th>
				<th>LOGRADOURO</th>
				<th>NUMERO</th>
				<th>COMPLEMENTO</th>
				<th>UF</th>
				<th>MUNICIPIO</th>
				<th>EDITAR</th>
				<th>EXCLUIR</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientes}" var="a">
 				<tr>
 					<td>${a.cnpj}</td>
 					<td>${a.nome}</td>
 					<td>${a.nomeFantasia}</td>
 					<td>${a.cep}</td>
 					<td>${a.logradouro}</td>
 					<td>${a.numero}</td>
 					<td>${a.complemento}</td>
 					<td>${a.uf}</td>
 					<td>${a.municipio}</td>
 					<td><a href="clientes?cnpj=${a.cnpj}&acao=editar">editar</a></td>
 					<td><a href="clientes?cnpj=${a.cnpj}&acao=excluir">excluir</a></td>
 				</tr>
 				</c:forEach>
		</tbody>
	</table>
</body>
</html>