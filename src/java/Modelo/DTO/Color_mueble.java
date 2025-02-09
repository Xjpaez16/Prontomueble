/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;



/**
 *
 * @author ielcj
 */
class Color_mueble {
    private int id;
    private String n_color;

    public Color_mueble(int id, String n_color) {
        this.id = id;
        this.n_color = n_color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN_color() {
        return n_color;
    }

    public void setN_color(String n_color) {
        this.n_color = n_color;
    }
    
}
