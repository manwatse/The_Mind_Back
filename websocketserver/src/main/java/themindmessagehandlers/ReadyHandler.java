package themindmessagehandlers;

import com.google.gson.Gson;
import messagesreceivingmodels.MessagePlayerJoinQueue;
import themindwebsocketlogic.ITheMindWebsocketLogic;

public class ReadyHandler {
    ITheMindWebsocketLogic logic;

    public ReadyHandler(ITheMindWebsocketLogic logic){
        this.logic=logic;
    }

    public void PlayerReady(String data,String sessionId){
        Gson gson = new Gson();
        MessagePlayerJoinQueue messagePlayerJoinQueue = gson.fromJson(data, MessagePlayerJoinQueue.class);
        logic.PlayerReady(messagePlayerJoinQueue.getPlayerId(),sessionId);

    }
}
