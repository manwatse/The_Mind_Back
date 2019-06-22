package themindmessagemodelhelper;

import com.google.gson.Gson;
import messagesendingmodels.*;
import models.Player;
import models.Score;

import java.util.ArrayList;

public class TheMindMessageModelHelper {
    private static final Gson gson = new Gson();


    public static String updateGame(ArrayList<Player> players, String actor, int lastPlayed, int level, int gameid, int votes,int lifepoints,boolean gameWon) {
        MessageUpdateGame response = new MessageUpdateGame(players,actor,lastPlayed,level,gameid,votes,lifepoints,gameWon);
        return gson.toJson(response);
    }

    public static String playerReady() {
        PLayerInQueue response= new PLayerInQueue();
        return  gson.toJson(response);
    }

    public static String UpdateQueue(int players){
        MessageUpdateQue response = new MessageUpdateQue(players);
        return  gson.toJson(response);

    }
    public static  String GameStarted(int gameId, int lifepoints, int votes, ArrayList<Player> players) {
        MessageGameStarted response = new MessageGameStarted(gameId,lifepoints,votes,players);

        return gson.toJson(response);
    }
    public  static String GetScore(ArrayList<Score>scores){
        System.out.println(scores.get(0));
        MessageScores response= new MessageScores(scores);
        return gson.toJson(response);
    }

    public static String Vote() {
        return null;
    }

    public static String emoji() {
        return null;
    }
}
