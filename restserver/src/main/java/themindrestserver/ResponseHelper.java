package themindrestserver;

import com.google.gson.Gson;
import models.PlayerScore;
import shared.PlayerScoreDTO;
import shared.PlayerScoreResponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseHelper {

    public ResponseHelper(){}

    public  static  final Gson gson = new Gson();

    public static String getErrorResponse(){
        PlayerScoreResponse response = new PlayerScoreResponse();
        response.setSuccess(false);
        return gson.toJson(response);
    }

    public static String getSuccesReponse() {
        PlayerScoreResponse response = new PlayerScoreResponse();
        response.setSuccess(true);
        return gson.toJson(response);
    }


    public  static String getPLayerScoreResponse(PlayerScore playerScore){

        PlayerScoreResponse response = new PlayerScoreResponse();
        ArrayList<PlayerScoreDTO> scores = new ArrayList<>();
        PlayerScoreDTO score = playerScore.createDTO();
        scores.add(score);
        response.setScores(scores);
        response.setSuccess(true);
        return gson.toJson(response);
    }


    public static String getHighScoresResponse(List<PlayerScoreDTO> allScores) {

        PlayerScoreResponse response = new PlayerScoreResponse();
        response.setScores(allScores);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static  List<PlayerScoreDTO> getPlayerscoreDTOList(ArrayList<PlayerScore> allScoreFromFirecloud){

        List<PlayerScoreDTO> playerScoreDTOS= new ArrayList<>();
        for (PlayerScore p: allScoreFromFirecloud) {
            PlayerScoreDTO score = p.createDTO();
            playerScoreDTOS.add(score);
        }
        return playerScoreDTOS;
    }


}
