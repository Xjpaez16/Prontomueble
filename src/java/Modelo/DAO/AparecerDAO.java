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
        String sql = "INSERT INTO aparecer (id_m, id_f, cant_muebles) VALUES (?, ?, ?)";
        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, aparecer.getId_m().getReferencia());
            stmt.setInt(2, aparecer.getId_f().getId());
            stmt.setInt(3, aparecer.getCant_muebles());
            stmt.executeUpdate();
            System.out.println("Registro de aparición insertado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar registro de aparición: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Aparecer> listarAparecer() {
        List<Aparecer> listaAparecer = new ArrayList<>();
        String sql = "SELECT * FROM aparecer";
        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Mueble mueble = new Mueble(rs.getLong("id_m"));
                Factura factura = new Factura(rs.getInt("id_f"));
                int cantMuebles = rs.getInt("cant_muebles");
                Aparecer aparecer = new Aparecer(mueble, factura, cantMuebles);
                listaAparecer.add(aparecer);
            }
        } catch (Exception e) {
            System.err.println("Error al listar registros de aparición: " + e.getMessage());
            e.printStackTrace();
        }
        return listaAparecer;
    }

    public void actualizarAparecer(Aparecer aparecer) {
        String sql = "UPDATE aparecer SET cant_muebles = ? WHERE id_m = ? AND id_f = ?";
        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, aparecer.getCant_muebles());
            stmt.setLong(2, aparecer.getId_m().getReferencia());
            stmt.setInt(3, aparecer.getId_f().getId());
            stmt.executeUpdate();
            System.out.println("Registro de aparición actualizado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar registro de aparición: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarAparecer(int idMueble, int idFactura) {
        String sql = "DELETE FROM aparecer WHERE id_m = ? AND id_f = ?";
        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idMueble);
            stmt.setInt(2, idFactura);
            stmt.executeUpdate();
            System.out.println("Registro de aparición eliminado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar registro de aparición: " + e.getMessage());
            e.printStackTrace();
        }
    }
}    
