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
                    <a href="Create">Crear</a>
                </div>
            </div>
            <div class="row">
                <div class="col">
					<!-- ${tareas} -->                    
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="">id</th>
                            <th scope="col">titulo</th>
                            <th scope="col">descripcion</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach items="${tareas}" var="tarea">
                          <tr>
                            <td>${tarea.id}</td>
                            <td>${tarea.titulo}</td>
                            <td>${tarea.descripcion}</td>
                            <td>
                            	<a href="Show?id=${tarea.id}">Ver</a>
                            	<a href="Edit?id=${tarea.id}">Modificar</a>
                            	<a href="Destroy?id=${tarea.id}">Eliminar</a>                            	
                            </td>
                          </tr>
                          </c:forEach>
                          
                        </tbody>
                      </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
      </body>
    </html>