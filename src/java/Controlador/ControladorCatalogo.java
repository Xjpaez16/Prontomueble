/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.DAO.AparecerDAO;
import Modelo.DAO.ClienteDAO;
import Modelo.DAO.FacturaDAO;
import Modelo.DAO.MuebleDAO;
import Modelo.DAO.ProveedorDAO;
import Modelo.DAO.VendedorDAO;
import Modelo.DTO.Aparecer;
import Modelo.DTO.Cliente;
import Modelo.DTO.Factura;
import Modelo.DTO.Mueble;
import Modelo.DTO.Proveedor;
import Modelo.DTO.TelefonoC;
import Modelo.DTO.TelefonoPr;
import Modelo.DTO.TelefonoV;
import Modelo.DTO.Vendedor;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ielcj
 */
@WebServlet(name = "ControladorCatalogo", urlPatterns = {"/Catalogo"})
public class ControladorCatalogo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");
       
        
        if (menu.equals("Cliente")) {
            ClienteDAO cdao = new ClienteDAO();

            if (accion == null) {
                accion = "Listar"; // Acción por defecto
            }

            switch (accion) {
                case "Listar": {
                    List<Cliente> lista = cdao.ListaClientes();
                   
                    request.setAttribute("listaClientes", lista);
                    
                    break;
                }
                case "Agregar":{
                    Cliente c = new Cliente();
                    Long id = Long.parseLong(request.getParameter("txtId"));
                    String nom = request.getParameter("txtNombre");
                    String dirc = request.getParameter("txtDireccion");
                    String corr = request.getParameter("txtCorreo");
                    Date f_registro = Date.valueOf(request.getParameter("txtFechaRegistro"));
                    c.setId(id);
                    c.setNombre(nom);
                    c.setDireccion(dirc);
                    c.setCorreo(corr);
                    c.setFecha_registro(f_registro);
                    String[] telefonosArray = request.getParameterValues("txtTelefono");
                    List<TelefonoC> listaTelefonos = new ArrayList<>();
                    if (telefonosArray != null) {
                        for (String numTelefono : telefonosArray) {
                            if (numTelefono != null && !numTelefono.trim().isEmpty()) {
                                listaTelefonos.add(new TelefonoC(numTelefono, c));
                            }
                        }

                    }
                    c.setTelefonos(listaTelefonos);
                    cdao.insertarCliente(c);

                    response.sendRedirect("Catalogo?menu=Cliente&accion=Listar");
                    return;
                
                }
                case "Editar":{
                    Long idc = Long.parseLong(request.getParameter("id"));
                    Cliente cl = cdao.listarId(idc);
                    request.setAttribute("cliente", cl);
                    List lista2 = cdao.ListaClientes();
                    request.setAttribute("listaClientes", lista2);
                    break;
                }
                case "Actualizar" : {
                    Cliente c = new Cliente();
                    TelefonoC tc = new TelefonoC();
                    Long idc = Long.parseLong(request.getParameter("txtId"));
                    String nom = request.getParameter("txtNombre");
                    String dir = request.getParameter("txtDireccion");
                    String corr = request.getParameter("txtCorreo");
                    Date f_registro = Date.valueOf(request.getParameter("txtFechaRegistro"));
                   
                    c.setNombre(nom);
                    c.setDireccion(dir);
                    c.setCorreo(corr);
                    c.setFecha_registro(f_registro);
                    c.setId(idc);
                    
                    String[] telefonosArray = request.getParameterValues("txtTelefono");
                    List<TelefonoC> listaTelefonos = new ArrayList<>();
                    if (telefonosArray != null) { 
                        for (String numTelefono : telefonosArray) {
                            if (numTelefono != null && !numTelefono.trim().isEmpty()) {
                                listaTelefonos.add(new TelefonoC(numTelefono, c));
                            }
                        }
                        
                    }
                    c.setTelefonos(listaTelefonos);
                    cdao.actualizarCliente(c);
                    List lista3 = cdao.ListaClientes();
                    request.setAttribute("listaClientes", lista3);
                    break;
                
                }
                
                case "consultaCliente": {
                    List<Object[]> listaclima = cdao.consultaClientesMayoresCompras();

                    // Aquí pasamos los datos obtenidos a la vista
                    request.setAttribute("listaCl", listaclima);

                    break;
                }
                case "clientesnuevos" : {
                    Date fecha_nuevos = Date.valueOf(request.getParameter("txtFecha"));
                    List lista3 = cdao.clientesnuevos(fecha_nuevos);
                    request.setAttribute("listaClientesn", lista3);
                    break;
                    
                
                }
                
                case "Delete":{
                    Long idc = Long.parseLong(request.getParameter("id"));
                    cdao.eliminarCliente(idc);
                    response.sendRedirect("Catalogo?menu=Cliente&accion=Listar");
                    return;
                }
                default: {
                    request.setAttribute("mensaje", "Acción no reconocida");
                    break;
                }
                
            }

            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        
        
        if (menu.equals("Proveedor")) {
            ProveedorDAO pdao = new ProveedorDAO();

            if (accion == null) {
                accion = "Listar"; // Acción por defecto
            }

            switch (accion) {
                case "Listar": {
                    List<Proveedor> lista = pdao.ListaProveedores();
                   
                    request.setAttribute("listaProveedores", lista);
                    
                    break;
                }
                case "Agregar":{
                    Proveedor p = new Proveedor();
                    Long id = Long.parseLong(request.getParameter("txtId"));
                    String nom = request.getParameter("txtNombre");
                    String dirc = request.getParameter("txtDireccion");
                    String cont = request.getParameter("txtContacto");
                    
                    p.setId(id);
                    p.setNombre(nom);
                    p.setDireccion(dirc);
                    p.setP_contacto(cont);
                    String[] telefonosArray = request.getParameterValues("txtTelefono");
                    List<TelefonoPr> listaTelefonos = new ArrayList<>();
                    if (telefonosArray != null) {
                        for (String numTelefono : telefonosArray) {
                            if (numTelefono != null && !numTelefono.trim().isEmpty()) {
                                listaTelefonos.add(new TelefonoPr(numTelefono, p));
                            }
                        }

                    }
                    p.setTelefonos(listaTelefonos);
                    pdao.insertarProveedor(p);

                    response.sendRedirect("Catalogo?menu=Proveedor&accion=Listar");
                    return;
                
                }
                case "Editar":{
                    Long idp = Long.parseLong(request.getParameter("id"));
                    Proveedor p = pdao.listarId(idp);
                    request.setAttribute("proveedor", p);
                    List lista2 = pdao.ListaProveedores();
                    request.setAttribute("listaProveedores", lista2);
                    break;
                }
                case "Actualizar" : {
                    Proveedor p = new Proveedor();
                    TelefonoPr pr = new TelefonoPr();
                    Long idc = Long.parseLong(request.getParameter("txtId"));
                    String nom = request.getParameter("txtNombre");
                    String dir = request.getParameter("txtDireccion");
                    String cont = request.getParameter("txtContacto");
                    
                   
                    p.setNombre(nom);
                    p.setDireccion(dir);
                    p.setP_contacto(cont);
                    p.setId(idc);
                    
                    String[] telefonosArray = request.getParameterValues("txtTelefono");
                    List<TelefonoPr> listaTelefonos = new ArrayList<>();
                    if (telefonosArray != null) { 
                        for (String numTelefono : telefonosArray) {
                            if (numTelefono != null && !numTelefono.trim().isEmpty()) {
                                listaTelefonos.add(new TelefonoPr(numTelefono, p));
                            }
                        }
                        
                    }
                    p.setTelefonos(listaTelefonos);
                    pdao.actualizarProveedor(p);
                    List lista3 = pdao.ListaProveedores();
                    request.setAttribute("listaProveedores", lista3);
                    break;
                
                }
                case "Delete":{
                    Long idp = Long.parseLong(request.getParameter("id"));
                    pdao.eliminarProveedor(idp);
                    response.sendRedirect("Catalogo?menu=Proveedor&accion=Listar");
                    return;
                }
                default: {
                    request.setAttribute("mensaje", "Acción no reconocida");
                    break;
                }
                
            }

            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }
        
        
        if (menu.equals("Vendedor")) {
            VendedorDAO vdao = new VendedorDAO();

            if (accion == null) {
                accion = "Listar"; // Acción por defecto
            }

            switch (accion) {
                case "Listar": {
                    List<Vendedor> lista = vdao.ListaVendedores();
                   
                    request.setAttribute("listaVendedores", lista);
                    
                    break;
                }
                case "Agregar":{
                    Vendedor v = new Vendedor();
                    Long id = Long.parseLong(request.getParameter("txtId"));
                    String nom = request.getParameter("txtNombre");
                    String user = request.getParameter("txtUser");
                    String clave = request.getParameter("txtClave");
                    
                    v.setId(id);
                    v.setNombre(nom);
                    v.setUsuario(user);
                    v.setClave(clave);
                    String[] telefonosArray = request.getParameterValues("txtTelefono");
                    List<TelefonoV> listaTelefonos = new ArrayList<>();
                    if (telefonosArray != null) {
                        for (String numTelefono : telefonosArray) {
                            if (numTelefono != null && !numTelefono.trim().isEmpty()) {
                                listaTelefonos.add(new TelefonoV(numTelefono, v));
                            }
                        }

                    }
                    v.setTelefonos(listaTelefonos);
                    vdao.insertarVendedor(v);

                    response.sendRedirect("Catalogo?menu=Vendedor&accion=Listar");
                    return;
                
                }
                case "Editar":{
                    Long idv = Long.parseLong(request.getParameter("id"));
                    Vendedor v = vdao.listarId(idv);
                    request.setAttribute("vendedor", v);
                    List lista2 = vdao.ListaVendedores();
                    request.setAttribute("listaVendedores", lista2);
                    break;
                }
                case "Actualizar" : {
                    Vendedor v = new Vendedor();
                    TelefonoV tv = new TelefonoV();
                    Long idv = Long.parseLong(request.getParameter("txtId"));
                    String nom = request.getParameter("txtNombre");
                    String user = request.getParameter("txtUser");
                    String clave = request.getParameter("txtClave");
                    
                   
                    v.setNombre(nom);
                    v.setUsuario(user);
                    v.setClave(clave);
                    v.setId(idv);
                    
                    String[] telefonosArray = request.getParameterValues("txtTelefono");
                    List<TelefonoV> listaTelefonos = new ArrayList<>();
                    if (telefonosArray != null) { 
                        for (String numTelefono : telefonosArray) {
                            if (numTelefono != null && !numTelefono.trim().isEmpty()) {
                                listaTelefonos.add(new TelefonoV(numTelefono, v));
                            }
                        }
                        
                    }
                    v.setTelefonos(listaTelefonos);
                    vdao.actualizarVendedor(v);
                    List lista3 = vdao. ListaVendedores();
                    request.setAttribute("listaVendedores", lista3);
                    break;
                
                }
                
                case "consultaVendedor": {
                    Object[] rta = vdao.consultaVendedorMayor();

                    // Aquí pasamos los datos obtenidos a la vista
                    request.setAttribute("vendedorId", rta[0]);
                    request.setAttribute("vendedorNombre", rta[1]);
                    request.setAttribute("cantidad", rta[2]);

                    break;
                }

                
                case "Delete":{
                    Long idv = Long.parseLong(request.getParameter("id"));
                    vdao.eliminarVendedor(idv);
                    response.sendRedirect("Catalogo?menu=Vendedor&accion=Listar");
                    return;
                }
                
                
                default: {
                    request.setAttribute("mensaje", "Acción no reconocida");
                    break;
                }
                
            }

            request.getRequestDispatcher("Vendedor.jsp").forward(request, response);
        }
        
        
         if (menu.equals("Mueble")) {
            MuebleDAO mdao = new MuebleDAO();

            if (accion == null) {
                accion = "Listar"; // Acción por defecto
            }

            switch (accion) {
                case "Listar": {
                    List<Mueble> lista = mdao.listar();
                   
                    request.setAttribute("lista", lista);
                    
                    break;
                }
                case "Agregar":{
                    Mueble m = new Mueble();
                    int id = Integer.parseInt(request.getParameter("txtRef"));
                    String nom = request.getParameter("txtNombre");
                    String tipo = request.getParameter("txtTipo");
                    double alto = Double.parseDouble(request.getParameter("txtAlto"));
                    double ancho = Double.parseDouble(request.getParameter("txtAncho"));
                    double prof = Double.parseDouble(request.getParameter("txtProf"));
                    String mat = request.getParameter("txtMat");
                    String color = request.getParameter("txtColor");
                    long price = Long.parseLong(request.getParameter("txtPrice"));
                    int cant = Integer.parseInt(request.getParameter("txtCant"));
                    String url ="img/" + request.getParameter("txtUrl");
                    
                    m.setReferencia(id);
                    m.setNombre(nom);
                    m.setTipo(tipo);
                    m.setAlto(alto);
                    m.setAncho(ancho);
                    m.setProfundidad(prof);
                    m.setMaterial(mat);
                    m.setColor(color);
                    m.setPrecio(price);
                    m.setCantidad(cant);
                    m.setUrl(url);
                   
                    mdao.insertar(m);

                    response.sendRedirect("Catalogo?menu=Mueble&accion=Listar");
                    return;
                
                }
                case "Editar":{
                    int idm = Integer.parseInt(request.getParameter("id"));
                    Mueble m = mdao.listarId(idm);
                    request.setAttribute("mueble", m);
                    List lista2 = mdao.listar();
                    request.setAttribute("lista", lista2);
                    break;
                }
                case "Actualizar" : {
                    Mueble m = new Mueble();
                    int id = Integer.parseInt(request.getParameter("txtRef"));
                    String nom = request.getParameter("txtNombre");
                    String tipo = request.getParameter("txtTipo");
                    double alto = Double.parseDouble(request.getParameter("txtAlto"));
                    double ancho = Double.parseDouble(request.getParameter("txtAncho"));
                    double prof = Double.parseDouble(request.getParameter("txtProf"));
                    String mat = request.getParameter("txtMat");
                    String color = request.getParameter("txtColor");
                    long price = Long.parseLong(request.getParameter("txtPrice"));
                    int cant = Integer.parseInt(request.getParameter("txtCant"));
                    String url = "img/" + request.getParameter("txtUrl");
                    
                    m.setReferencia(id);
                    m.setNombre(nom);
                    m.setTipo(tipo);
                    m.setAlto(alto);
                    m.setAncho(ancho);
                    m.setProfundidad(prof);
                    m.setMaterial(mat);
                    m.setColor(color);
                    m.setPrecio(price);
                    m.setCantidad(cant);
                    m.setUrl(url);
                    
                    mdao.actualizar(m);
                    List lista3 = mdao.listar();
                    request.setAttribute("lista", lista3);
                    break;
                
                }
                case "Delete":{
                    int idm = Integer.parseInt(request.getParameter("txtRef"));
                    mdao. eliminar(idm);
                    response.sendRedirect("Catalogo?menu=Mueble&accion=Listar");
                    return;
                }
                default: {
                    request.setAttribute("mensaje", "Acción no reconocida");
                    break;
                }
                
            }

            request.getRequestDispatcher("Mueble.jsp").forward(request, response);
        }
        if(menu.equals("Aggcarrito")){
            switch(accion){
                case "Carrito":{
                    String referenciaStr = request.getParameter("id");

                    if (referenciaStr != null) {
                        int referencia = Integer.parseInt(referenciaStr);

                        
                        MuebleDAO muebleDAO = new MuebleDAO();
                        Mueble mueble = muebleDAO.listarId(referencia);

                        if (mueble != null) {
                          
                            HttpSession session = request.getSession();
                            List<Mueble> carrito = (List<Mueble>) session.getAttribute("carrito");

                            if (carrito == null) {
                                carrito = new ArrayList<>();
                            }

                            
                            boolean existe = false;
                            for (Mueble m : carrito) {
                                if (m.getReferencia() == referencia) {
                                    existe = true;
                                    break;
                                }
                            }

                          
                            if (!existe) {
                                carrito.add(mueble);
                            }

                           
                            session.setAttribute("carrito", carrito);
                        }
                    }

                    
                    response.sendRedirect("Catalogo?menu=catalogo");
                    break;
                
                }
                case "EliminarCarrito": {
                    
                    String referenciaStr = request.getParameter("id");

                    if (referenciaStr != null) {
                        int referencia = Integer.parseInt(referenciaStr);

                       
                        HttpSession session = request.getSession();
                        List<Mueble> carrito = (List<Mueble>) session.getAttribute("carrito");

                        if (carrito != null) {
                            carrito.removeIf(m -> m.getReferencia() == referencia);
                            session.setAttribute("carrito", carrito);
                        }
                    }

                    
                    response.sendRedirect("Catalogo?menu=catalogo");
                    break;
                }
            }
        
        }
        if(menu.equals("GenerarVenta")){
            
            ClienteDAO cdao = new ClienteDAO();
            VendedorDAO vdao = new VendedorDAO();
            String referenciaStr = request.getParameter("id");

            if (referenciaStr != null) {
                int referencia = Integer.parseInt(referenciaStr);

                MuebleDAO muebleDAO = new MuebleDAO();
                Mueble mueble = muebleDAO.listarId(referencia);

                if (mueble != null) {

                    HttpSession session = request.getSession(true);
                   
                    List<Mueble> carrito = (List<Mueble>) session.getAttribute("carrito");

                    if (carrito == null) {
                        carrito = new ArrayList<>();
                    }

                    boolean existe = false;
                    for (Mueble m : carrito) {
                        if (m.getReferencia() == referencia) {
                            existe = true;
                            break;
                        }
                    }

                    if (!existe) {
                        carrito.add(mueble);
                    }
                    
                    session.setAttribute("carrito", carrito);
                  
                }
                
            }
           
            switch(accion){
                case "Lcliente" :{
                    Long idc = Long.parseLong(request.getParameter("idCliente"));
                    Cliente cl = cdao.listarId(idc);
                    request.setAttribute("cliente", cl);
                    break;
                }
                case "GenerarFactura":{
                    Factura f = new Factura();
                    FacturaDAO fdao = new FacturaDAO();
                    HttpSession session = request.getSession();
                    List<Mueble> carrito = (List<Mueble>) session.getAttribute("carrito");
                    Long idCliente = Long.parseLong(request.getParameter("idCliente"));
                    Long idVendedor = Long.parseLong(request.getParameter("idVendedor"));
                  
                         
                    Long total = 0l;
                    Long suma = 0l;
                    String[] referencias = request.getParameterValues("referencia");
                    String[] cantidadesStr = request.getParameterValues("cantidad");
                    int[] referenciasI = new int[referencias.length];
                    int[] cantidades = new int[cantidadesStr.length];
                    
                    for (int i = 0; i < cantidadesStr.length; i++) {
                        try {
                            cantidades[i] = Integer.parseInt(cantidadesStr[i]);
                        } catch (NumberFormatException e) {
                            cantidades[i] = 1; // Asigna 1 si hay un error en la conversión
                        }
                    }
                    
                       for (int i = 0; i < referencias.length; i++) {
                        try {
                            referenciasI[i] = Integer.parseInt(referencias[i]);
                        } catch (NumberFormatException e) {
                            referenciasI[i] = 1;                         
                        }
                    }
                       
                    if (referencias != null && cantidadesStr != null) {
                        for (int i = 0; i < referencias.length; i++) {
                            try {
                                int cantidad = Integer.parseInt(cantidadesStr[i]);
                                String referencia = referencias[i];

                               
                                System.out.println("Referencia: " + referencia + ", Cantidad: " + cantidad);
                            } catch (NumberFormatException e) {
                                System.out.println("Error en cantidad: " + cantidadesStr[i]);
                            }
                        }
                    }else{
                        System.out.println("vacio");
                    }
                    int i=0;
                    for (Mueble mueble : carrito) {
                        total +=cantidades[i] * mueble.getPrecio();
                        System.out.println("multiplicado" +total);
                        i++;
                    }
                    
                    f.setPrecio(total);
                    f.setId_v(idVendedor);
                    f.setId_c(idCliente);
                    f.setFecha_venta(Date.valueOf(LocalDate.now()));
                    fdao.insertarFactura(f);
                    int j=0;
                    int id_f=fdao.listarfac();
                    System.out.println("maximo" + id_f);
                    AparecerDAO apdao =  new AparecerDAO();
                    for (Mueble mueble : carrito) {
                        Aparecer ap = new Aparecer(referenciasI[j], id_f, cantidades[j]  );
                        apdao.insertarAparecer(ap);
                        j++;
                    }
                    
                    response.sendRedirect("Catalogo?menu=catalogo");
                    return;
                }
          
                
                default: {
                    request.setAttribute("mensaje", "Acción no reconocida");
                    break;
                }
                
            }
            request.getRequestDispatcher("Factura.jsp").forward(request, response);
        }
        
        // Verifica si se está accediendo a la página de Reporte
        if (menu.equals("Reporte")) {

            // Si no hay parámetros de fecha aún, simplemente redirige al JSP para mostrar el formulario
            if (accion == null || !accion.equals("consultaFacfecha")) {
                // Esto asegura que se muestre el formulario cuando se ingresa al controlador
                request.getRequestDispatcher("Reportesventa.jsp").forward(request, response);
                return;
            }

            // Si se recibe una acción de consulta, procesamos las fechas
            switch (accion) {
                case "consultaFacfecha":
                    // Recuperar las fechas del formulario
                    Date fecha1 = Date.valueOf(request.getParameter("txtFecha1"));
                    Date fecha2 = Date.valueOf(request.getParameter("txtFecha2"));

                    // Obtener las facturas en el rango de fechas
                    FacturaDAO fdao = new FacturaDAO();
                    List<Factura> facturasfe = fdao.getFacturasPorFecha(fecha1, fecha2);

                    // Pasamos la lista de facturas al JSP
                    request.setAttribute("facturas", facturasfe);

                    // Redirigir a la página del reporte de ventas
                    request.getRequestDispatcher("Reportesventa.jsp").forward(request, response);
                    return;
            }
        }


        
        
        
        if(menu.equals("catalogo")){
        MuebleDAO mbdao = new MuebleDAO();
        List<Mueble> listaMuebles = mbdao.listar();
        request.setAttribute("muebles", listaMuebles);
        request.getRequestDispatcher("Catalogo.jsp").forward(request, response);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
