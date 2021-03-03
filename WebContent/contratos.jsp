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
<title>Contratos</title>
</head>
<body>
	
	<h1 style="margin-left: 10px" >CONTRATOS</h1> 
	<h1 style="margin-left: 10px"> Cliente : ${cliente.nome}  </h1> 
	
	<table class="tbl" border="1">
		<thead>
			<tr>
				<th>VALOR</th>
				<th>CLIENTE</th>
				<th>SERVICO</th>
				<th>EXCLUIR</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach items="${contratos}" var="a">
			<tr class="tblHover">
				<td>${a.valor}</td>
				<td>${a.cliente.nome}</td>
				<td>${a.servico.nome}</td>
				<%-- <td><a class="btnEditar" href="contratos?codigo=${a.codigo}&acao=editar"> <img alt="" src="edit.png" width="25px"></a></td> --%>
				<td><a class="btnExcluir" href="contratos?id=${a.id}&acao=excluir"> <img alt="" src="delete.png" width="25px"></a></td>
				<td><a class="btnExcluir" href="boletos?id=${a.id}&acao=contratos"> Gerar Boleto </a></td>
				</tr>
		</c:forEach>
	</tbody>
	</table>
	
	<a href="contratos?acao=novoContrato">Novo Contrato</a>
	
</body>
</html>