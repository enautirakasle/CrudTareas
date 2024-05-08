<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    <!doctype html>
    <html lang="en">
      <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Crud tareas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
      </head>
      <body>
       
        <div class="container">
            <div class="row">
                <div class="col">
                    <a href="IndexTarea">Inicio</a>
                </div>
            </div>
            <div class="row">
                <div class="col">

                <c:if test="${msg=='nok'}">
	                <div class="alert alert-danger alert-dismissible fade show" role="alert">
					  <strong>Error!</strong> Faltan campos requeridos.
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
                </c:if>
                
                    <form action="StoreTarea" method="post">
                    	<p>Titulo: <input type="text" name="titulo"/></p>
                    	<p>Descripcion: <input type="text" name="descripcion"/></p>
                    	<p>Dificultad: 
                    		<select name="dificultad">
                    			<option value="0"> </option>
                    			<c:forEach items="${dificultades}" var="dificultad">
                    			<option value="${dificultad.id}">${dificultad.nombre}</option>
                    			</c:forEach>
                    		</select>
                    	</p>
                    	<p>Asignar  a: <br>
                    	<c:forEach items="${usuarios}" var="usuario">
                    		 <input type="checkbox" value="${usuario.id}" name="usuarios[]"/> ${usuario.nombre}<br>
                    	</c:forEach>
                    	</p>
						<input type="submit" value="Guardar" name="Guardar">
					</form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
      </body>
    </html>