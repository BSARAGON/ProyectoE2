<%-- 
    Document   : historial
    Created on : 16/05/2026, 11:10:09 p. m.
    Author     : berna
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Pedido"%>
<%@page import="modelo.PedidoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null)
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
        <title>Historial</title>
    </head>
    <body>
        <h1>HISTORIAL DE PEDIDOS</h1>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Descripcion</th>
                <th>Prioridad</th>
                <th>Estado</th>
            </tr>
            
            <%
            for(Pedido p : lista)
            {
                if(p.getClienteId() == usuario.getId())
                {
            %>

            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getDescripcion() %></td>
                <td><%= p.getPrioridad() %></td>
                <td><%= p.getEstado() %></td>
            </tr>

            <%
                }
            }
            %>
            
        </table>
    </body>
</html>
