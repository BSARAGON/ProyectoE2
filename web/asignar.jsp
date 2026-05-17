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
    <title>Asignar</title>
</head>
<body>

    <h1>Asignar Repartidor</h1>

    <form action="AsignarServlet" method="POST">

        ID Pedido:
        <input type="number" name="pedidoId">
        <br><br>

        ID Repartidor:
        <input type="number" name="repartidorId">
        <br><br>

        <input type="submit" value="Asignar">

    </form>
</body>
</html>
