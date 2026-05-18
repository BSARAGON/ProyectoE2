/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.PedidoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

//Servlet encargado de asignar un repartidor a un pedido. Recibe el ID del pedido y el ID del repartidor desde el formulario.
 
@WebServlet("/AsignarServlet")
public class AsignarServlet extends HttpServlet 
{
    // Maneja la petición POST para asignar un repartidor a un pedido.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // Se obtienen los parámetros enviados desde la vista
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        int repartidorId = Integer.parseInt(request.getParameter("repartidorId"));
        
        // Se crea acceso a la capa de datos
        PedidoDAO dao = new PedidoDAO();
        // Se asigna el repartidor al pedido
        dao.asignarRepartidor(pedidoId, repartidorId);

        // Redirección al panel de administrador
        response.sendRedirect("admin.jsp");
    }
}
