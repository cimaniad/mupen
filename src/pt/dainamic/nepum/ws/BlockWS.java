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
import pt.dainamic.nepum.model.Block;

/**
 *
 * @author jorge
 */
public class BlockWS {
    
    private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private Logger log = Logger.getLogger(BlockWS.class);

    public BlockWS() {
         gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();
    }
    
     public void saveBlock(Block b) {

        try {
            responseWS = wrapperWS.sendRequest("Block", "saveBlock", getAllParams(b));    //efetua o pedido ao WS
            String validacao = wrapperWS.readResponse(responseWS);         //Passa a resposta para uma string

            Validation v = gson.fromJson(validacao, Validation.class);    //Conversão do objecto Json para o objecto Java

            if (v.getCod() != 201) {
                System.out.println(v.getMsg());
                log.error(v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao criar o Bloco");
            }

        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("Block saved with sucess");
    }
 
     private List<NameValuePair> getAllParams(Block b) {
        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idBlock", String.valueOf(b.getIdBlock())));
        params.add(new BasicNameValuePair("description", (b.getDescription())));
        params.add(new BasicNameValuePair("name", (b.getName())));
        params.add(new BasicNameValuePair("idHealthProfessional", String.valueOf(b.getIdHealthProfessional())));
        
        return params;
    }
     
     public List<Block> getAllBlocksByHealthProfessional(int idHealthProfessional) {
        List<Block> bList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idHealthProfessional", String.valueOf(idHealthProfessional)));
        try {
            responseWS = wrapperWS.sendRequest("Block",
                    "getAllBlocksByHealthProfessional", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java     
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Bloco");
            }

            Type type = new TypeToken<List<Block>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            bList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tBlock data access success");
        log.debug("\n\tBs : " + bList.toString());
        return bList;
    }
     
     public Block getBlockById(int id) {

        Block b = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idBlock", String.valueOf(id)));

        try {
            responseWS = wrapperWS.sendRequest("Blcok",
                    "getBlockById", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java     
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados do Bloco");
            }

            b = gson.fromJson(jsonResp, Block.class);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tBlock data access success");
        log.debug("\n\tB with id " + id + ": " + b.toString());
        return b;
    }
     
     public List<Block> getBlockByName(String name) {
        List<Block> bList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("name", name));
        try {
            responseWS = wrapperWS.sendRequest("Block",
                    "getBlockByName", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java     
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao realizar a pesquisa");
            }

            Type type = new TypeToken<List<Block>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            bList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tBlock search success");
        log.debug("\n\tBs : " + bList.toString());
        return bList;
    }
     
     public void deleteBlock(int id){
          List<NameValuePair> parms = new ArrayList<>();
        parms.add(new BasicNameValuePair("idBlock", String.valueOf(id)));
        try {
            responseWS = wrapperWS.sendRequest("Block", "deleteBlock", parms);
            String jsonResp = wrapperWS.readResponse(responseWS);
            Validation v = gson.fromJson(jsonResp, Validation.class);
            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Não foi possivel eliminar este Bloco \nporque está associado a algo!");
            }
        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tBlock deleted with success");
     }
}
