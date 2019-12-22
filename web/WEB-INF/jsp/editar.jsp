<%-- 
    Document   : editar
    Created on : 21/12/2019, 01:06:08 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Persona</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
			<div class="card border-info">
				<div class="card-header bg-info">
					<h4>Editar Registro</h4>
				</div>
				<div class="card-body">
					<form method="POST">
						<label>Nombres</label>
						<input type="text" name="nombre" value="${lista[0].Nombres}" class="form-control">
						<label>Correo</label>
						<input type="text" name="correo" value="${lista[0].Correo}" class="form-control">
						<label>Nacionalidad</label>
						<input type="text" name="nacionalidad" value="${lista[0].Nacionalidad}" class="form-control">
						
						<input type="submit" value="Actualizar" class="btn btn-success">
						<a href="index.htm">Regresar</a>
					</form>
				</div>
			</div>
			
		</div>
    </body>
</html>
