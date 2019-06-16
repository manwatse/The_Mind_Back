package themindmessagemodelhelper;

import com.google.gson.Gson;
import messagesendingmodels.MessageGameStarted;
import messagesendingmodels.MessageUpdateQue;
import messagesendingmodels.PLayerInQueue;
import models.Player;

import java.util.ArrayList;

public class TheMindMessageModelHelper {

 //todo object to json encapsulatingmessage(String message, string object)
    public static String updateGame() {
        return null;
    }
    private static final Gson gson = new Gson();


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

    public static String Vote() {
        return null;
    }

    public static String emoji() {
        return null;
    }
}
