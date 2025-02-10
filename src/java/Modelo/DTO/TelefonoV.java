/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author ielcj
 */
public class TelefonoV {
    private String nTelefono;
    private Vendedor vendedor;

    public TelefonoV(String nTelefono, Vendedor vendedor) {
        this.nTelefono = nTelefono;
        this.vendedor = vendedor;
    }

    public TelefonoV() {
    }

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    
    
}
