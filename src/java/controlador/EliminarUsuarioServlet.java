/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

//Servlet encargado de eliminar usuarios del sistema.
@WebServlet("/EliminarUsuarioServlet")    
public class EliminarUsuarioServlet extends HttpServlet 
{
    //Procesa la eliminación de un usuario mediante su ID.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // Se obtiene el ID del usuario a eliminar
        int id = Integer.parseInt(request.getParameter("id"));
        
         // Acceso a la capa de datos de usuarios
        UsuarioDAO dao = new UsuarioDAO();
        // Eliminación del usuario
        dao.eliminar(id);
        
        // Redirección a la lista de usuarios
        response.sendRedirect("listarUsuarios.jsp");
    }
}
