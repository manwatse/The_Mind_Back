package themindrestserver;

import java.util.ArrayList;
import java.util.List;
import models.PlayerScore;

public class TheMindRESTLogic implements ITheMindRESTLogic {

    ITheMindFirebaseDB databaseConn;
    public TheMindRESTLogic(ITheMindFirebaseDB databaseConn){
        this.databaseConn=databaseConn;
    }


    public PlayerScore createPlayerScore(String data) {
        try {
            return databaseConn.createPlayerScore(data);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public PlayerScore getPlayerScore(String playerid) {
        try {
            return databaseConn.getPlayerScore(playerid);

        }
        catch (Exception e){
            System.out.println(e);
            return  null;
        }
    }

    public void setPlayerScore(String playerId, int score) {
        try {
            databaseConn.setPlayerScore(playerId,score);

        }catch (Exception e){
            System.out.println(e);

        }
    }

    public ArrayList<PlayerScore> getHighscores() {
        try {
            return databaseConn.getHighscores();
        }
        catch (Exception e){
            System.out.println(e);
            return  null;
        }
    }
}
