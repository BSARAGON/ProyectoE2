/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Conexion;

public class PedidoDAO 
{
    
    public void crearPedido(Pedido p)
    {
        String sql = "INSERT INTO pedidos VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, p.getId());
            ps.setInt(2, p.getClienteId());
            ps.setString(3, p.getDescripcion());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getRepartidorId());
            ps.setInt(6, p.getRepartidorId());
            
            ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
