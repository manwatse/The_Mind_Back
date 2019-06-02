package TheMIndWebsocketMessageCreator;

import TheMindWebsocketEvent.ITheMindEvent;
import com.google.gson.Gson;
import shared.EncapsulatingMessage;

public class TheMindWebsocketMessageCreator implements  ITheMindWebsocketMessageCreator {

    ITheMindEvent event;
    public TheMindWebsocketMessageCreator(ITheMindEvent event){
        this.event=event;
    }

    @Override
    public void MessageCreator(String action, String object, String sessionId) {
        Gson gson = new Gson();
        event.sendMessage(gson.toJson(new EncapsulatingMessage(action, object)), sessionId);
    }
}
