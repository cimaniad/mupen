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
import pt.dainamic.nepum.model.Comment;
import pt.dainamic.nepum.model.HealthProfessional;

/**
 *
 * @author Utilizador
 */
public class CommentWS {
    private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private static Logger log = Logger.getLogger(CommentWS.class);
    
    public CommentWS() {
        
        gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();

        
    }
    
    public Comment getComment(int id) {
        Comment cm = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um comentario
        params.add(new BasicNameValuePair("idComment", String.valueOf(id)));

        try {
            responseWS = wrapperWS.sendRequest("Comment",
                    "getComment", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java
                log.error("\n\tCod: " + httpResponseCod + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Comentario");
            }

            cm = gson.fromJson(jsonResp, Comment.class);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tComment data access success");
        log.debug("\n\tComment by id " + id + ": " + cm.toString());
        return cm;
    }
    
}
