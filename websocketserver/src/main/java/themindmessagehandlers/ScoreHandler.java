package themindmessagehandlers;

import com.google.gson.Gson;
import messagesreceivingmodels.MessageGetScores;
import themindwebsocketlogic.ITheMindWebsocketLogic;

public class ScoreHandler {
    ITheMindWebsocketLogic logic;

    public ScoreHandler(ITheMindWebsocketLogic logic) {
        this.logic = logic;
    }

    public void getScores(String data,String sessionid){
        Gson gson = new Gson();
        MessageGetScores messageGetScores= gson.fromJson(data,MessageGetScores.class);
        logic.GetScores(sessionid);
    }
}
