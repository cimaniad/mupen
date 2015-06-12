/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ws;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import pt.dainamic.nepum.model.Exercise;

/**
 *
 * @author jorge
 */
public class ExerciseWS {

    private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private Logger log = Logger.getLogger(ExerciseWS.class);

    public ExerciseWS() {
        gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta

        try {
            responseWS = wrapperWS.sendRequest("Exercise",
                    "getAllExercises", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Exercício");
            }

            Type type = new TypeToken<List<Exercise>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            exList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tExercise data access success");
        log.debug("\n\tHPs : " + exList.toString());
        return exList;

    }

    public Exercise getExerciseById(int id) {

        Exercise ex = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idExercise", String.valueOf(id)));

        try {
            responseWS = wrapperWS.sendRequest("Exercise",
                    "getExerciseById", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Exercício");
            }

            ex = gson.fromJson(jsonResp, Exercise.class);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tExercise data access success");
        log.debug("\n\tEx with id " + id + ": " + ex.toString());
        return ex;
    }

    public List<Exercise> getExerciseBySubDomain(int idSD) {
        List<Exercise> exList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idSubDomain", String.valueOf(idSD)));

        try {
            responseWS = wrapperWS.sendRequest("Exercise",
                    "getExerciseBySubDomain", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Exercício");
            }

            Type type = new TypeToken<List<Exercise>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            exList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tExercise data access success");
        log.debug("\n\tPs : " + exList.toString());
        return exList;
    }
    
    public void saveAssignExercise(int idBlock, int idExercise ) {

        try {
            ArrayList<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("idBlock", String.valueOf(idBlock)));
            params.add(new BasicNameValuePair("idExercise", String.valueOf(idExercise)));
            
            
            responseWS = wrapperWS.sendRequest("Exercise",
                    "saveAssignExercise", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 201) {
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao guardar um exercício");
            }

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\t AssignedEcercise saved with success");
    }
    
    public List<Exercise> getExercisesByBlock(int idB) {
        List<Exercise> exList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idBlock", String.valueOf(idB)));

        try {
            responseWS = wrapperWS.sendRequest("Exercise",
                    "getExercisesByBlock", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Bloco");
            }

            Type type = new TypeToken<List<Exercise>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            exList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tBlock data access success");
        log.debug("\n\tPs : " + exList.toString());
        return exList;
    }
}
