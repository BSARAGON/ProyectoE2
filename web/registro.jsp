<%-- 
    Document   : registro
    Created on : 13/05/2026, 10:06:02 p. m.
    Author     : berna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>REGISTRO</h1>
        
        <form action="RegistroServlet" method="POST">
        
        <input type="hidden" name="id" value="0">
        <br><br>
        
        Nombre: <input type="text" name="nombre">
        <br><br>
        
        Correo: <input type="text" name="correo">
        <br><br>
        
        Password: <input type="password" name="password">
        <br><br>
        
        Rol:
        <select name="rol">
            <option>Cliente</option>
            <option>Repartidor</option>
        </select>
        <br><br>
        
        <input type="submit" value="Registrar">

        </form>
    </body>
</html>
