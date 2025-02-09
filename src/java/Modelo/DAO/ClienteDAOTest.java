package Modelo.DAO;

import Modelo.DAO.ClienteDAO;
import Modelo.DTO.Cliente;
import Modelo.DTO.Proveedor;
import Modelo.DTO.TelefonoC;
import Modelo.DTO.TelefonoPr;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOTest {
    public static void main(String[] args) {
        ProveedorDAO proveedorDAO = new ProveedorDAO();

        // 1. Probar insertar proveedor
        Proveedor nuevoProveedor = new Proveedor(16L, "Proveedor Test", "Av Principal 123", "Pedro Gómez");
        List<TelefonoPr> telefonos = new ArrayList<>();
        telefonos.add(new TelefonoPr("5551234", nuevoProveedor));
        telefonos.add(new TelefonoPr("5555678", nuevoProveedor));
        nuevoProveedor.setTelefonos(telefonos);

        System.out.println("Insertando proveedor...");
        proveedorDAO.insertarProveedor(nuevoProveedor);
        
        // 2. Probar listar proveedores
        System.out.println("\nLista de proveedores:");
        List<Proveedor> proveedores = proveedorDAO.ListaProveedores();
        for (Proveedor p : proveedores) {
            System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre());
            System.out.println("Teléfonos:");
            for (TelefonoPr t : p.getTelefonos()) {
                System.out.println(" - " + t.getnTelefono());
            }
        }

        // 3. Probar actualizar proveedor
        nuevoProveedor.setNombre("Proveedor Test Actualizado");
        nuevoProveedor.getTelefonos().clear();
        nuevoProveedor.getTelefonos().add(new TelefonoPr("555-9999", nuevoProveedor));

        System.out.println("\nActualizando proveedor...");
        proveedorDAO.actualizarProveedor(nuevoProveedor);

        // 4. Probar eliminar proveedor
        System.out.println("\nEliminando proveedor...");
        proveedorDAO.eliminarProveedor(nuevoProveedor.getId());

        System.out.println("Pruebas finalizadas.");
    }

    
}

