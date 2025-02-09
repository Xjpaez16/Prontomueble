/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

import java.time.LocalDate;

/**
 *
 * @author ielcj
 */
public class Factura {
    private int id;
    private Long precio;
    private Vendedor id_v;
    private Cliente id_c;
    private LocalDate fecha_venta;

    public Factura(int id, Long precio, Vendedor id_v, Cliente id_c, LocalDate fecha_venta) {
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

    public Vendedor getId_v() {
        return id_v;
    }

    public void setId_v(Vendedor id_v) {
        this.id_v = id_v;
    }

    public Cliente getId_c() {
        return id_c;
    }

    public void setId_c(Cliente id_c) {
        this.id_c = id_c;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    
}
