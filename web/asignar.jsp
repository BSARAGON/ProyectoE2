<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null || !usuario.getRol().equals("admin"))
{
    response.sendRedirect("login.jsp");
    return;
}

PedidoDAO pdao = new PedidoDAO();
UsuarioDAO udao = new UsuarioDAO();

ArrayList<Pedido> pedidos = pdao.listarPedidos();
ArrayList<Usuario> usuarios = udao.listarUsuarios();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Asignar Repartidor</title>
</head>

<body>

    <h1>ASIGNAR REPARTIDOR A PEDIDOS</h1>

    <table border="1">

        <tr>
            <th>ID Pedido</th>
            <th>Descripción</th>
            <th>Estado</th>
            <th>Repartidor</th>
            <th>Acción</th>
        </tr>

        <%
        for(Pedido p : pedidos)
        {
        %>

        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getDescripcion() %></td>
            <td><%= p.getEstado() %></td>

            <form action="AsignarServlet" method="POST">

                <td>
                    <input type="hidden" name="pedidoId" value="<%= p.getId() %>">

                    <select name="repartidorId">
                        <option value="0">-- Seleccionar --</option>

                        <%
                        for(Usuario u : usuarios)
                        {
                            if(u.getRol().equals("Repartidor"))
                            {
                        %>
                            <option value="<%= u.getId() %>">
                                <%= u.getNombre() %>
                            </option>
                        <%
                            }
                        }
                        %>

                    </select>
                </td>

                <td>
                    <input type="submit" value="Asignar">
                </td>

            </form>
        </tr>

        <%
        }
        %>

    </table>

    <br><br>

    <a href="admin.jsp">
        <button>Volver al menú</button>
    </a>

    <a href="logout.jsp">
        <button>Cerrar sesión</button>
    </a>
    
</body>
</html>
