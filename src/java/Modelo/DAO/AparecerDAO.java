/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

/**
 *
 * @author ielcj
 */
import Config.Conexion;
import Modelo.DTO.Aparecer;
import Modelo.DTO.Factura;
import Modelo.DTO.Mueble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AparecerDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public void insertarAparecer(Aparecer aparecer) {
        String sql = "INSERT INTO aparecer (id_m, id_f, cantidad_muebles) VALUES (?, ?, ?)";
        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, aparecer.getId_m());
            stmt.setInt(2, aparecer.getId_f());
            stmt.setInt(3, aparecer.getCant_muebles());
            stmt.executeUpdate();
            System.out.println("Registro de aparición insertado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar registro de aparición: " + e.getMessage());
            e.printStackTrace();
        }
    }

}    
