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
        String sql ="INSERT INTO usuarios(nombre, correo, password, rol) VALUES(?,?,?,?)";
        
        try {
            
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRol());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next())
            {
                int idGenerado = rs.getInt(1);
                u.setId(idGenerado);
            }
            
            tablaUsuarios.insertar(u.getId(), u);
            
            int posicion = tablaUsuarios.obtenerPosicion(u.getId());
            
            arbol.insertar(u.getId(), posicion);
            
            rs.close();
            ps.close();
            con.close();

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
                int id = rs.getInt("id");
                
                u = tablaUsuarios.obtener(id);
                
                if (u == null)
                {
                    u = new Usuario();

                    u.setId(id);
                    u.setNombre(rs.getString("nombre"));
                    u.setCorreo(rs.getString("correo"));
                    u.setPassword(rs.getString("password"));
                    u.setRol(rs.getString("rol"));
                    
                    tablaUsuarios.insertar(id, u);
                } 
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
            
            rs.close();
            ps.close();
            con.close();
            
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
            
            tablaUsuarios.eliminar(id);

            ps.close();
            con.close();
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
