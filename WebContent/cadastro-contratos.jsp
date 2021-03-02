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
<title>Cadastro de Contratos</title>
</head>
<body>
	
	<form action="contratos" method="post">
	
	<%-- <input required type="hidden" name="cnpj" id="cnpj" value="${cliente.getCnpj() }"/> --%>
	<input type="hidden" name="id" id="id" value="${contrato.getId()}" />
	<p>CLIENTE <select required class="select" id="cbx-cliente" name="cbx-cliente" style="width:280px">
		<option>Selecione o cliente ->
			<c:forEach items="${cliente}" var="a">
				<option value="${a.cnpj}"> ${a.nome}</option>
			</c:forEach>
		</option>
	</select></p>
	
	<p>SERVIÇO <select required class="select" id="cbx-servico" name="cbx-servico" style="width:280px">
		<option>Selecione o serviço ->
			<c:forEach items="${servico}" var="a">
				<option value="${a.id}"> ${a.nome}</option>
			</c:forEach>
		</option>
	</select></p>
		
	VALOR <input required type="number" step=".01" name="input-valor" size="30" placeholder="00,00"
	maxlength="15" value="${contrato.getValor}"/>
	
	<p> <input type="submit" class="button" name="btn=salva" value="salvar"/></p>
	</form>
	
</body>
</html>