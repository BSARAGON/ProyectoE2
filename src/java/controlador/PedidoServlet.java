/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author berna
 */

import modelo.Pedido;
import modelo.PedidoDAO;

import java.util.PriorityQueue;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/PedidoServlet")
public class PedidoServlet extends HttpServlet {
    
    PriorityQueue<Pedido> cola = new PriorityQueue<>((a, b) -> 
    {
        int prioridadA = obtenerValor(a.getPrioridad());
        int prioridadB = obtenerValor(b.getPrioridad());
        
        return prioridadA - prioridadB;
    });
    
    private static int obtenerValor(String prioridad)
    {
        if (prioridad.equals("Alta"))
        {
            return 1;
        }
        
        if (prioridad.equals("Media"))
        {
            return 2;
        }
        
        return 3;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int clienteId = Integer.parseInt(request.getParameter("clienteId"));
        
        String descripcion = request.getParameter("descripcion");
        String prioridad = request.getParameter("prioridad");
        
        Pedido p = new Pedido(id, clienteId, descripcion, prioridad, "Pendiente", 0);
        
        cola.add(p);
        
        PedidoDAO dao = new PedidoDAO();
        dao.crearPedido(p);
        
        response.sendRedirect("cliente.jsp");
    }
}
