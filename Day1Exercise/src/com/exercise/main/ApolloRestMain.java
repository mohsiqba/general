package com.exercise.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApolloRestMain {
	//oidc/endpoint/default/token
    private static final String BASE_URL = "https://apisecurity-test.ite1.idng.ibmcloudsecurity.com";
    private static String AUTH_URL = BASE_URL + "/oidc/endpoint/default/token";
    private static final String CLIENT_ID = "maas360_W337u96F";
    private static final String CLIENT_SECRET = "WU4CT1CdZA";
    private static final String M360_SRV_URL = BASE_URL + "/m360bridgesvc/v1.0/statusDetails/id/billing1:csn-1:user1";

    public static void main(String[] args) throws IOException {
        sendRequest();
    }

    private static void sendRequest() throws IOException {
        HttpClient client = HttpClientBuilder.create()
                                             .build();
        HttpPost req = new HttpPost(AUTH_URL);
        req.addHeader("Content-Type", "application/x-www-form-urlencoded");

        List<NameValuePair> params = new ArrayList<NameValuePair>() {
            {
                add(new BasicNameValuePair("client_id", CLIENT_ID));
                add(new BasicNameValuePair("scope", "openid"));
                add(new BasicNameValuePair("username", "maas360@in.ibm.com"));
                add(new BasicNameValuePair("response_type", "token"));
                add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
                add(new BasicNameValuePair("grant_type", "client_credentials"));

            }
        };

        req.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(req);
        System.out.println("response status code:" + response.getStatusLine()
                                                             .getStatusCode());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity()
                                                                                         .getContent()));
        StringBuffer data = new StringBuffer();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            data.append(line);
        }
        System.out.println("data:"+data);

        bufferedReader.close();

        JsonParser parser = new JsonParser();
        JsonObject tokenObject = parser.parse(data.toString())
                                       .getAsJsonObject();
        String token = tokenObject.get("access_token")
                                  .getAsString();
        System.out.println("token: " + token);

        HttpGet svcReq = new HttpGet(M360_SRV_URL);
        //req.addHeader("Content-Type", "application/json");
        svcReq.addHeader("Accept", "application/json");
        svcReq.addHeader("Authorization", "Bearer " + token);

        response = client.execute(svcReq);

        System.out.println("response status code:" + response.getStatusLine()
                                                             .getStatusCode());
        bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity()
                                                                          .getContent()));
        data = new StringBuffer();
        line = "";
        while ((line = bufferedReader.readLine()) != null) {
            data.append(line);
        }
        System.out.println("response content:" + data);

        bufferedReader.close();


    }
}
