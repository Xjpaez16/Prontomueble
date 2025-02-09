/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;



/**
 *
 * @author ielcj
 */
public class TelefonoPr {
    private String nTelefono;
    private Proveedor proveedor;

    public TelefonoPr(String nTelefono, Proveedor proveedor) {
        this.nTelefono = nTelefono;
        this.proveedor = proveedor;
    }

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
}
