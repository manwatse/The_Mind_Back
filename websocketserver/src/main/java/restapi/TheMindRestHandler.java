package restapi;

import models.Score;

public class TheMindRestHandler implements ITheMindRestHandler {

    //todo fix rest extend abstract class from rest logic.
    private final String url = "http://localhost:8091/Themind/";

    @Override
    public void setScore(Score score) {

//        SetHighscoresPUTDto dto = new SetHighscoresPUTDto(score);
//        executeQueryPost(dto, getQuery("/Highscores/put/"), BoolResultDto.class);
//
    }

    @Override
    public String getPlayerName(String userId) {
//        GetPlayerRequestDto dto = new GetPlayerRequestDto(userId);
//        GetPlayerResultDto result = executeQueryPost(dto, getQuery("/player/getPlayer/"), GetPlayerResultDto.class);
//        return result.getPlayerId();
        return  null;
    }
    private String getQuery(String path) {
        return url + path;
    }

}
