<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>
	<div>
		<c:if test="${!msgError }">
			<c:out value="${ msgError}"></c:out>
		</c:if>
		
		<form:form action="/register" autocomplete="off" method="post" modelAttribute="usuario">
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre"/>
			<br>
			<form:label path="apellido">Apellido:</form:label>
			<form:input path="apellido"/>
			<br>
			<form:label path="edad">Edad:</form:label>
			<form:input type="number" path="edad"/>
			<br>
			<form:label path="password">Password:</form:label>
			<form:input type="password" path="password"/>
			<br>
			<input type="submit" value="Enviar"/>
		</form:form>
	</div>
</body>
</html>