<%-- 
    Document   : cliente
    Created on : 13/05/2026, 10:06:16 p. m.
    Author     : berna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
            ID Cliente: <input type="number" name="clienteId">
            <br><br>
            
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
    </body>
</html>
