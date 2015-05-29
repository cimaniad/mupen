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
public class Exercise {

    private int idExercise;
    private int idSubDomain;
    private String designation;
    private String structure;
    private String name;
    private String picture;

    public Exercise(int idExercise, int idSubDomain, String designation, String structure, String name, String picture) {
        this.idExercise = idExercise;
        this.idSubDomain = idSubDomain;
        this.designation = designation;
        this.structure = structure;
        this.name = name;
        this.picture = picture;
    }


    public int getIdExercise() {
        return idExercise;
    }


    public int getIdSubDomain() {
        return idSubDomain;
    }

    public void setIdSubdomain(int idSubdomain) {
        this.idSubDomain = idSubdomain;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Exercise{" + "idExercise=" + idExercise + ", idSubDomain=" + idSubDomain + ", designation=" + designation + ", structure=" + structure + ", name=" + name + ", picture=" + picture + '}';
    }
    
}
