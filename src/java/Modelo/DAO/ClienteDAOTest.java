package Modelo.DAO;

import Modelo.DAO.ClienteDAO;
import Modelo.DTO.Aparecer;
import Modelo.DTO.Cliente;
import Modelo.DTO.Factura;
import Modelo.DTO.Mueble;
import Modelo.DTO.Proveedor;
import Modelo.DTO.TelefonoC;
import Modelo.DTO.TelefonoPr;
import Modelo.DTO.Vendedor;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOTest {

    public static void main(String[] args) {
         AparecerDAO aparecerDAO = new AparecerDAO();

        // 1. Insertar un nuevo registro en "aparecer"
        Mueble mueble = new Mueble(108L); // ID del mueble existente
        Factura factura = new Factura(14); // ID de la factura existente
        Aparecer nuevoAparecer = new Aparecer(mueble, factura, 1); // Cantidad de muebles en la factura

        System.out.println("Insertando registro en 'aparecer'...");
        aparecerDAO.insertarAparecer(nuevoAparecer);

        // 2. Listar registros en "aparecer"
        System.out.println("\nLista de registros en 'aparecer':");
        List<Aparecer> listaAparecer = aparecerDAO.listarAparecer();
        for (Aparecer a : listaAparecer) {
            System.out.println("Mueble ID: " + a.getId_m().getReferencia() +
                               ", Factura ID: " + a.getId_f().getId() +
                               ", Cantidad: " + a.getCant_muebles());
        }

        // 3. Actualizar cantidad de muebles en "aparecer"
        nuevoAparecer.setCant_muebles(7);
        System.out.println("\nActualizando cantidad en 'aparecer'...");
        aparecerDAO.actualizarAparecer(nuevoAparecer);

       // 4. Eliminar el registro de "aparecer"
        System.out.println("\nEliminando registro en 'aparecer'...");
        aparecerDAO.eliminarAparecer(nuevoAparecer.getId_m().getReferencia().intValue(),  nuevoAparecer.getId_f().getId());
        System.out.println("\nPruebas finalizadas.");
    }
}

