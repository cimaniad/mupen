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
public class LoginSession {

    private int idAdmin;
    private int idHealthProfessional;
    private static LoginSession instance;

    

    private LoginSession() {

    }

    

    public static LoginSession getInstance() {
        if (instance == null) {
            instance = new LoginSession();
        }
        return instance;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public int getIdHealthProfessional() {
        return idHealthProfessional;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setIdHealthProfessional(int idHealthProfessional) {
        this.idHealthProfessional = idHealthProfessional;
    }
}
