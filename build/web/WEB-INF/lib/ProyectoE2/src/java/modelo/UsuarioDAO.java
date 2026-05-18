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
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"ID"});

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

        try 
        {
            Connection con = Conexion.getConexion();

            String sql = "SELECT * FROM USUARIOS WHERE CORREO = ? AND PASSWORD = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, correo.trim());
            ps.setString(2, password.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {
                u = new Usuario();

                u.setId(rs.getInt("ID"));
                u.setNombre(rs.getString("NOMBRE"));
                u.setCorreo(rs.getString("CORREO"));
                u.setPassword(rs.getString("PASSWORD"));
                u.setRol(rs.getString("ROL"));

                // opcional: guardar en estructuras
                tablaUsuarios.insertar(u.getId(), u);
            }

            rs.close();
            ps.close();
            con.close();

        } 
        catch (Exception e) 
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
            
            String sql = "SELECT * FROM USUARIOS";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Usuario u = new Usuario();
                
                u.setId(rs.getInt("ID"));
                u.setNombre(rs.getString("NOMBRE"));
                u.setCorreo(rs.getString("CORREO"));
                u.setRol(rs.getString("ROL"));
                
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
            
            String sql = "DELETE FROM USUARIOS WHERE ID=?";
            
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
