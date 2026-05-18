<%-- 
    Document   : pedidos
    Created on : 13/05/2026, 10:06:33 p. m.
    Author     : berna
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Pedido"%>
<%@page import="modelo.PedidoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Usuario u = (Usuario) session.getAttribute("usuario");

if(u == null)
{
    response.sendRedirect("login.jsp");
    return;
}

PedidoDAO dao = new PedidoDAO();
ArrayList<Pedido> lista = dao.listarPedidos();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
        <link rel="stylesheet" href="css/variables.css">
        <link rel="stylesheet" href="css/global.css">
        <link rel="stylesheet" href="css/tablas.css">
    </head>
    <body>
        <h1>LISTA DE PEDIDOS</h1>
        
        <table border="1">  
            <tr>
                <th>ID</th>
                <th>Cliente</th>
                <th>Descripcion</th>
                <th>Prioridad</th>
                <th>Estado</th>
                <th>Repartidor</th>
            </tr>
            
            <%
            for(Pedido p : lista)
            {
            %>

            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getClienteId() %></td>
                <td><%= p.getDescripcion() %></td>
                <td><%= p.getPrioridad() %></td>
                <td><%= p.getEstado() %></td>
                <td><%= p.getRepartidorId() %></td>
            </tr>

            <%
            }
            %>
            
        </table>
            
        <br><br>
        
        <a href="admin.jsp">
            <button>Volver al menú</button>
        </a>
    </body>
</html>
