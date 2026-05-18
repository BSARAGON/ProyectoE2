<%-- 
    Document   : repartidor
    Created on : 13/05/2026, 10:06:26 p. m.
    Author     : berna
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Pedido"%>
<%@page import="modelo.PedidoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null || !usuario.getRol().equals("Repartidor"))
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
        <title>Repartidor</title>
    </head>
    <body>
        <h1>PEDIDOS ASIGNADOS</h1>
        
        <table border="1">  
            <tr>
                <th>ID</th>
                <th>Descripcion</th>
                <th>Estado</th>
                <th>Accion</th>
            </tr>
            
            <%
            for(Pedido p : lista)
            {
                if(p.getRepartidorId() == usuario.getId())
                {
            %>

            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getDescripcion() %></td>
                <td><%= p.getEstado() %></td>
                <td>
                    <form action="EntregarServlet" method="POST">
                        <input type="hidden" name="id" value="<%= p.getId() %>">
                        <input type="submit" value="Marcar Entregado">
                    </form>
                </td>
            </tr>

            <%
                }
            }
            %>
            
        </table>
        
        <br><br>
        
        <a href="logout.jsp">
            <button>Cerrar Sesión</button>
        </a>
    </body>
</html>
