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
public class SubDomain {
    
    private int idSubDomain;
    private String name;
    private String description;
    private int idDomain;

    public SubDomain(String name, String description, int idDomain) {
        this.name = name;
        this.description = description;
        this.idDomain = idDomain;
    }

    public int getIdSubDomain() {
        return idSubDomain;
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

    public int getIdDomain() {
        return idDomain;
    }

    public void setIdDomain(int idDomain) {
        this.idDomain = idDomain;
    }

    @Override
    public String toString() {
        return "subDomain{" + "idSubDomain=" + idSubDomain + ", name=" + name + ", description=" + description + ", idDomain=" + idDomain + '}';
    }
    
    
           
}
