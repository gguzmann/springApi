<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>
	<div>
		<form action="/register/user" autocomplete="off" method="post">
			<label for="nombre">Nombre:</label>
			<input type="text" id="nombre" name="nombre"/>
			<br>
			<label for="apellido">Apellido:</label>
			<input type="text" id="apellido" name="apellido"/>
			<br>
			<label for="number">Edad:</label>
			<input type="text" id="edad" name="edad"/>
			<br>
			<input type="submit" value="Enviar"/>
		
		</form>
	
	
	</div>
</body>
</html>