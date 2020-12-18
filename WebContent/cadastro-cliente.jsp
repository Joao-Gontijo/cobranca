<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
</head>
<body>
<form action="clientes" method="post">
		<input type="hidden" name="id" id="id" />
		CNPJ <input type="text" name="input-cnpj" size="30"/>
		Nome <input type="text" name="input-nome" size="70"/>
		<p>Nome Fantasia <input type="text" name="input-nomeFantasia" size="70"/></p>
		
		<p>CEP <input type="text" name="input-cep" size="30"/>
		Logradouro <input type="text" name="input-logradouro" size="70"/></p>
		
		<p>Numero <input type="text" name="input-numero" size="30"/>
		Complemento <input type="text" name="input-complemento" size="70"/></p>
		
		<p>UF <select id="cbx-uf" name="cbx-uf" style="width:60px">
		</select>
		
		Municipio <select id="cbx-municipio" name="cbx-municipio" style="width:300px">
		</select>
		
		</p>
		
		
		
		<p><input type="submit" name="btn-salva" value="salvar"/></p>
	
	</form>
</body>
</html>