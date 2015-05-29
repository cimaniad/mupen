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
public class Domain {
    
    private int idDomain;
    private String name;
    private String description;

    public Domain(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getIdDomain() {
        return idDomain;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Domain{" + "idDomain=" + idDomain + ", name=" + name + ", description=" + description + '}';
    }
    
    
}
