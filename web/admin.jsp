<%-- 
    Document   : admin
    Created on : 13/05/2026, 10:06:09 p. m.
    Author     : berna
--%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null || !usuario.getRol().equals("Admin"))
{
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
    </head>
    <body>
        <h1>MENU ADMINISTRADOR</h1>
        
        <a href="listarUsuarios.jsp">
            <button>Listar Usuarios</button>
        </a>

        <br><br>

        <a href="pedidos.jsp">
            <button>Ver Pedidos</button>
        </a>

        <br><br>

        <a href="asignar.jsp">
            <button>Asignar Repartidor</button>
        </a>

        <br><br>

        <a href="logout.jsp">
            <button>Cerrar Sesión</button>
        </a>
    </body>
</html>
