/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ismart.ismartonline.services;

import br.org.ismart.ismartonline.models.User;
import br.org.ismart.ismartonline.tools.HmacKeyIsmart;
import com.amazonaws.util.json.JSONObject;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.adamcin.httpsig.api.Authorization;
import net.adamcin.httpsig.api.DefaultKeychain;
import net.adamcin.httpsig.api.RequestContent;
import net.adamcin.httpsig.api.Signer;

/**
 *
 * @author thiago
 */
public class ImaginieLogin {
    
    private User user;
    
    private static final String IMAGINIE_TOKEN_URL = "http://app.imaginie.com/api/v1/ext/auth/usertoken?user_id=";
    private static final String IMAGINIE_REDIRECT_URL = "http://app.imaginie.com/sso?access_token=";
    private static String IMAGINIE_API_KEY;
    private static String IMAGINIE_API_SECRET;

    public ImaginieLogin(User user) {
        this.user = user;
        this.IMAGINIE_API_KEY = System.getProperty("IMAGINIE_API_KEY");
        this.IMAGINIE_API_SECRET = System.getProperty("IMAGINIE_API_SECRET");
    }   
    
    public String connect() {
        String Xfixdate = new Date().toString();
        String url = IMAGINIE_TOKEN_URL + user.getLogin();
            
        Map<String, String> headers = new HashMap();
        headers.put("X-Api-Key", IMAGINIE_API_KEY);
        headers.put("Xfixdate", Xfixdate);
        headers.put("date", Xfixdate);

        DefaultKeychain keychain = new DefaultKeychain();
        HmacKeyIsmart hmackey = new HmacKeyIsmart(IMAGINIE_API_KEY, IMAGINIE_API_SECRET);
        keychain.add(hmackey);
        Signer signer = new Signer(keychain);


        RequestContent.Builder requestContentBuilder = new RequestContent.Builder();

        // set the HTTP request target
        requestContentBuilder.setRequestTarget("POST", url);

        // add each HTTP header in request order
        for (Map.Entry<String, String> header : headers.entrySet()) {
            requestContentBuilder.addHeader(header.getKey(), header.getValue());
        }
        Authorization authz = signer.sign(requestContentBuilder.build(), Arrays.asList("xfixdate"));
        if (authz != null) {
            String Signature = "keyId=\""+IMAGINIE_API_KEY+"\",algorithm=\"hmac-sha256\",headers=\"xfixdate\",signature=\""+authz.getSignature()+"\"";
            String Authorization = "Signature keyId=\""+IMAGINIE_API_KEY+"\",algorithm=\"hmac-sha256\",headers=\"xfixdate\",signature=\""+authz.getSignature()+"\"";

            Client client = ClientBuilder.newClient();
            Entity<String> payload = Entity.text("");
            WebTarget target = client.target(url);
            javax.ws.rs.client.Invocation.Builder request = target
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .header("X-Api-Key", IMAGINIE_API_KEY)
                    .header("Xfixdate", Xfixdate)
                    .header("authorization", Authorization)
                    .header("Signature", Signature);



            Response response = request.post(payload);
            String body = response.readEntity(String.class);

            try {
                JSONObject json = new JSONObject(body);
                if(json.has("token")){
                    String token = String.valueOf(json.get("token"));
                    String redirectURL = IMAGINIE_REDIRECT_URL + token;
                    return redirectURL;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return null;
    }
}
