package themindwebsocketmessagecreator;

import java.util.ArrayList;

public interface ITheMindWebsocketMessageCreator {

     void MessageCreator(String action, String object, String sessionId);

     void MessageCreatorAll(String action, String object, ArrayList<String> sessionIds);
}
