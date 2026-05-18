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
    
    //Cola de prioridad para manejar pedidos según su urgencia.
    PriorityQueue<Pedido> cola = new PriorityQueue<>((a, b) -> 
    {
        int prioridadA = obtenerValor(a.getPrioridad());
        int prioridadB = obtenerValor(b.getPrioridad());
        
        return prioridadA - prioridadB;
    });
    
    //Convierte la prioridad textual en valor numérico.
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
    
    //Crea un nuevo pedido y lo guarda en la base de datos.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession(false);
        
        // Verificación de sesión activa
        if (sesion == null)
        {
            response.sendRedirect("login.jsp");
            return;
        }
        
        try 
        {
            // Datos del pedido
            int clienteId = Integer.parseInt(request.getParameter("clienteId"));

            String descripcion = request.getParameter("descripcion");
            String prioridad = request.getParameter("prioridad");
            
            // Validación básica
            if (descripcion == null || descripcion.trim().isEmpty())
            {
                response.getWriter().println("Descricpion invalida");
                return;
            }
            
            // Creación del objeto pedido
            Pedido p = new Pedido(0, clienteId, descripcion, prioridad, "Pendiente", 0);
            
            // Se agrega a la cola de prioridad
            cola.add(p);
            
            // Guardado en base de datos
            PedidoDAO dao = new PedidoDAO();
            dao.crearPedido(p);

            System.out.println("PEDIDO CREADO");

            response.sendRedirect("historial.jsp");
            
        } 
        catch(Exception e)
        {
            e.printStackTrace();
            
            response.getWriter().println("ERROR AL CREAR PEDIDO");
        }
    }
}
