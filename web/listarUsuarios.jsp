<%-- 
    Document   : listarUsuarios
    Created on : 16/05/2026, 11:10:43 p. m.
    Author     : berna
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
UsuarioDAO dao = new UsuarioDAO();
ArrayList<Usuario> lista = dao.listarUsuarios();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
        <h1>LISTA DE USUARIOS</h1>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Rol</th>
                <th>Eliminar</th>
            </tr>
            
            <%
            for(Usuario u : lista)
            {
            %>
            <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getNombre() %></td>
                <td><%= u.getCorreo() %></td>
                <td><%= u.getRol() %></td>
                <td>
                    <form action="EliminarUsuarioServlet" method="POST">
                        <input type="hidden" name="id" value="<%= u.getId() %>">
                        <input type="submit" value="Eliminar">
                    </form>
                </td>
            </tr>
            
            <%
            }
            %>
        </table>
    </body>
</html>
