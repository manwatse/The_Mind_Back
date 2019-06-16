package themindrestserver;

import com.google.gson.Gson;
import dto.BaseResultDto;
import dto.BoolResultDto;
import dto.GetPlayerScoreDto;
import dto.HighscoreResultDto;
import models.PlayerScore;

import java.util.List;

public class ResponseHelper {

    public ResponseHelper(){}

    public  static  final Gson gson = new Gson();

    public static String getErrorResponseString(){
        BaseResultDto response = new BaseResultDto();
        response.setSuccess(false);
        return gson.toJson(response);
    }

    public static String getBooleanResultDtoResponseString(boolean check) {
        BoolResultDto response = new BoolResultDto(check);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getHighscoresResultDtcString(List<PlayerScore> highscores) {
        HighscoreResultDto response = new HighscoreResultDto(highscores);
        response.setSuccess(true);
        return gson.toJson(response);
    }
    public  static String getPLayerScoreResultDtoString(GetPlayerScoreDto getPlayerScoreDto){
        GetPlayerScoreDto response = getPlayerScoreDto;
        response.setSuccess(true);
        return gson.toJson(response);
    }

}
