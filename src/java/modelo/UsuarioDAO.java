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

public class UsuarioDAO {
    
    public static TablaHashGen<Integer, Usuario> tablaUsuarios = new TablaHashGen<>(20);
    
    public static ArbolMulticamino arbol = new ArbolMulticamino();
    
    public boolean registrar(Usuario u) 
    {
        String sql ="INSERT INTO usuarios VALUES(?,?,?,?,?)";
        
        try {
            
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, u.getId());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getRol());
            
            ps.executeUpdate();
            
            tablaUsuarios.insertar(u.getId(), u);
            int posicion = tablaUsuarios.obtenerPosicion(u.getId());
            arbol.insertar(u.getId(), posicion);

            return true;
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return false;
    }

    public Usuario login(String correo, String password) 
    {
        Usuario u = null;

        try {
            
            Connection con = Conexion.getConexion();

            String sql =  "SELECT * FROM usuarios WHERE correo=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, correo);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {
                u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));
                u.setRol(rs.getString("rol"));
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        }

        return u;
    }
    
    public ArrayList<Usuario> listarUsuarios()
    {
        ArrayList<Usuario> lista = new ArrayList<>();
        
        try {
            
            Connection con = Conexion.getConexion();
            
            String sql = "SELECT * FROM usuarios";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Usuario u = new Usuario();
                
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setRol(rs.getString("rol"));
                
                lista.add(u);
            }
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public void eliminar(int id)
    {
        try {
            
            Connection con = Conexion.getConexion();
            
            String sql = "DELETE FROM usuarios WHERE id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
