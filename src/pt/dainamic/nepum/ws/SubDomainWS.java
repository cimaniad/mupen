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
import pt.dainamic.nepum.model.SubDomain;

/**
 *
 * @author jorge
 */
public class SubDomainWS {
    
     private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private Logger log = Logger.getLogger(SubDomainWS.class);

    public SubDomainWS() {
        gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();
    }
 
    
    public SubDomain getSubDomainById(int id) {

        SubDomain sd = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idSubDomain", String.valueOf(id)));

        try {
            responseWS = wrapperWS.sendRequest("SubDomain",
                    "getSubDomainById", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java     
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Sub-Domínio");
            }

            sd = gson.fromJson(jsonResp, SubDomain.class);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tSubDomain data access success");
        log.debug("\n\tSD with id " + id + ": " + sd.toString());
        return sd;
    }
    
    public List<SubDomain> getSubDomainByDomain(int idD){
        List<SubDomain> sdList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idDomain", String.valueOf(idD)));

        try {
            responseWS = wrapperWS.sendRequest("SubDomain",
                    "getSubDomainByDomain", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java     
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do SubDomínio");
            }

            Type type = new TypeToken<List<SubDomain>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            sdList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tSubDomain data access success");
        log.debug("\n\tPs : " + sdList.toString());
        return sdList;
    }

    private List<NameValuePair> getAllParams(SubDomain sd) {
        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idSubDomain", String.valueOf(sd.getIdSubDomain())));
        params.add(new BasicNameValuePair("name", sd.getName()));
        params.add(new BasicNameValuePair("description", (sd.getDescription())));
        params.add(new BasicNameValuePair("idDomain", String.valueOf(sd.getIdDomain())));

        return params;
    }
}


