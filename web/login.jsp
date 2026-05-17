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
    </head>
    <body>
        <h1>LOGIN</h1>
        
        <form action="LoginServlet" method="POST">
        
        Correo: <input type="text" name="correo">
        <br><br>
        
        Password: <input type="password" name="password">
        <br><br>
        
        <input type="submit" value="Ingresar">
        
        </form>
        
        <br>
        
        <%
        String error = (String) request.getAttribute("error");

        if(error != null)
        {
        %>

        <p><%= error %></p>

        <%
        }
        %>

        <br>

        <a href="registro.jsp">Ir a Registro</a>
    </body>
</html>
