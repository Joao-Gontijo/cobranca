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
	<title>Clientes</title>
</head>
<body>

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
 				<tr class="tblHover">
 					<td>${a.cnpj}</td>
 					<td>${a.nome}</td>
 					<td>${a.nomeFantasia}</td>
 					<td>${a.cep}</td>
 					<td>${a.logradouro}</td>
 					<td>${a.numero}</td>
 					<td>${a.complemento}</td>
 					<td>${a.uf}</td>
 					<td>${a.municipio}</td>
 					<td><a class="btnEditar" href="clientes?cnpj=${a.cnpj}&acao=editar"> <img alt="" src="edit.png" width="25px"></a></td>
 					<td><a class="btnExcluir" href="clientes?cnpj=${a.cnpj}&acao=excluir"> <img alt="" src="delete.png" width="25px"></a></td>
 					<td><a class="" href="contratos?cnpj=${a.cnpj}&acao=contratos"> CONTRATOS </a></td>
 				</tr>
 				</c:forEach>
		</tbody>
	</table>

</body>
</html>