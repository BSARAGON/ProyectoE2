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

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet 
{
    // Registra un nuevo usuario en el sistema.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {

        // Datos del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        // Validación de campos obligatorios
        if (nombre == null || nombre.trim().isEmpty()
                || correo == null || correo.trim().isEmpty()
                || password == null || password.trim().isEmpty())
        {
            response.getWriter().println("Datos inválidos");
            return;
        }

        // Creación del objeto usuario
        Usuario u = new Usuario(0, nombre, correo, password, rol);

        UsuarioDAO dao = new UsuarioDAO();

        // Registro en base de datos
        boolean registrado = dao.registrar(u);

        if (registrado)
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            response.getWriter().println("Error al registrar usuario");
        }
    }
}