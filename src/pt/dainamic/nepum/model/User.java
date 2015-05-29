/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.dainamic.nepum.model;

/**
 *
 * @author Ricardo
 */
public class User {
    private String name;
    private String lastName;
    private int numCC;
    private String adress;
    private int numTel;
    private String email;
    private String birthDate;
    private String bloodGroup;
    private String nationality;
    private String password;
    private String picture;
    
     public User(){
         
     }
    
     public User(String name, String lastName, int numCC, String picture,
            String adress, int numTel, String email, String birthDate,
            String bloodGroup, String nationality, String password) {

        this.name = name;
        this.lastName = lastName;
        this.numCC = numCC;
        this.adress = adress;
        this.numTel = numTel;
        this.email = email;
        this.birthDate = birthDate;
        this.bloodGroup = bloodGroup;
        this.nationality = nationality;
        this.password = password;
        this.picture = picture;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumCC() {
        return numCC;
    }

    public void setNumCC(int numCC) {
        this.numCC = numCC;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
}
