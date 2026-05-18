<%-- 
    Document   : admin
    Created on : 13/05/2026, 10:06:09 p. m.
    Author     : berna
--%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null || !usuario.getRol().equals("admin"))
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
        <link rel="stylesheet" href="css/variables.css">
        <link rel="stylesheet" href="css/global.css">
        <link rel="stylesheet" href="css/dashboard.css">
    </head>
    <body>
        <div class="container">

            <h1>MENU ADMINISTRADOR</h1>

            <div class="menu">

                <div class="card">
                    <h3>Gestionar Usuarios</h3>

                    <a href="listarUsuarios.jsp">
                        <button>Ingresar</button>
                    </a>
                </div>

                <div class="card">
                    <h3>Ver Pedidos</h3>

                    <a href="pedidos.jsp">
                        <button>Ingresar</button>
                    </a>
                </div>

                <div class="card">
                    <h3>Asignar Repartidores</h3>

                    <a href="asignar.jsp">
                        <button>Ingresar</button>
                    </a>
                </div>

                <div class="card">
                    <h3>Cerrar Sesión</h3>

                    <a href="logout.jsp">
                        <button>Cerrar</button>
                    </a>
                </div>

            </div>

        </div>
    </body>
</html>
