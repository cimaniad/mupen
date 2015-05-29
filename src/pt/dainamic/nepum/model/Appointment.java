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
public class Appointment {

    private int idAppointment;
    private int idPatient;
    private int idHealthProfessional;
    private String date;
    private String hour;
    private String local;
    private byte patientApproval;
    private byte healthProfessionalApproval;
    private String description;

    public Appointment() {
    }

    public Appointment(int idAppointment, int idPatient, int idHealthProfessional, String date, String hour, String local, byte patientApproval, byte healthProfessionalApproval, String description) {
        this.idAppointment = idAppointment;
        this.idPatient = idPatient;
        this.idHealthProfessional = idHealthProfessional;
        this.date = date;
        this.hour = hour;
        this.local = local;
        this.patientApproval = patientApproval;
        this.healthProfessionalApproval = healthProfessionalApproval;
        this.description = description;
    }

    public Appointment(int idPatient, int idHealthProfessional, String date, String hour, String local, byte patientApproval, byte healthProfessionalApproval, String description) {
        this.idPatient = idPatient;
        this.idHealthProfessional = idHealthProfessional;
        this.date = date;
        this.hour = hour;
        this.local = local;
        this.patientApproval = patientApproval;
        this.healthProfessionalApproval = healthProfessionalApproval;
        this.description = description;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public int getIdHealthProfessional() {
        return idHealthProfessional;
    }

    public void setIdHealthProfessional(int idHealthProfessional) {
        this.idHealthProfessional = idHealthProfessional;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte getPatientApproval() {
        return patientApproval;
    }

    public void setPatientApproval(byte patientApproval) {
        this.patientApproval = patientApproval;
    }

    public byte getHealthProfessionalApproval() {
        return healthProfessionalApproval;
    }

    public void setHealthProfessionalApproval(byte healthProfessionalApproval) {
        this.healthProfessionalApproval = healthProfessionalApproval;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Appointment{" + "idAppointment=" + idAppointment + ", idPatient="
                + idPatient + ", idHealthProfessional=" + idHealthProfessional + ", date="
                + date + ", hour=" + hour + ", patientApproval=" + patientApproval
                + ", healthProfessionalApproval=" + healthProfessionalApproval
                + ", description=" + description + '}';
    }

}
