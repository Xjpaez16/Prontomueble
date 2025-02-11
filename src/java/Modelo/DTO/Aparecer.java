/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author ielcj
 */
public class Aparecer {
    private int id_m;
    private int id_f;
    private int cant_muebles;

    public Aparecer(int id_m, int id_f, int cant_muebles) {
        this.id_m = id_m;
        this.id_f = id_f;
        this.cant_muebles = cant_muebles;
    }

    

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public int getId_f() {
        return id_f;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }

   

  
    public int getCant_muebles() {
        return cant_muebles;
    }

    public void setCant_muebles(int cant_muebles) {
        this.cant_muebles = cant_muebles;
    }
    
    
}
