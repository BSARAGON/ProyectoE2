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
    //Registra un nuevo usuario en el sistema.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
<<<<<<< HEAD
            throws ServletException, IOException 
    {
        // Datos del formulario    
=======
            throws ServletException, IOException {
        //Datos del formulario
>>>>>>> 0fdcbdc23e3b0624077b377a04cfdf332a96ce1b
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
<<<<<<< HEAD
        
        // Validación de campos obligatorios
=======

        //validacion de campos obligatorios
>>>>>>> 0fdcbdc23e3b0624077b377a04cfdf332a96ce1b
        if (nombre == null || nombre.trim().isEmpty() || correo == null || correo.trim().isEmpty() || password == null || password.trim().isEmpty())
        {
            response.getWriter().println("Datos inálidos");
            return;
        }
<<<<<<< HEAD
        
        // Creación del objeto usuario
        Usuario u = new Usuario(0, nombre, correo, password, rol);
        
        UsuarioDAO dao = new UsuarioDAO();
        // Registro en base de datos
=======
        //creacion del objeto usuario
        Usuario u = new Usuario(0, nombre, correo, password, rol);
        
        UsuarioDAO dao = new UsuarioDAO();
        //registro en base de datos
>>>>>>> 0fdcbdc23e3b0624077b377a04cfdf332a96ce1b
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
