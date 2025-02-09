/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.DTO.Proveedor;
import Modelo.DTO.TelefonoPr;
import java.util.ArrayList;
import java.util.List;


public class ProveedorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public void insertarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (id, nombre, direccion, persona_contacto) VALUES (?, ?, ?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setLong(1, proveedor.getId());
            stmt.setString(2, proveedor.getNombre());
            stmt.setString(3, proveedor.getDireccion());
            stmt.setString(4, proveedor.getP_contacto());

            stmt.executeUpdate();
            System.out.println("Proveedor insertado correctamente.");

            
            insertarTelefonos(proveedor);
        } catch (Exception e) {
            System.err.println("Error al insertar proveedor: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void insertarTelefonos(Proveedor proveedor) {
        String sql = "INSERT INTO telefono_pr (n_telefono, id_p) VALUES (?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            for (TelefonoPr telefono : proveedor.getTelefonos()) {
                stmt.setString(1, telefono.getnTelefono());
                stmt.setLong(2, proveedor.getId());
                stmt.executeUpdate();
            }

            System.out.println("Teléfonos insertados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar teléfonos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public List<Proveedor> ListaProveedores() {
        List<Proveedor> listaProveedores = new ArrayList<>();
        String sql = "SELECT p.id, p.nombre, p.direccion, p.persona_contacto, t.n_telefono "
                + "FROM proveedor p "
                + "LEFT JOIN telefono_pr t ON p.id = t.id_p";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            Proveedor proveedorActual = null;
            Long proveedorIdActual = null;

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String personaContacto = rs.getString("persona_contacto");
                String telefono = rs.getString("n_telefono");

               
                if (proveedorIdActual == null || !proveedorIdActual.equals(id)) {
                    proveedorActual = new Proveedor(id, nombre, direccion, personaContacto);
                    listaProveedores.add(proveedorActual);
                    proveedorIdActual = id;
                }

               
                if (telefono != null && proveedorActual != null) {
                    proveedorActual.aggTelefono(new TelefonoPr(telefono, proveedorActual));
                }
            }
        } catch (Exception e) {
            System.err.println("Error al obtener proveedores: " + e.getMessage());
            e.printStackTrace();
        }

        return listaProveedores;
    }
    public void actualizarProveedor(Proveedor proveedor) {
        String sqlProveedor = "UPDATE proveedor SET nombre = ?, direccion = ?, persona_contacto = ? WHERE id = ?";
        String sqlEliminarTelefonos = "DELETE FROM telefono_pr WHERE id_p = ?";
        String sqlInsertarTelefono = "INSERT INTO telefono_pr (n_telefono, id_p) VALUES (?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmtProveedor = con.prepareStatement(sqlProveedor); PreparedStatement stmtEliminarTelefonos = con.prepareStatement(sqlEliminarTelefonos); PreparedStatement stmtInsertarTelefono = con.prepareStatement(sqlInsertarTelefono)) {

            
            stmtProveedor.setString(1, proveedor.getNombre());
            stmtProveedor.setString(2, proveedor.getDireccion());
            stmtProveedor.setString(3, proveedor.getP_contacto());
            stmtProveedor.setLong(4, proveedor.getId());
            stmtProveedor.executeUpdate();

            
            stmtEliminarTelefonos.setLong(1, proveedor.getId());
            stmtEliminarTelefonos.executeUpdate();

            
            for (TelefonoPr telefono : proveedor.getTelefonos()) {
                stmtInsertarTelefono.setString(1, telefono.getnTelefono());
                stmtInsertarTelefono.setLong(2, proveedor.getId());
                stmtInsertarTelefono.executeUpdate();
            }

            System.out.println("Proveedor y teléfonos actualizados correctamente.");

        } catch (Exception e) {
            System.err.println("Error al actualizar proveedor: " + e.getMessage());
            e.printStackTrace();
        }
    }

   
    public void eliminarProveedor(Long id) {
        String sqlTelefonos = "DELETE FROM telefono_pr WHERE id_p = ?";
        String sqlProveedor = "DELETE FROM proveedor WHERE id = ?";

        try (Connection con = cn.Conexion(); PreparedStatement stmtTelefonos = con.prepareStatement(sqlTelefonos); PreparedStatement stmtProveedor = con.prepareStatement(sqlProveedor)) {

          
            stmtTelefonos.setLong(1, id);
            stmtTelefonos.executeUpdate();

          
            stmtProveedor.setLong(1, id);
            stmtProveedor.executeUpdate();

            System.out.println("Proveedor eliminado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar proveedor: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
