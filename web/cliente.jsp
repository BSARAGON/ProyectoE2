<%-- 
    Document   : cliente
    Created on : 13/05/2026, 10:06:16 p. m.
    Author     : berna
--%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null || !usuario.getRol().equals("Cliente"))
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
    </head>
    <body>
        <h1>MENU CLIENTE</h1>
        
        <form action="PedidoServlet" method="POST">

            ID Pedido: <input type="number" name="id">
            <br><br>

            <input type="hidden" name="clienteId" value="<%= usuario.getId() %>">

            Descripcion <input type="text" name="descripcion">
            <br><br>

            Prioridad:
            <select name="prioridad">
                <option>Alta</option>
                <option>Media</option>
                <option>Baja</option>
            </select>
            <br><br>

            <input type="submit" value="Crear Pedido">
        </form>
            
        <br><br>

        <a href="historial.jsp">Ver Historial</a>
        <br><br>

        <a href="logout.jsp">Cerrar Sesión</a>
    </body>
</html>

