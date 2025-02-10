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
public class Proveedor {
    private Long id;
    private String nombre;
    private String direccion;
    private String p_contacto;
    private List<TelefonoPr> telefonos;

    public Proveedor(Long id, String nombre, String direccion, String p_contacto) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.p_contacto = p_contacto;
        this.telefonos = new ArrayList<>();
    }

    public Proveedor() {
    }
    public void aggTelefono(TelefonoPr telefono){
        this.telefonos.add(telefono);
        telefono.setProveedor(this);
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

    public String getP_contacto() {
        return p_contacto;
    }

    public void setP_contacto(String p_contacto) {
        this.p_contacto = p_contacto;
    }

    public List<TelefonoPr> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoPr> telefonos) {
        this.telefonos = telefonos;
    }
    
    
}
