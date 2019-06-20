package themindwebsocketmessagecreator;

import themindwebsocketevent.ITheMindEvent;
import com.google.gson.Gson;
import shared.EncapsulatingMessage;

import java.util.ArrayList;

public class TheMindWebsocketMessageCreator implements  ITheMindWebsocketMessageCreator {

    ITheMindEvent event;
    Gson gson = new Gson();
    public TheMindWebsocketMessageCreator(ITheMindEvent event){
        this.event=event;
    }

    @Override
    public void MessageCreator(String action, String object, String sessionId) {

        event.sendMessage(gson.toJson(new EncapsulatingMessage(action, object)), sessionId);
    }

    @Override
    public void MessageCreatorGroup(String action, String object, ArrayList<String> sessionIds) {
        event.sendMessageToSendGroup(gson.toJson(new EncapsulatingMessage(action, object)),sessionIds);
    }

    @Override
    public void MessageCreatorAll(String action, String object) {
        event.sendMessageToSendToAll(gson.toJson(new EncapsulatingMessage(action,object)));

    }
}
