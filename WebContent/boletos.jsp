<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>Boleto</title>
</head>
<body>
	<h1 style="margin-left: 10px">BOLETO</h1>
	<%-- <h2 style="margin-left: 10px">Cliente: ${contrato.getCliente().getNome()}</h2> --%>
	
	<table class="tbl" border="1">
	
	
		<thead>
			<tr>
				<!-- <th>CODIGO DO CONTRATO</th> -->
				<th>CLIENTE</th>
				<th>SERVICO</th>
				<th>VALOR</th>
			</tr>
		</thead>

		<tbody>
			<tr class="tblhover">
				<%-- <td>${contrato.getCodigo()}</td> --%>
				<td>${contrato.getCliente().getNome()}</td>
				<td>${contrato.getServico().getNome()}</td>
				<td>${contrato.getValor() }</td>
			</tr>
		</tbody>
	</table>
	
	<a class="button" href="boletos?acao=gerar&id=${contrato.id}">Download</a>
</body>
</html>