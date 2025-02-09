/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;



/**
 *
 * @author ielcj
 */
class Tipo_mueble {
    private int id;
    private String n_tipo;

    public Tipo_mueble(int id, String n_tipo) {
        this.id = id;
        this.n_tipo = n_tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN_tipo() {
        return n_tipo;
    }

    public void setN_tipo(String n_tipo) {
        this.n_tipo = n_tipo;
    }
    
    
}
