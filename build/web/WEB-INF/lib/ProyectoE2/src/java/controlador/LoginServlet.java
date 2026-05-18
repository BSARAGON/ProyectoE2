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
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        UsuarioDAO dao = new UsuarioDAO();
        
        Usuario usuario = dao.login(correo, password);
        
        if (usuario != null)
        {
            
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            
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
        } else
        {
            request.setAttribute("error", "Correo o contraseña incorrecto");
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}