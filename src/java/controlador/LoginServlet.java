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
    // Valida credenciales del usuario y redirige según su rol.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {

        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        if (correo == null || password == null
                || correo.trim().isEmpty()
                || password.trim().isEmpty()) 
        {

            request.setAttribute("error", "Debe completar todos los campos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        correo = correo.trim().toLowerCase();
        password = password.trim();

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.login(correo, password);

        if (usuario == null) 
        {
            request.setAttribute("error", "Correo o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", usuario);

        String rol = usuario.getRol();

        if (rol == null) 
        {
            request.setAttribute("error", "Usuario sin rol asignado");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        rol = rol.trim().toLowerCase();

        switch (rol) 
        {

            case "admin":
                response.sendRedirect("admin.jsp");
                break;

            case "cliente":
                response.sendRedirect("cliente.jsp");
                break;

            case "repartidor":
                response.sendRedirect("repartidor.jsp");
                break;

            default:
                sesion.invalidate();
                request.setAttribute("error", "Rol no válido: " + rol);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }
}