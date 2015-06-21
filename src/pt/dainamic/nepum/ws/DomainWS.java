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
import pt.dainamic.nepum.model.Domain;

/**
 *
 * @author jorge
 */
public class DomainWS {
    
     private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private Logger log = Logger.getLogger(DomainWS.class);

    public DomainWS() {
        gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();
    }
    
    public List<Domain> getAllDomains() {
        List<Domain> dList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta

        try {
            responseWS = wrapperWS.sendRequest("Domain",
                    "getDomains", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java     
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Domínio");
            }

            Type type = new TypeToken<List<Domain>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            dList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\t Domain data access success");
        log.debug("\n\tDs : " + dList.toString());
        return dList;

    }
    
    public Domain getDomainById(int id) {

        Domain d = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idDomain", String.valueOf(id)));

        try {
            responseWS = wrapperWS.sendRequest("Domain",
                    "getDomainById", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java     
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Domínio");
            }

            d = gson.fromJson(jsonResp, Domain.class);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tDomain data access success");
        log.debug("\n\tD with id " + id + ": " + d.toString());
        return d;
    }

    private List<NameValuePair> getAllParams(Domain d) {
        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idDomain", String.valueOf(d.getIdDomain())));
        params.add(new BasicNameValuePair("name", d.getName()));
        params.add(new BasicNameValuePair("description", (d.getDescription())));

        return params;
    }
}
