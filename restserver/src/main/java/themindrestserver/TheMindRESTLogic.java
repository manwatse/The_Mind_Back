package themindrestserver;

import java.util.ArrayList;
import java.util.List;
import models.PlayerScore;

public class TheMindRESTLogic implements ITheMindRESTLogic {

    ITheMindFirebaseDB databaseConn;
    public TheMindRESTLogic(ITheMindFirebaseDB databaseConn){
        this.databaseConn=databaseConn;
    }


    public ArrayList<PlayerScore> getHighscores() {
        try {
            if (databaseConn.getHighscores()!=null){
                return databaseConn.getHighscores();
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            System.out.println(e);
            return  null;
        }
    }

    public boolean setPlayerScore(String playerId, int score) {
        try {
            if(databaseConn.setPlayerScore(playerId,score)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public int getPlayerScore(String playerid) {
        try {
            if (databaseConn.getPlayerScore(playerid)!= (-1)){
                return databaseConn.getPlayerScore(playerid);
            }
            else{
                return -1;
            }

        }
        catch (Exception e){
            System.out.println(e);
            return  -1;
        }
    }

    public boolean createPlayerScore(String data) {

        try {
            if (databaseConn.createPlayerScore(data)){
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
