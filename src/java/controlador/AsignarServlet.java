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

@WebServlet("/AsignarServlet")

public class AsignarServlet extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        int repartidorId = Integer.parseInt(request.getParameter("repartidorId"));

        PedidoDAO dao = new PedidoDAO();

        dao.asignarRepartidor(pedidoId, repartidorId);

        response.sendRedirect("admin.jsp");
    }
}
