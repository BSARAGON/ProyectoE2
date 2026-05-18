/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Conexion;
import java.util.ArrayList;

public class PedidoDAO 
{
    
    public void crearPedido(Pedido p)
    {
        String sql = "INSERT INTO pedidos(cliente_id, descripcion, prioridad, estado, repartidor_id) VALUES(?, ?, ?, ?, ?)";
        
        try {
            
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, p.getClienteId());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getPrioridad());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getRepartidorId());
            
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
            System.out.println("PEDIDO GUARDADO");
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Pedido> listarPedidos()
    {
        ArrayList<Pedido> lista = new ArrayList<>();
        
        try {
            
            Connection con = Conexion.getConexion();
            
            String sql = "SELECT * FROM pedidos ORDER BY CASE prioridad WHEN 'Alta' THEN 1 WHEN 'Media' THEN 2 ELSE 3 END";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Pedido p = new Pedido();
                
                p.setId(rs.getInt("id"));
                p.setClienteId(rs.getInt("cliente_id"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrioridad(rs.getString("prioridad"));
                p.setEstado(rs.getString("estado"));
                p.setRepartidorId(rs.getInt("repartidor_id"));
                
                lista.add(p);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<Pedido> listarPorCliente(int clienteId)
    {
        ArrayList<Pedido> lista = new ArrayList<>();

        try
        {
            Connection con = Conexion.getConexion();

            String sql = "SELECT * FROM pedidos WHERE cliente_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, clienteId);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Pedido p = new Pedido();

                p.setId(rs.getInt("id"));
                p.setClienteId(rs.getInt("cliente_id"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrioridad(rs.getString("prioridad"));
                p.setEstado(rs.getString("estado"));
                p.setRepartidorId(rs.getInt("repartidor_id"));

                lista.add(p);
            }

            rs.close();
            ps.close();
            con.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return lista;
    }
    
    public void asignarRepartidor(int pedidoId, int repartidorId)
    {
        try {
            
            Connection con = Conexion.getConexion();
            
            String sql = "UPDATE pedidos SET repartidor_id=?, estado='Asignado' WHERE id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, repartidorId);
            ps.setInt(2, pedidoId);
            
            ps.executeUpdate();

            ps.close();
            con.close();
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void marcarEntregado(int id)
    {
        try {
            
            Connection con = Conexion.getConexion();
            
            String sql = "UPDATE pedidos SET estado='Entregado' WHERE id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
