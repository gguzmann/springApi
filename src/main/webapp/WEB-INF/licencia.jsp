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

		<h1>Registrar nuevo auto:</h1>
		
		<c:out value="${msgError }"></c:out>
		<form:form action="/licencia/validar" method="post"
			modelAttribute="licencia">
			
			<div class="form-group">
			<form:label path="numero">Numero:</form:label>
			<form:input class="form-control" type="number" path="numero" />
			</div>

			<div class="form-group">
			<form:label path="fechaVencimiento">Fecha Vencimiento:</form:label>
			<form:input class="form-control" path="fechaVencimiento" type="date" min="2022-06-02" max="2022-06-08" />
			</div>

			<div class="form-group">
			<form:label path="clase">Clase:</form:label>
			<form:input class="form-control" path="clase" />
			</div>
			<br>
			
			<div class="form-group">
			<form:label path="estado">Estado:</form:label>
			<form:input class="form-control" path="estado" />
			</div>
			<br>
			
			
			<!-- Usuario -->
			<form:select class="form-select" path="usuario">
				<form:option value="0">Seleccione un usuario</form:option>
				<c:forEach items="${listaUsuarios}" var="usuario">
					<c:if test="${usuario.licencia == null}">
						<form:option value="${usuario.id}">${usuario.nombre} ${usuario.apellido }</form:option>
					</c:if>
				</c:forEach>
			</form:select>
			
			<br>
			<input type="submit" class="btn btn-primary" value="registrar" />
		</form:form>

		<table class="table">
			<thead>
				<tr>
					<td>Numero</td>
					<td>Fecha de Vencimiento</td>
					<td>Clase</td>
					<td>Estado</td>
					<td>Nombre</td>
					<td>Apellido</td>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${listaLicencias }" var="licencia">
				<tr>
					<td>${licencia.numero }</td>
					<td>${licencia.fechaVencimiento }</td>
					<td>${licencia.clase }</td>
					<td>${licencia.estado }</td>
					<td>${licencia.usuario.nombre }</td> <!-- LAZY -->
					<td>${licencia.usuario.apellido }</td> <!-- LAZY -->
				</tr>
			</c:forEach>
			
			</tbody>
		
		
		</table>


	</div>

</body>
</html>