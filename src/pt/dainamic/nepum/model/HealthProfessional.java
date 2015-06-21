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
public class HealthProfessional extends User {

    private int idHealthProfessional;
    private int nif;
    private String maritalStatus;
    private String gender;
    private String institution;
    private byte developmentProfessional;

    /**
     * Metdo construtor por defeito
     */
    public HealthProfessional() {
        super();
    }

    /**
     *
     * @param name
     * @param lastName
     * @param numCC
     * @param adress
     * @param numTel
     * @param nif
     * @param email
     * @param maritalStatus
     * @param birthDate
     * @param bloodGroup
     * @param nacionality
     * @param gender
     * @param password
     * @param picture
     * @param institution
     * @param developmentProfessional
     */
    public HealthProfessional(String name, String lastName, int numCC, String adress,
            int numTel, int nif, String email, String maritalStatus, String birthDate,
            String bloodGroup, String nacionality, String gender, String password,
            String picture, String institution, byte developmentProfessional) {
        super(name, lastName, numCC, picture, adress, numTel, email, birthDate, bloodGroup, nacionality, password);
        this.nif = nif;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.institution = institution;
        this.developmentProfessional = developmentProfessional;

    }

    public int getIdHealthProfessional() {
        return idHealthProfessional;
    }
    
    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public byte getDevelopmentProfessional() {
        return developmentProfessional;
    }

    public void setDevelopmentProfessional(byte developmentProfessional) {
        this.developmentProfessional = developmentProfessional;
    }

    

    /**
     * Reescrita do metodo toString
     */
    @Override
    public String toString() {
        return "HealthProfessional{" + "idHealthProfessional=" + idHealthProfessional
        + ", name=" + this.getName() + ", lastName=" + this.getLastName()
        + ", numCC=" + this.getNumCC() + ", adress=" + this.getAdress()
        + ", numTel=" + this.getNumTel() + ", nif=" + nif
        + ", email=" + this.getEmail() + ", maritalStatus=" + maritalStatus
        + ", birthDate=" + this.getBirthDate() + ", bloodGroup=" + this.getBloodGroup()
        + ", nationality=" + this.getNationality() + ", sex=" + gender
        + ", password=" + this.getPassword() + ", picture=" + this.getPicture()
        + ", institution=" + institution
        + ", developmentProfessional=" + developmentProfessional + '}';
    }

}
