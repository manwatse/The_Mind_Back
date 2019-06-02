package themindmessagehandlers;

import com.google.gson.Gson;
import messagesreceivingmodels.PlayerReady;
import themindwebsocketlogic.ITheMindWebsocketLogic;

public class ReadyHandler {
    ITheMindWebsocketLogic logic;

    public ReadyHandler(ITheMindWebsocketLogic logic){
        this.logic=logic;
    }

    public void PlayerReady(String data,String sessionId){
        Gson gson = new Gson();
        PlayerReady playerReady= gson.fromJson(data,PlayerReady.class);
        logic.PlayerReady(playerReady.getPlayerId(),sessionId);

    }
}
