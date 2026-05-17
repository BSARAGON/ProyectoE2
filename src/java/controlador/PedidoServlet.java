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
        
        HttpSession sesion = request.getSession(false);
        
        if (sesion == null)
        {
            response.sendRedirect("login.jsp");
            return;
        }
        
        try {
            int clienteId = Integer.parseInt(request.getParameter("clienteId"));

            String descripcion = request.getParameter("descripcion");
            String prioridad = request.getParameter("prioridad");
            
            if (descripcion == null || descripcion.trim().isEmpty())
            {
                response.getWriter().println("Descricpion invalida");
                return;
            }

            Pedido p = new Pedido(0, clienteId, descripcion, prioridad, "Pendiente", 0);

            cola.add(p);

            PedidoDAO dao = new PedidoDAO();
            dao.crearPedido(p);

            System.out.println("PEDIDO CREADO");

            response.sendRedirect("historial.jsp");
            
        } catch(Exception e)
        {
            e.printStackTrace();
            
            response.getWriter().println("ERROR AL CREAR PEDIDO");
        }
    }
}
