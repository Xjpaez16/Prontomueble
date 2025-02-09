/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;


/**
 *
 * @author ielcj
 */
public class Mueble {
    private Long referencia;
    private String nombre;
    private Tipo_mueble tipo;
    private double alto;
    private double ancho;
    private double profundidad;
    private Material_mueble material;
    private Color_mueble color;
    private Long precio;
    private int cantidad;
    private String url;

    public Mueble(Long referencia, String nombre, Tipo_mueble tipo, double alto, double ancho, double profundidad, Material_mueble material, Color_mueble color, Long precio, int cantidad, String url) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.tipo = tipo;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.material = material;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
        this.url = url;
    }

    public Long getReferencia() {
        return referencia;
    }

    public void setReferencia(Long referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo_mueble getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_mueble tipo) {
        this.tipo = tipo;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public Material_mueble getMaterial() {
        return material;
    }

    public void setMaterial(Material_mueble material) {
        this.material = material;
    }

    public Color_mueble getColor() {
        return color;
    }

    public void setColor(Color_mueble color) {
        this.color = color;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
