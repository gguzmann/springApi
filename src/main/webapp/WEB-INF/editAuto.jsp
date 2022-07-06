<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">

		<h1>Editar Auto:</h1>
		<form:form action="/auto/edit/validate/${auto.id }" method="post"
			modelAttribute="auto">
			
			<div class="form-group">
			<form:label path="id">ID:</form:label>
			<form:input class="form-control" path="id" type="number" />
			</div>
			
			<div class="form-group">
			<form:label path="marca">Marca:</form:label>
			<form:input class="form-control" path="marca" />
			</div>

			<div class="form-group">
			<form:label path="color">Color:</form:label>
			<form:input class="form-control" path="color" />
			</div>
			
			<!--  
			<div class="form-group">
			<form:label path="velocidad">Velocidad Maxima:</form:label>
			<form:input class="form-control" path="velocidad" />
			</div>
			
			<div class="form-group">
			<form:label path="patente">Patente:</form:label>
			<form:input class="form-control" path="patente" />
			</div> -->
			
			<div class="form-group">
			<form:label path="precio">precio:</form:label>
			<form:input class="form-control" path="precio" />
			</div>
			
			<br>
			<input type="submit" class="btn btn-primary" value="Editar" />
			
			
		</form:form>

	</div>

</body>
</html>