package themindmessagemodelhelper;

import com.google.gson.Gson;
import messagesendingmodels.MessageUpdateQue;
import messagesendingmodels.PLayerInQueue;

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

    public static String MorePlayers(int players){
        MessageUpdateQue response = new MessageUpdateQue(players);
        return  gson.toJson(response);

    }


    public static String Vote() {
        return null;
    }

    public static String emoji() {
        return null;
    }
}
