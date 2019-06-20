package themindmessagehandlers;

import com.google.gson.Gson;
import messagesreceivingmodels.MessageCardPlayed;
import themindwebsocketlogic.ITheMindWebsocketLogic;

public class CardPlayedHandler {
    ITheMindWebsocketLogic logic;

    public CardPlayedHandler(ITheMindWebsocketLogic logic) {
        this.logic = logic;
    }

    public void cardPlayed(String data,String sessionid){
        Gson gson = new Gson();
        MessageCardPlayed messageCardPlayed= gson.fromJson(data,MessageCardPlayed.class);
        logic.playCard(messageCardPlayed.getPlayerId(),messageCardPlayed.getPlayedCard(),sessionid);


    }
}
