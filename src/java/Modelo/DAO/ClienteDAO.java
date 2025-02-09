/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Config.Conexion;
import Modelo.DTO.Cliente;
import Modelo.DTO.TelefonoC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ielcj
 */
public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public void insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (id, nombre, direccion, correo, fecha_registro) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, cliente.getId());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getCorreo());
            stmt.setDate(5,cliente.getFecha_registro());

            stmt.executeUpdate();
            System.out.println("Cliente insertado correctamente.");

            insertarTelefonos(cliente);

        } catch (Exception e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void insertarTelefonos(Cliente cliente) {
        String sql = "INSERT INTO telefono_c (n_telefono, id_c) VALUES (?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            for (TelefonoC telefono : cliente.getTelefonos()) {
                stmt.setString(1, telefono.getnTelefono());
                stmt.setLong(2, cliente.getId());
                stmt.executeUpdate();
            }

            System.out.println("Teléfonos insertados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar teléfonos: " + e.getMessage());
            e.printStackTrace();
        }
    }




    public List<Cliente> ListaClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT c.*, t.n_telefono "
                + "FROM Cliente c "
                + "LEFT JOIN telefono_c t ON c.id = t.id_c";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            Cliente clienteActual = null;
            Long clienteIdActual = null;

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String correo = rs.getString("correo");
                LocalDate fechaRegistro = rs.getDate("fecha_registro").toLocalDate();
                String telefono = rs.getString("n_telefono");

                if (clienteIdActual == null || !clienteIdActual.equals(id)) {
                    clienteActual = new Cliente(id, nombre, direccion, correo, Date.valueOf(fechaRegistro));
                    listaClientes.add(clienteActual);
                    clienteIdActual = id;
                }

                if (telefono != null && clienteActual != null) {
                    clienteActual.aggTelefono(new TelefonoC(telefono, clienteActual));
                }
            }
            /*
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getLong(1));
                cl.setNombre(rs.getString(2));
                cl.setDireccion(rs.getString(3));
                cl.setCorreo(rs.getString(4));
                cl.setFecha_registro(rs.getDate(5));
                listaClientes.add(cl);
            }
            */
        } catch (Exception e) {
            System.err.println("Error al obtener clientes: " + e.getMessage());
            e.printStackTrace();
        }

        return listaClientes;
    }

    public void actualizarCliente(Cliente cliente) {
        String sqlActualizarCliente = "UPDATE cliente SET nombre = ?, direccion = ?, correo = ?, fecha_registro = ? WHERE id = ?";
        String sqlEliminarTelefonos = "DELETE FROM telefono_c WHERE id_c = ?";
        String sqlInsertarTelefono = "INSERT INTO telefono_c (n_telefono, id_c) VALUES (?, ?)";

        try (Connection con = cn.Conexion()) {
           

            try (PreparedStatement stmtCliente = con.prepareStatement(sqlActualizarCliente)) {
                stmtCliente.setString(1, cliente.getNombre());
                stmtCliente.setString(2, cliente.getDireccion());
                stmtCliente.setString(3, cliente.getCorreo());
                stmtCliente.setDate(4, cliente.getFecha_registro());

                stmtCliente.setLong(5, cliente.getId());
                stmtCliente.executeUpdate();
            }

            try (PreparedStatement stmtEliminarTelefonos = con.prepareStatement(sqlEliminarTelefonos)) {
                stmtEliminarTelefonos.setLong(1, cliente.getId());
                stmtEliminarTelefonos.executeUpdate();
            }

            try (PreparedStatement stmtInsertarTelefono = con.prepareStatement(sqlInsertarTelefono)) {
                for (TelefonoC telefono : cliente.getTelefonos()) {
                    stmtInsertarTelefono.setString(1, telefono.getnTelefono());
                    stmtInsertarTelefono.setLong(2, cliente.getId());
                    stmtInsertarTelefono.executeUpdate();
                }
            }

        
            System.out.println("Cliente y teléfonos actualizados correctamente.");

        } catch (Exception e) {
            System.err.println( "Error al actualizar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarCliente(Long id) {
        String sqlTelefonos = "DELETE FROM telefono_c WHERE id_c = ?";
        String sqlCliente = "DELETE FROM cliente WHERE id = ?";

        try (Connection con = cn.Conexion(); PreparedStatement stmtTelefonos = con.prepareStatement(sqlTelefonos); PreparedStatement stmtCliente = con.prepareStatement(sqlCliente)) {

            stmtTelefonos.setLong(1, id);
            stmtTelefonos.executeUpdate();

            stmtCliente.setLong(1, id);
            stmtCliente.executeUpdate();

            System.out.println("Cliente eliminado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
