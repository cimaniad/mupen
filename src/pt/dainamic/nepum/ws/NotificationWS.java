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
import pt.dainamic.nepum.model.Appointment;
import pt.dainamic.nepum.model.Notification;

/**
 *
 * @author Utilizador
 */
public class NotificationWS {
    
    private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private static Logger log = Logger.getLogger(AppointmentWS.class);
    
     public NotificationWS() {
        gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();

    }
     
 public List<Notification> getHPNotifications(int idHealthProfessional) {
        List<Notification> nList = null;

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("idHealthProfessional", String.valueOf(idHealthProfessional)));
        try {
            responseWS = wrapperWS.sendRequest("Notification",
                    "getHPNotifications", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                throw new RuntimeException("Ocorreu um erro ao aceder aos dados da notificação");
            }

            Type type = new TypeToken<List<Appointment>>() {
            }.getType();  //tipo do para o qual queros retornar a responseWS Json
            nList = gson.fromJson(jsonResp, type);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\t Notification data access success");
        log.debug("\n\tApoints : " + nList.toString());
        return nList;

    }
 
  private List<NameValuePair> getAllParams(Notification a) {
        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um paciente
        params.add(new BasicNameValuePair("idNotification", String.valueOf(a.getIdNotification())));
        params.add(new BasicNameValuePair("idAppointment", String.valueOf(a.getIdAppointment())));
        params.add(new BasicNameValuePair("saw", String.valueOf(a.isSaw())));
        params.add(new BasicNameValuePair("sessionDescription", String.valueOf(a.getSessionDescription())));
        params.add(new BasicNameValuePair("appointmentDescription", a.getAppointmentDescription()));
        params.add(new BasicNameValuePair("patient", String.valueOf(a.isPatient())));
        
        return params;
    }
    
}
