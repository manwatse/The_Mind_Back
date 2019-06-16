package themindrestserver;

import java.util.ArrayList;
import java.util.List;
import models.PlayerScore;

public interface ITheMindRESTLogic {

    ArrayList<PlayerScore> getHighscores();

    boolean setPlayerScore(String playerId,int score);

    int getPlayerScore(String playerid);

    boolean createPlayerScore(String data);
}
