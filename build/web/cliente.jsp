<%-- 
    Document   : cliente
    Created on : 13/05/2026, 10:06:16 p. m.
    Author     : berna
--%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null || !usuario.getRol().equals("cliente"))
{
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
        <link rel="stylesheet" href="css/variables.css">
        <link rel="stylesheet" href="css/global.css">
        <link rel="stylesheet" href="css/formularios.css">
        <link rel="stylesheet" href="css/dashboard.css">
    </head>
    <body>
        <div class="container">

            <h1>MENU CLIENTE</h1>

            <div class="card-form">

                <form action="PedidoServlet" method="POST">

                    <input type="hidden" name="clienteId" value="<%= usuario.getId() %>">

                    <label>Descripción</label>
                    <input type="text" name="descripcion">

                    <label>Prioridad</label>

                    <select name="prioridad">
                        <option>Alta</option>
                        <option>Media</option>
                        <option>Baja</option>
                    </select>

                    <input type="submit" value="Crear Pedido">

                </form>

            </div>

            <br><br>

            <div class="menu">

                <div class="card">
                    <h3>Historial</h3>

                    <a href="historial.jsp">
                        <button>Ver</button>
                    </a>
                </div>

                <div class="card">
                    <h3>Cerrar Sesión</h3>

                    <a href="logout.jsp">
                        <button>Salir</button>
                    </a>
                </div>

            </div>

        </div>
    </body>
</html>

