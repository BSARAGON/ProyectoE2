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

//Servlet encargado de marcar un pedido como entregado.
@WebServlet("/EntregarServlet")   
public class EntregarServlet extends HttpServlet 
{
    //Marca un pedido como entregado.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // ID del pedido a actualizar
        int id = Integer.parseInt(request.getParameter("id"));
        
         // Acceso a datos de pedidos
        PedidoDAO dao = new PedidoDAO();
        // Cambia estado del pedido a "entregado"
        dao.marcarEntregado(id);
        
        // Regresa al panel del repartidor
        response.sendRedirect("repartidor.jsp");
    }
}
