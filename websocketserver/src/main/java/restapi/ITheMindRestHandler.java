package restapi;

import models.Score;

public interface ITheMindRestHandler {
    void setScore(Score score);

    String getPlayerName(String userId);
}
