package themindwebsocketevent;

import javax.websocket.CloseReason;
import javax.websocket.Session;
import java.util.ArrayList;

public interface ITheMindEvent {

    void onConnect(Session session);

    void onText(String message, Session session);

    void onClose(CloseReason reason, Session session);

    void onError(Throwable cause, Session session);

    void sendMessage(String message,String sessionId);

    void sendMessageToAll(String message, ArrayList<String> sessionIds);
}
