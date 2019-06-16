package themindwebsocketevent;

import themindwebsocketlogic.ITheMindWebsocketLogic;
import themindwebsocketmessageprocessor.ITheMindWebsocketMessageProcessor;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@ServerEndpoint(value = "/TheMind/websocket/")

public class TheMindEvent implements ITheMindEvent {
    ITheMindWebsocketMessageProcessor messageProcessor;
    ITheMindWebsocketLogic logic;
    static HashSet<Session> sessions = new HashSet<>();

    public TheMindEvent(ITheMindWebsocketLogic logic, ITheMindWebsocketMessageProcessor messageProcessor) {
        this.logic = logic;
        this.messageProcessor = messageProcessor;
    }
    @OnOpen
    public void onConnect(javax.websocket.Session session) {
        sessions.add(session);
        System.out.println("[Connected] SessionID:" + session.getId());

    }

    @OnMessage
    public void onText(String message, Session session) {
        System.out.println("[Session ID] : " + session.getId() + " [Received] : " + message);
        messageProcessor.processMessage(message, session.getId());
    }

    @OnClose
    public void onClose(javax.websocket.CloseReason reason, Session session) {
        System.out.println("[Session ID] : " + session.getId() + "[Socket Closed: " + reason);
        try {
            logic.RemovePlayer(session.getId());
        } catch (Exception e) {
            System.out.println(e);
        }
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable cause, Session session) {
        System.out.println("[Session ID] : " + session.getId() + "[ERROR]: ");
        cause.printStackTrace(System.err);
    }

    public void sendMessage(String message, String sessionID) {
        for (javax.websocket.Session session : sessions) {
            if (session.getId() == sessionID) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public void sendMessageToAll(String message, ArrayList<String> sessionIds) {
        System.out.println("Send to group");
        for (String s: sessionIds) {
            sendMessage(message,s);
        }
    }


}
