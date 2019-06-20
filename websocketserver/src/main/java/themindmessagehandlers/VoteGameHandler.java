package themindmessagehandlers;

import com.google.gson.Gson;
import messagesreceivingmodels.MessageSendVote;
import themindwebsocketlogic.ITheMindWebsocketLogic;

public class VoteGameHandler {
    ITheMindWebsocketLogic logic;

    public VoteGameHandler(ITheMindWebsocketLogic logic) {
        this.logic = logic;
    }

    public void playerVote(String data,String sessionid){
        Gson gson = new Gson();
        MessageSendVote messageSendVote = gson.fromJson(data,MessageSendVote.class);
        logic.vote(messageSendVote.getPlayerId(),messageSendVote.getGameId());
    }
}
