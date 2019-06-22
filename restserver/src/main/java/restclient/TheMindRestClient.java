package restclient;

import com.google.gson.Gson;
import models.PlayerScore;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import shared.PlayerScoreDTO;
import shared.PlayerScoreResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class TheMindRestClient {

    private final Gson gson = new Gson();
    private final  String url="http://localhost:8091/themind";

    public TheMindRestClient() {
    }

    public PlayerScoreDTO createPlayer(String playerId,int score){
        PlayerScoreDTO create = new PlayerScoreDTO(playerId,score);
        String query="/player/create/";
        PlayerScoreResponse response = queryPost(create,query);
        return response.getScores().get(0);
    }

    public PlayerScoreDTO getPlayer(String playerId){
        String query ="/score/findByID/"+playerId;
        PlayerScoreResponse response = queryGet(query);
        return  response.getScores().get(0);
    }

    public boolean setPlayerScore(String playerId,int score){
        PlayerScoreDTO setScore= new PlayerScoreDTO(playerId,score);
        String query="/score/setScore";
        PlayerScoreResponse response=queryPut(setScore,query);
        return response.isSuccess();
    }

    public List<PlayerScoreDTO> getAllScores(){
        String query="/score/all";
        PlayerScoreResponse response=queryGet(query);
        return response.getScores();
    }

    private PlayerScoreResponse queryPost(PlayerScoreDTO petRequest, String queryPost) {

        // Build the query for the REST service
        final String query = url + queryPost;


        // Execute the HTTP POST request
        HttpPost httpPost = new HttpPost(query);
        httpPost.addHeader("content-type", "application/json");
        StringEntity params;
        try {
            params = new StringEntity(gson.toJson(petRequest));
            httpPost.setEntity(params);
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        }
        return restRequest(httpPost);
    }

    private PlayerScoreResponse queryGet(String queryGet){
        final String query = url + queryGet;
        HttpGet httpGet = new HttpGet(query);
        return restRequest(httpGet);
    }

    private PlayerScoreResponse queryPut(PlayerScoreDTO petRequest, String queryPut) {

        // Build the query for the REST service
        final String query = url + queryPut;
        // Execute the HTTP PUT request
        HttpPut httpPut = new HttpPut(query);
        httpPut.addHeader("content-type", "application/json");
        StringEntity params;
        try {
            params = new StringEntity(gson.toJson(petRequest));
            httpPut.setEntity(params);
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        }
        return restRequest(httpPut);
    }

    private PlayerScoreResponse restRequest(HttpUriRequest httpUriRequest){
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpUriRequest);
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            PlayerScoreResponse playerScoreResponse = gson.fromJson(entityString, PlayerScoreResponse.class);
            return  playerScoreResponse;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            PlayerScoreResponse playerScoreResponse = new PlayerScoreResponse();
            return  playerScoreResponse;
        } catch (IOException e) {
            e.printStackTrace();
            PlayerScoreResponse playerScoreResponse = new PlayerScoreResponse();
            return  playerScoreResponse;
        }
    }


}
