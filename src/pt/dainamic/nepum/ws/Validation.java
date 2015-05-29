/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.dainamic.nepum.ws;


/**
 *
 * class para validar os pedidos ao WS
 */
public class Validation {
    
    private String msg;
    private int cod;
    private boolean error;
/**
 * metodo construtor
 */
    public Validation() {
    }
/**
 * metodos seletores e modificadores
 */
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    
    
}
