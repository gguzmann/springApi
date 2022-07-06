<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

	<div class="container">

		<h1>Bienvenido</h1>
		<hr />
		
		
			<h2>Autos:</h2>
		<div class="d-flex justify-content-between">
		<form class="d-flex" action="/auto/buscar" method="post">
			<input type="text" class="form-control" name="marca" id="search">
			<input type="submit" class="btn btn-primary" value="Buscar">
		</form>
			<a href="auto/register" class="btn btn-primary">Register car</a>
		</div>
		
		<c:out value="${msg }"></c:out>
		
		<!-- PAGINACION -->
		<nav aria-label="Page navigation example">
  			<ul class="pagination">
				<c:forEach var="pagina" begin="1" end="${totalPages }">
					<li class="page-item"><a class="page-link" href="/auto/pagina/${pagina }">${pagina}</a></li>
				</c:forEach>
			 </ul>
		</nav>
		
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Marca</th>
					<th scope="col">Color</th>
					<th scope="col">Precio</th>
					<th scope="col">Eliminar</th>
					<th scope="col">Editar</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach var="autos" items="${listAuto.content}">

					<tr>
						<th><c:out value="${autos.id}"></c:out></th>
						<th><c:out value="${autos.marca}"></c:out></th>
						<th><c:out value="${autos.color}"></c:out></th>
						<th><c:out value="${autos.precio}"></c:out></th>
						<th><a href="auto/delete/${autos.id}" class="btn btn-danger"><i
								class="fa-solid fa-trash-can"></i></a></th>
						<th><a href="auto/edit/${autos.id }" class="btn btn-success"><i
								class="fa-solid fa-pen-to-square"></i></a></th>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>
</body>
</html>