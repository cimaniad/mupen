/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.model;


/**
 *
 * @author jorge
 */
public class Block {
    
    private int idBlock;
    private String description;
    private String name;
    private int idHealthProfessional;

    public Block( String description, String name, int idHealthProfessional) {
        this.description = description;
        this.name = name;
        this.idHealthProfessional = idHealthProfessional;
    }

    public int getIdBlock() {
        return idBlock;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdHealthProfessional() {
        return idHealthProfessional;
    }

    public void setIdHealthProfessional(int idHealthProfessional) {
        this.idHealthProfessional = idHealthProfessional;
    }

    @Override
    public String toString() {
        return "Block{" + "idBlock=" + idBlock + ", description=" + description + ", name=" + name + ", idHealthProfessional=" + idHealthProfessional + '}';
    }
    
}
