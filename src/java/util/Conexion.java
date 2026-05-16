/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {

        Connection con = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
  
            String url = "jdbc:oracle:thin:@localhost:1521:xe";

            // Usuario de la base de datos
            String user = "USR_PROYECTO2";

            // Contraseña de la base de datos
            String pass = "P002";

            con = DriverManager.getConnection(url, user, pass);

            System.out.println("Conexión exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver de Oracle no encontrado");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
        }

        return con;
    }
}
