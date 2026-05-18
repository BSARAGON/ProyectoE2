<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null || !"admin".equals(usuario.getRol()))
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
    <link rel="stylesheet" href="css/variables.css">
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/tablas.css">
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
            
            <form action="AsignarServlet" method="POST">
            
            <td><%= p.getId() %></td>
            <td><%= p.getDescripcion() %></td>
            <td><%= p.getEstado() %></td>

            <td>
                <input type="hidden" name="pedidoId" value="<%= p.getId() %>">

                <select name="repartidorId" required>
                    <option value="">-- Seleccionar --</option>

                    <%
                    for(Usuario u : usuarios)
                    {
                        if(u.getRol() != null && u.getRol().equalsIgnoreCase("repartidor"))
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
