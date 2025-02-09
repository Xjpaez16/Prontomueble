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
    String pass="1010";
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
    private Connection con1;
    private final String url1 = "jdbc:mysql://localhost:3306/prontomueble";
    private final String user1 = "root";
    private final String pass1 = "juancho16";

    public Connection Conexion1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection(url1, user1, pass1);
            System.out.println("SE CONECTÓ A LA BASE DE DATOS");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión a la BD:");
            e.printStackTrace();
        }
        return con1;
    }
}
