<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Spring Web MVC</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <div class="container mt-4">
			<div class="card border-info">
				<div class="card-header bg-info text-white">
					<a href="agregar.htm" class="btn btn-success">Nuevo Registro</a>
				</div>
				<div class="card-body">
					<table border="1" class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>NOMBRES</th>
								<th>CORREO</th>
								<th>NACIONALIDAD</th>
								<th>ACCIONES</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dato" items="${lista}"> 
							<tr>
								<td>${dato.Id}</td>
								<td>${dato.Nombres}</td>
								<td>${dato.Correo}</td>
								<td>${dato.Nacionalidad}</td>
								<td>
									<a href="editar.htm?id=${dato.Id}" class="btn btn-warning">Editar</a>
									<a href="delete.htm?id=${dato.Id}" class="btn btn-danger">Delete</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div> 
	</body>
</html>
