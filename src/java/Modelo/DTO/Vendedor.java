/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ielcj
 */
class Vendedor {
    private Long id;
    private String nombre;
    private String usuario;
    private String clave;
    private List<TelefonoV> telefonos;
    public Vendedor(Long id, String nombre, String usuario, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.telefonos =  new ArrayList<>();
    }

    public List<TelefonoV> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoV> telefonos) {
        this.telefonos = telefonos;
    }
    
    public void aggTelefono(TelefonoV telefono){
        this.telefonos.add(telefono);
        telefono.setVendedor(this);
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
