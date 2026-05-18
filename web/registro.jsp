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
        <link rel="stylesheet" href="css/variables.css">
        <link rel="stylesheet" href="css/global.css">
        <link rel="stylesheet" href="css/formularios.css">
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="login-container">

            <h1>REGISTRO</h1>

            <form action="RegistroServlet" method="POST">

                <label>Nombre</label>
                <input type="text" name="nombre" required>

                <label>Correo</label>
                <input type="text" name="correo" required>

                <label>Password</label>
                <input type="password" name="password" required>

                <label>Rol</label>

                <select name="rol">
                    <option>cliente</option>
                    <option>repartidor</option>
                </select>

                <input type="submit" value="Registrar">

            </form>

            <br>

            <a href="index.jsp">
                <button type="button">Volver al inicio</button>
            </a>

            <a href="login.jsp">
                <button type="button">Ir a Login</button>
            </a>

        </div>
    </body>
</html>
