<%@page import="modelo.Usuario"%>
<%
if(session.getAttribute("usuario") == null)
{
    response.sendRedirect("login.jsp");
    return;
}

Usuario u = (Usuario) session.getAttribute("usuario");

if(!u.getRol().equals("Admin"))
{
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>
    Asignar Repartidor
    </title>
</head>
<body>

    <h1>
    Asignar Repartidor
    </h1>

    <form action="AsignarServlet" method="POST">

        ID Pedido:
        <input type="number" name="pedidoId">
        <br><br>

        ID Repartidor:
        <input type="number" name="repartidorId">
        <br><br>

        <input type="submit" value="Asignar">

    </form>
    <br>

    <a href="admin.jsp">Volver</a>

</body>
</html>
