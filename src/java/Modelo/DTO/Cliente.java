/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ielcj
 */
public class Cliente {
    private Long id;
    private String nombre;
    private String direccion;
    private String correo;
    private Date fecha_registro;
    private List<TelefonoC> telefonos;

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String direccion, String correo, Date fecha_registro) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
        this.telefonos = new ArrayList<>();
    }

    
        
  
    
    public void aggTelefono(TelefonoC telefono) {
        this.telefonos.add(telefono);
        telefono.setCliente(this);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }


    public List<TelefonoC> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoC> telefonos) {
        this.telefonos = telefonos;
    }
    
    
}
