<%@page import="modelo.Usuario"%>

<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if(usuario == null || usuario.getRol().equals("Admin"))
{
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Asignar Repartidor</title>
</head>

<body>

    <h1>ASIGNAR REPARTIDOR</h1>

    <form action="AsignarServlet" method="POST">

        ID Pedido:
        <input type="number" name="pedidoId">
        <br><br>

        ID Repartidor:
        <input type="number" name="repartidorId">
        <br><br>

        <input type="submit" value="Asignar">

    </form>
    
    <br><br>

    <a href="admin.jsp">Regresar</a>

    <br><br>

    <a href="logout.jsp">Cerrar Sesión</a>
    
</body>
</html>
