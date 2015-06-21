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
import pt.dainamic.nepum.model.AssignExercise;

/**
 *
 * @author jorge
 */
public class AssignExerciseWS {

    private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private static Logger log = Logger.getLogger(AssignExerciseWS.class);

    public AssignExerciseWS() {
         gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();
    }

     public void saveAssignExercise(AssignExercise ae ) {

        try {
            responseWS = wrapperWS.sendRequest("AssignExercise",
                    "saveAssignExercise", getAllParams(ae));    //efetua o pedido ao WS
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

    public List<AssignExercise> getAssignExerciseByIdBlock(int idB){
        List<AssignExercise> exList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idBlock", String.valueOf(idB)));

        try {
            responseWS = wrapperWS.sendRequest("AssignExercise",
                    "getAssignExerciseByIdBlock", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados dos Exercícios Atribuidos");
            }

            Type type = new TypeToken<List<AssignExercise>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            exList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tAssignExercise data access success");
        log.debug("\n\tPs : " + exList.toString());
        return exList;
    }

     private List<NameValuePair> getAllParams(AssignExercise ae) {
        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idBlock", String.valueOf(ae.getIdBlock())));
        params.add(new BasicNameValuePair("idExercise", String.valueOf(ae.getIdExercise())));
        return params;
}
}
