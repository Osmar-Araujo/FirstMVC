<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id= "Usuario" type="model.Usuario" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bem-Vindo!</h1>
	<hr>
	Seu id: <strong>${Usuario.id}</strong> <br>
	Seu nome: <strong>${Usuario.fullname}</strong> <br>
	Seu username: <strong>${Usuario.username}</strong> <br>
	Seu email: <strong>${Usuario.email}</strong> <br>
</body>
</html>