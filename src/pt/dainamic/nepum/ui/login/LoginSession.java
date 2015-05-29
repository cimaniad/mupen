/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.dainamic.nepum.ui.login;

/**
 *
 * @author Ricardo
 */
public class LoginSession {
    private int id;
    private static LoginSession instance;
    
    public static LoginSession getInstance() {
        if (instance == null) {
            instance = new LoginSession();
        }
        return instance;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

}
