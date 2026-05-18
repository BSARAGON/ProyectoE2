<%-- 
    Document   : login
    Created on : 13/05/2026, 10:05:52 p. m.
    Author     : berna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/variables.css">
        <link rel="stylesheet" href="css/global.css">
        <link rel="stylesheet" href="css/formularios.css">
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="login-container">

            <h1>LOGIN</h1>

            <form action="${pageContext.request.contextPath}/LoginServlet" method="POST">

                <label>Correo</label>
                <input type="text" name="correo" required>

                <label>Password</label>
                <input type="password" name="password" required>

                <input type="submit" value="Ingresar">

            </form>

            <br>

            <a href="index.jsp">
                <button type="button">Volver al inicio</button>
            </a>

            <a href="registro.jsp">
                <button type="button">Registrarse</button>
            </a>

            <br><br>

            <%
            String error = (String) request.getAttribute("error");

            if(error != null)
            {
            %>

            <p style="color:red;"><%= error %></p>

            <%
            }
            %>

        </div>
    
    </body>
</html>
