/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Config.Conexion;
import Modelo.DTO.Mueble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ielcj
 */
public class MuebleDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public void consultaMueblesMayoresCompras() {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT m.referencia, m.nombre, SUM(cantidad_muebles) AS mas_vendidos "
                + "FROM aparecer a "
                + "    JOIN mueble m ON(a.id_m = m.referencia) "
                + "GROUP BY m.referencia, m.nombre "
                + "ORDER BY mas_vendidos DESC "
                + "LIMIT 3";

        try (Connection con = cn.Conexion(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("referencia");
                String nombre = rs.getString("nombre");
                Long mas_vendidos = rs.getLong("mas_vendidos");

                Object[] datosMuebles = {id, nombre, mas_vendidos};
                lista.add(datosMuebles);
            }

            for (Object[] datos : lista) {
                int id = (int) datos[0];
                String nombre = (String) datos[1];
                Long mas_vendidos = (Long) datos[2];

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Mas vendidos: " + mas_vendidos);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public List<Mueble> listar() {
        List<Mueble> lista = new ArrayList<>();
        String sql = "SELECT m.referencia, m.nombre, t.t_mueble, m.alto_d, m.ancho_d, m.profundidad_d, "
                + "mat.nom_material, c.n_color, m.precio, m.cantidad, m.url "
                + "FROM mueble m "
                + "JOIN tipo t ON m.id_tipo = t.id "
                + "JOIN material mat ON m.id_material = mat.id "
                + "JOIN color c ON m.id_color = c.id";

        try (Connection con = cn.Conexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mueble mueble = new Mueble(
                        rs.getLong("referencia"),
                        rs.getString("nombre"),
                        rs.getString("t_mueble"),
                        rs.getDouble("alto_d"),
                        rs.getDouble("ancho_d"),
                        rs.getDouble("profundidad_d"),
                        rs.getString("nom_material"),
                        rs.getString("n_color"),
                        rs.getLong("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("url")
                );
                lista.add(mueble);
            }
        } catch (Exception e) {
            System.err.println("Error al listar muebles: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertar(Mueble mueble) {
        String sql = "INSERT INTO mueble (referencia, nombre, id_tipo, alto_d, ancho_d, profundidad_d, "
                + "id_material, id_color, precio, cantidad, url) "
                + "VALUES (?, ?, (SELECT id FROM tipo WHERE t_mueble = ?), ?, ?, ?, "
                + "(SELECT id FROM material WHERE nom_material = ?), "
                + "(SELECT id FROM color WHERE n_color = ?), ?, ?, ?)";

        try (Connection con = cn.Conexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, mueble.getReferencia());
            ps.setString(2, mueble.getNombre());
            ps.setString(3, mueble.getTipo());
            ps.setDouble(4, mueble.getAlto());
            ps.setDouble(5, mueble.getAncho());
            ps.setDouble(6, mueble.getProfundidad());
            ps.setString(7, mueble.getMaterial());
            ps.setString(8, mueble.getColor());
            ps.setLong(9, mueble.getPrecio());
            ps.setInt(10, mueble.getCantidad());
            ps.setString(11, mueble.getUrl());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al insertar mueble: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Mueble mueble) {
        String sql = "UPDATE mueble SET nombre = ?, id_tipo = (SELECT id FROM tipo WHERE t_mueble = ?), "
                + "alto_d = ?, ancho_d = ?, profundidad_d = ?, "
                + "id_material = (SELECT id FROM material WHERE nom_material = ?), "
                + "id_color = (SELECT id FROM color WHERE n_color = ?), "
                + "precio = ?, cantidad = ?, url = ? WHERE referencia = ?";

        try (Connection con = cn.Conexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mueble.getNombre());
            ps.setString(2, mueble.getTipo());
            ps.setDouble(3, mueble.getAlto());
            ps.setDouble(4, mueble.getAncho());
            ps.setDouble(5, mueble.getProfundidad());
            ps.setString(6, mueble.getMaterial());
            ps.setString(7, mueble.getColor());
            ps.setLong(8, mueble.getPrecio());
            ps.setInt(9, mueble.getCantidad());
            ps.setString(10, mueble.getUrl());
            ps.setLong(11, mueble.getReferencia());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al actualizar mueble: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(Long referencia) {
        String sql = "DELETE FROM mueble WHERE referencia = ?";

        try (Connection con = cn.Conexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, referencia);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al eliminar mueble: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
