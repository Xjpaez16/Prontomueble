/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;
import Config.Conexion;
import Modelo.DTO.Vendedor;
import Modelo.DTO.TelefonoV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public void insertarVendedor(Vendedor vendedor) {
        String sql = "INSERT INTO vendedor (id, nombre, usuario, clave) VALUES (?, ?, ?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, vendedor.getId());
            stmt.setString(2, vendedor.getNombre());
            stmt.setString(3, vendedor.getUsuario());
            stmt.setString(4, vendedor.getClave());
            stmt.executeUpdate();

            insertarTelefonos(vendedor);
            System.out.println("Vendedor insertado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar vendedor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void insertarTelefonos(Vendedor vendedor) {
        String sql = "INSERT INTO telefono_v (telefono, id_v) VALUES (?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            for (TelefonoV telefono : vendedor.getTelefonos()) {
                stmt.setString(1, telefono.getnTelefono());
                stmt.setLong(2, vendedor.getId());
                stmt.executeUpdate();
            }
            System.out.println("Teléfonos insertados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar teléfonos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Vendedor> listarVendedores() {
        List<Vendedor> listaVendedores = new ArrayList<>();
        String sql = "SELECT v.id, v.nombre, v.usuario, v.clave, t.telefono "
                + "FROM vendedor v "
                + "LEFT JOIN telefono_v t ON v.id = t.id_v";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            Vendedor vendedorActual = null;
            Long vendedorIdActual = null;

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String usuario = rs.getString("usuario");
                String clave = rs.getString("clave");
                String telefono = rs.getString("telefono");

                if (vendedorIdActual == null || !vendedorIdActual.equals(id)) {
                    vendedorActual = new Vendedor(id, nombre, usuario, clave);
                    listaVendedores.add(vendedorActual);
                    vendedorIdActual = id;
                }

                if (telefono != null && vendedorActual != null) {
                    vendedorActual.aggTelefono(new TelefonoV(telefono, vendedorActual));
                }
            }
        } catch (Exception e) {
            System.err.println("Error al obtener vendedores: " + e.getMessage());
            e.printStackTrace();
        }

        return listaVendedores;
    }

    public void actualizarVendedor(Vendedor vendedor) {
        String sqlActualizarVendedor = "UPDATE vendedor SET nombre = ?, usuario = ?, clave = ? WHERE id = ?";
        String sqlEliminarTelefonos = "DELETE FROM telefono_v WHERE id_v = ?";
        String sqlInsertarTelefono = "INSERT INTO telefono_v (telefono, id_v) VALUES (?, ?)";

        try (Connection con = cn.Conexion()) {
            try (PreparedStatement stmtVendedor = con.prepareStatement(sqlActualizarVendedor)) {
                stmtVendedor.setString(1, vendedor.getNombre());
                stmtVendedor.setString(2, vendedor.getUsuario());
                stmtVendedor.setString(3, vendedor.getClave());
                stmtVendedor.setLong(4, vendedor.getId());
                stmtVendedor.executeUpdate();
            }

            try (PreparedStatement stmtEliminarTelefonos = con.prepareStatement(sqlEliminarTelefonos)) {
                stmtEliminarTelefonos.setLong(1, vendedor.getId());
                stmtEliminarTelefonos.executeUpdate();
            }

            try (PreparedStatement stmtInsertarTelefono = con.prepareStatement(sqlInsertarTelefono)) {
                for (TelefonoV telefono : vendedor.getTelefonos()) {
                    stmtInsertarTelefono.setString(1, telefono.getnTelefono());
                    stmtInsertarTelefono.setLong(2, vendedor.getId());
                    stmtInsertarTelefono.executeUpdate();
                }
            }

            System.out.println("Vendedor y teléfonos actualizados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar vendedor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarVendedor(Long id) {
        String sqlTelefonos = "DELETE FROM telefono_v WHERE id_v = ?";
        String sqlVendedor = "DELETE FROM vendedor WHERE id = ?";

        try (Connection con = cn.Conexion(); PreparedStatement stmtTelefonos = con.prepareStatement(sqlTelefonos); PreparedStatement stmtVendedor = con.prepareStatement(sqlVendedor)) {
            stmtTelefonos.setLong(1, id);
            stmtTelefonos.executeUpdate();

            stmtVendedor.setLong(1, id);
            stmtVendedor.executeUpdate();

            System.out.println("Vendedor eliminado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar vendedor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
