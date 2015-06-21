package pt.dainamic.nepum.ws;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import pt.dainamic.nepum.model.LoginSession;

public class LoginWS {

    private WrapperWS wrapperWS;
    private CloseableHttpResponse responseWS;
    private Gson gson;
    private Logger log = Logger.getLogger(LoginWS.class);

    public LoginWS() {
        gson = new Gson();
        wrapperWS = WrapperWS.getWrapperWS();
    }

    public LoginSession validateLogin(String email, String password) {

        LoginSession session = LoginSession.getInstance();

        List<NameValuePair> params = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));

        try {
            responseWS = wrapperWS.sendRequest("Login",
                    "validateLogin", params);    //efetua o pedido ao WS
            String jsonResp = wrapperWS.readResponse(responseWS);         //Passa a responseWS para uma string

            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                Validation v = gson.fromJson(jsonResp, Validation.class);    //Conversão do objecto Json para o objecto Java
                log.error("\n\tCod: " + v.getCod() + "\tMsg: " + v.getMsg());
                if (httpResponseCod == 401) {
                    throw new RuntimeException("Password incorrecta");
                }
                throw new RuntimeException("E-mail incorrecto");
            }

            session = gson.fromJson(jsonResp, LoginSession.class);

        } catch (RuntimeException e) {
            log.error("\n\t" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("\n\tlogin validation success");
        log.debug("\n\t Admin with id " + session.getIdAdmin() + "/n Hp with id " + session.getIdHealthProfessional());
        return session;

    }

    public void getPassword(String email, int numCc) {

        List<NameValuePair> p = new ArrayList<>();           //array com os params necessários para registar um terapeuta
        p.add(new BasicNameValuePair("email", email));
        p.add(new BasicNameValuePair("numCc", String.valueOf(numCc)));

        try {
            responseWS = wrapperWS.sendRequest("Login", "getPassword", p);    //efetua o pedido ao WS
            String validacao = wrapperWS.readResponse(responseWS);         //Passa a resposta para uma string

            Validation v = gson.fromJson(validacao, Validation.class);    //Conversão do objecto Json para o objecto Java
            int httpResponseCod = responseWS.getStatusLine().getStatusCode();
            if (httpResponseCod != 200) {
                log.error("\n\tError recovering password: " + v.getMsg() + "\tCod:" + httpResponseCod);
                log.error(v.getMsg());
                throw new RuntimeException("Ocorreu um erro no pedido de password");
            }

        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.debug("Password recovered with sucess");
    }
}
