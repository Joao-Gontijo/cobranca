<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
	<title>Cadastro de Serviços</title>
</head>
<body>
	
	<form action="servicos" method="post">
		<input type="hidden" name="id" id="id" value="${servico.getId()}" />
		<p><input required type="text" name="input-nome" placeholder="Digite o nome" size="70" value="${servico.getNome() }"/></p>
		
		<p><input type="submit" class="button" name="btn-salva" value="salvar"/></p>
	</form>

</body>
</html>