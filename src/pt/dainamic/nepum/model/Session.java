/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.model;


import java.util.Date;

/**
 *
 * @author jorge
 */
public class Session {
    
    private int idSession;
    private int idPatient;
    private int idHealthProfessional;
    private int idBlock;
    private String deadline;

    public Session(int idSession, int idPatient, int idHealthProfessional, int idBlock, String deadline) {
        this.idSession = idSession;
        this.idPatient = idPatient;
        this.idHealthProfessional = idHealthProfessional;
        this.idBlock = idBlock;
        this.deadline = deadline;
    }

    public Session() {
    }

    public int getIdSession() {
        return idSession;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdHealthProfessional() {
        return idHealthProfessional;
    }

    public void setIdHealthProfessional(int idHealthProfessional) {
        this.idHealthProfessional = idHealthProfessional;
    }

    public int getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(int idBlock) {
        this.idBlock = idBlock;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    
    
}
