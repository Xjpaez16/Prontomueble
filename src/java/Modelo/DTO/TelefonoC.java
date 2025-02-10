/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;



/**
 *
 * @author ielcj
 */
public class TelefonoC {
    private String nTelefono;
    private Cliente cliente;

    public TelefonoC(String nTelefono, Cliente cliente) {
        this.nTelefono = nTelefono;
        this.cliente = cliente;
    }

    public TelefonoC() {
    }
    

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
