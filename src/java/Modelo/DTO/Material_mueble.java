/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;


/**
 *
 * @author ielcj
 */
class Material_mueble {
    private int id;
    private String n_material;

    public Material_mueble(int id, String n_material) {
        this.id = id;
        this.n_material = n_material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN_material() {
        return n_material;
    }

    public void setN_material(String n_material) {
        this.n_material = n_material;
    }
    
}
