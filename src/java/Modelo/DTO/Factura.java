/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ielcj
 */
public class Factura {
    private int id;
    private Long precio;
    private Long id_v;
    private Long id_c;
    private Date fecha_venta;
    private List<String> referencias;
    private List<Integer> cantidades;
    
 
    public Factura() {
        this.referencias = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public void agregarItem(String referencia, int cantidad) {
        this.referencias.add(referencia);
        this.cantidades.add(cantidad);
    }

    public List<String> getReferencias() {
        return referencias;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }
    public Factura(int id) {
        this.id = id;
    }

    
    
    public Factura(int id, Long precio, Long id_v, Long id_c, Date fecha_venta) {
        this.id = id;
        this.precio = precio;
        this.id_v = id_v;
        this.id_c = id_c;
        this.fecha_venta = fecha_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getId_v() {
        return id_v;
    }

    public void setId_v(Long id_v) {
        this.id_v = id_v;
    }

    public Long getId_c() {
        return id_c;
    }

    public void setId_c(Long id_c) {
        this.id_c = id_c;
    }

   

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

  
    
    
}
