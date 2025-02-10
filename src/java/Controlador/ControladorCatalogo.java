/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.DAO.ClienteDAO;
import Modelo.DAO.MuebleDAO;
import Modelo.DTO.Cliente;
import Modelo.DTO.Mueble;
import Modelo.DTO.TelefonoC;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
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
