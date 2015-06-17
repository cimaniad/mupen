/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.model;

/**
 *
 * @author Utilizador
 */
public class Notification {
    
    private int idNotification;
    private int idAppointment;
    private boolean saw;
    private String sessionDescription;
    private String appointmentDescription;
    private boolean patient;

    public Notification(int idNotification, int idAppointment, boolean saw, String sessionDescription, String appointmentDescription, boolean patient) {
        this.idNotification = idNotification;
        this.idAppointment = idAppointment;
        this.saw = saw;
        this.sessionDescription = sessionDescription;
        this.appointmentDescription = appointmentDescription;
        this.patient = patient;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public boolean isPatient() {
        return patient;
    }

    public void setPatient(boolean patient) {
        this.patient = patient;
    }

    

    public int getIdNotification() {
        return idNotification;
    }


    public int getIdAppointment() {
        return idAppointment;
    }

    public boolean isSaw() {
        return saw;
    }

    public void setSaw(boolean saw) {
        this.saw = saw;
    }
    
    
    
}
