/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Config.Conexion;
import Modelo.DTO.Cliente;
import Modelo.DTO.Factura;
import Modelo.DTO.TelefonoC;
import Modelo.DTO.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class FacturaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public void insertarFactura(Factura factura) {
        String sql = "INSERT INTO factura (precio, id_v, id_c, fecha_venta) VALUES (?, ?, ?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
      
            stmt.setLong(1, factura.getPrecio());
            stmt.setLong(2, factura.getId_v());
            stmt.setLong(3, factura.getId_c());
            stmt.setDate(4, factura.getFecha_venta());

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
                Date fechaVenta = rs.getDate("fecha_venta");

       

                Factura factura = new Factura(id, precio, idVendedor, idCliente, fechaVenta);
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
            stmt.setLong(2, factura.getId_v());
            stmt.setLong(3, factura.getId_c());
            stmt.setDate(4, (factura.getFecha_venta()));
            stmt.setInt(5, factura.getId());

            stmt.executeUpdate();
            System.out.println("Factura actualizada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar factura: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public Cliente listarId(Long id) {
        Cliente cli = null;
        String sql = "SELECT nombre FROM cliente WHERE id =" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (cli == null) {
                    cli = new Cliente();
                    cli.setId(rs.getLong("id"));
                    cli.setNombre(rs.getString("nombre"));
                }

                
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al listar cliente por ID: " + e);
        }

        return cli;
    }
    public int listarfac() {
        
        String sql = "SELECT MAX(id) FROM factura";
        int id_f=0;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
              
                id_f=rs.getInt("max");

                
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al listar factura por ID maximo: " + e);
        }

        return id_f;
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
    
    public List<Factura> getFacturasPorFecha(Date fechaInicio, Date fechaFin) {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT * FROM facturas_por_fecha WHERE fecha_venta BETWEEN ? AND ?";

        // Establecer conexión
        try (Connection con = cn.Conexion(); // Aquí asumo que cn.Conexion() es tu método de conexión
                 PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDate(1, fechaInicio);
            stmt.setDate(2, fechaFin);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Factura factura = new Factura();
                factura.setId(rs.getInt("id_factura"));
                factura.setPrecio(rs.getLong("precio"));
                factura.setId_v(rs.getLong("id_vendedor"));
                factura.setId_c(rs.getLong("id_cliente"));
                factura.setFecha_venta(rs.getDate("fecha_venta"));

                // Obtener el id_mueble como referencia (puedes ajustarlo si lo necesitas como otro tipo)
                String referencia = String.valueOf(rs.getLong("id_mueble"));
                int cantidadMuebles = rs.getInt("cantidad_muebles");

                // Aquí asumo que tienes una lista de referencias y cantidades en tu objeto Factura
                factura.getReferencias().add(referencia);
                factura.getCantidades().add(cantidadMuebles);

                // Añadir la factura a la lista
                facturas.add(factura);
            }

            // Cerrar el ResultSet (aunque con try-with-resources esto ya se maneja automáticamente)
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return facturas;
    }

  
}
