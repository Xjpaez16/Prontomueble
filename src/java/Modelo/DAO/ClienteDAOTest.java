package Modelo.DAO;

import Modelo.DAO.ClienteDAO;
import Modelo.DTO.Cliente;
import Modelo.DTO.TelefonoC;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOTest {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        // 1. Probar insertar cliente
        Cliente nuevoCliente = new Cliente(11L, "Juan Perez", "Av Principal 123", "juan@example.com", LocalDate.now());
        List<TelefonoC> telefonos = new ArrayList<>();
        telefonos.add(new TelefonoC("5551234", nuevoCliente));
        telefonos.add(new TelefonoC("5555678", nuevoCliente));
        nuevoCliente.setTelefonos(telefonos);

        System.out.println("Insertando cliente...");
        clienteDAO.insertarCliente(nuevoCliente);
        

        // 2. Probar listar clientes
        System.out.println("\nLista de clientes:");
        List<Cliente> clientes = clienteDAO.ListaClientes();
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre());
            System.out.println("Teléfonos:");
            for (TelefonoC t : c.getTelefonos()) {
                System.out.println(" - " + t.getnTelefono());
            }
        }

        // 3. Probar actualizar cliente
        nuevoCliente.setNombre("Juan Pérez Actualizado");
        nuevoCliente.getTelefonos().clear();
        nuevoCliente.getTelefonos().add(new TelefonoC("555-9999", nuevoCliente));

        System.out.println("\nActualizando cliente...");
        clienteDAO.actualizarCliente(nuevoCliente);

        // 4. Probar eliminar cliente
        System.out.println("\nEliminando cliente...");
        clienteDAO.eliminarCliente(nuevoCliente.getId());

        System.out.println("Pruebas finalizadas.");
    }
}
