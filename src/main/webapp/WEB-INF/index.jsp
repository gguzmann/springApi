<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva pagina</title>
</head>
<body>
	<h1>Hola <c:out value="${nombre}"></c:out> <c:out value="${apellido}"></c:out> </h1>
	<c:out value="${edad}"></c:out>
	<br>
	<p><c:out value="nombre: ${usuario.nombre} ${usuario.getApellido()} edad: ${usuario.edad}"></c:out></p>
</body>
</html>
