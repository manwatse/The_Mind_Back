package themindmessagehandlers;

import com.google.gson.Gson;
import shared.EmojiMessage;
import themindwebsocketlogic.ITheMindWebsocketLogic;

public class EmojiHandler {
    ITheMindWebsocketLogic logic;

    public EmojiHandler(ITheMindWebsocketLogic logic) {
        this.logic = logic;
    }

    public void  sendEmoji(String data,String sessionid){
        Gson gson = new Gson();
        EmojiMessage message = gson.fromJson(data,EmojiMessage.class);
        logic.emoji(message.getPlayerId(),message.getEmoji(),sessionid);
    }
}
