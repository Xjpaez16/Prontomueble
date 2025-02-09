/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ielcj
 */
public class Conexion {
    Connection con;
    String url="jdbc:postgresql://localhost:5432/prontomueble";
    String user="postgres";
    String pass="juancho16";
    public Connection Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection(url,user,pass);
            System.out.println("SE CONECTO");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error conexion BD:"+e);
        }
        return con;
    }
}
