/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.model;

/**
 *
 * @author ASUS
 */

public class Admin extends User{

    private int idAdmin;
    
      public Admin(){
        super();
      }

    public Admin(String name, String lastName, int numCC, String picture,
            String adress, int numTel, String email, String birthDate,
            String bloodGroup, String nationality, String password) {

              super(name, lastName, numCC, picture, adress, numTel, email, birthDate,
               bloodGroup, nationality, password);
    }

    public int getIdAdmin() {
        return idAdmin;
    }
     
    @Override
    public String toString() {
        return "Admin{" + "idAdmin=" + idAdmin + ", name=" + this.getName() + ", lastName=" + this.getLastName()
                + ", numCC=" + this.getNumCC() + ", adress=" + this.getAdress() + ", numTel=" + this.getNumTel() + ", email="
                + this.getEmail() + ", birthDate=" + this.getBirthDate() + ", bloodGroup=" + this.getBloodGroup()
                + ", nationality=" + this.getNationality() + ", password=" + this.getPassword() + '}';
    }

}
