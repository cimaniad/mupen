/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.*;

/**
 *
 * Class responsavel por fazer a conexão ao web service sempre que necessário
 */
public class WrapperWS {

    private static WrapperWS instance;
    private final String URL = "http://dainamic.dsi.uminho.pt/api/";
    private final CloseableHttpClient httpClient;
    private final HttpPost post;
    private static Logger log = Logger.getLogger(WrapperWS.class);

    /**
     * private contruct so this class can't be instanciated
     */
    private WrapperWS() {
        this.httpClient = HttpClients.createDefault();
        this.post = new HttpPost(URL);

        log.debug("Connection established with the WS");

    }

    /**
     * This method implements the Singlton design pattern
     *
     * @return WrapperWS
     */
    public static WrapperWS getWrapperWS() {
        if (instance == null) {
            instance = new WrapperWS();
        }
        return instance;
    }

    /**
     * Metodo resposnsavel por fazer o pedido ao WS, retorna a resposta do WS
     *
     * @param object (the object we want interact with)
     * @param function (the function we want to execute)
     * @param params (necessary parameters to execute the function)
     * @return CloseableHttpResponse
     */
    public CloseableHttpResponse sendRequest(String object, String function,
            List<NameValuePair> params) {
        params.add(new BasicNameValuePair("object", object));
        params.add(new BasicNameValuePair("function", function));
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);
            post.setEntity(entity);
            log.debug("Request executed with sucess");
            return httpClient.execute(post);
        } catch (IOException e) {
            log.error("Error trying to access the server:\n " + e.getMessage());
            throw new RuntimeException("Ocorreu um erro ao tentar aceder ao servidor. \n\tVerifique a ligação à internet");
        }
    }

    /**
     * This method get the response from the web service and return it as a
     * String
     *
     * @param response
     * @return String
     */
    public String readResponse(CloseableHttpResponse response) {

        StringBuilder data = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            data = new StringBuilder();

            while ((line = br.readLine()) != null) {
                data.append(line);
            }

            log.debug("Response from server: " + data);
            br.close();
            return data.toString();
        } catch (IOException | IllegalStateException e) {
            log.error("Error handling the response" + e.getMessage());
            return null;
        }

    }
}
