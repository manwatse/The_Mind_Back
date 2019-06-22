package themindrestserver;

import java.util.ArrayList;
import java.util.List;
import models.PlayerScore;

public interface ITheMindFirebaseDB {

    ArrayList<PlayerScore> getHighscores();

    boolean setPlayerScore(String playerId,int score);

    PlayerScore getPlayerScore(String PlayerId);

    PlayerScore createPlayerScore(String PlayerId);

    boolean checkIfPlayerExist(String playerId);

}
