/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author berna
 */

import modelo.Usuario;
import modelo.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
    //Valida credenciales del usuario y redirige según su rol.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
         // Datos ingresados en el login
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        UsuarioDAO dao = new UsuarioDAO();
        
        // Verifica credenciales en la base de datos
        Usuario usuario = dao.login(correo, password);
        
        if (usuario != null)
        {
            // Creación de sesión si el login es correcto
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            
            // Redirección según el rol del usuario
            switch (usuario.getRol()) 
            {
                case "Admin":
                    response.sendRedirect("admin.jsp");
                    break;
                case "Cliente":
                    response.sendRedirect("cliente.jsp");
                    break;
                case "Repartidor":
                    response.sendRedirect("repartidor.jsp");
                    break;
                default:
                    break;
            }
        } 
        else
        {
            // Error de autenticación
            request.setAttribute("error", "Correo o contraseña incorrecto");
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}