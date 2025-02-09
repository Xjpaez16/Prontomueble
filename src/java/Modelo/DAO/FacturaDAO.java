/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Config.Conexion;
import Modelo.DTO.Cliente;
import Modelo.DTO.Factura;
import Modelo.DTO.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public void insertarFactura(Factura factura) {
        String sql = "INSERT INTO factura (id, precio, id_v, id_c, fecha_venta) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, factura.getId());
            stmt.setLong(2, factura.getPrecio());
            stmt.setLong(3, factura.getId_v().getId());
            stmt.setLong(4, factura.getId_c().getId());
            stmt.setDate(5, java.sql.Date.valueOf(factura.getFecha_venta()));

            stmt.executeUpdate();
            System.out.println("Factura insertada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar factura: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Factura> listarFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();
        String sql = "SELECT * FROM factura";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Long precio = rs.getLong("precio");
                Long idVendedor = rs.getLong("id_v");
                Long idCliente = rs.getLong("id_c");
                LocalDate fechaVenta = rs.getDate("fecha_venta").toLocalDate();

                Vendedor vendedor = new Vendedor(idVendedor);
                Cliente cliente = new Cliente(idCliente);

                Factura factura = new Factura(id, precio, vendedor, cliente, fechaVenta);
                listaFacturas.add(factura);
            }
        } catch (Exception e) {
            System.err.println("Error al listar facturas: " + e.getMessage());
            e.printStackTrace();
        }
        return listaFacturas;
    }

    public void actualizarFactura(Factura factura) {
        String sql = "UPDATE factura SET precio = ?, id_v = ?, id_c = ?, fecha_venta = ? WHERE id = ?";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, factura.getPrecio());
            stmt.setLong(2, factura.getId_v().getId());
            stmt.setLong(3, factura.getId_c().getId());
            stmt.setDate(4, java.sql.Date.valueOf(factura.getFecha_venta()));
            stmt.setInt(5, factura.getId());

            stmt.executeUpdate();
            System.out.println("Factura actualizada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar factura: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarFactura(int id) {
        String sql = "DELETE FROM factura WHERE id = ?";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Factura eliminada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar factura: " + e.getMessage());
            e.printStackTrace();
        }
    }
  
}
