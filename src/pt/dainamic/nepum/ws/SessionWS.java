/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ws;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import pt.dainamic.nepum.model.Session;



/**
 *
 * @author jorge
 */
public class SessionWS {

 private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private Logger log = Logger.getLogger(SessionWS.class);

    public SessionWS() {
         gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();
    }

    public Validation saveSession(Session s) {
Validation v;
        try {
            responseWS = wrapperWS.sendRequest("Session",
                    "saveSession", getAllParams(s));    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

             v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 201) {
                log.error("\n\tCod: " + httpResponseCod + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao prescrever sessão");
            }

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tSession saved with success");
        return v;
    }

     private List<NameValuePair> getAllParams(Session s) {
        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idSession", String.valueOf(s.getIdSession())));
        params.add(new BasicNameValuePair("idPatient", String.valueOf(s.getIdPatient())));
        params.add(new BasicNameValuePair("idHealthProfessional", String.valueOf(s.getIdHealthProfessional())));
        params.add(new BasicNameValuePair("idBlock", String.valueOf(s.getIdBlock())));
        params.add(new BasicNameValuePair("deadLine", String.valueOf(s.getDeadline())));
        return params;
}
}
