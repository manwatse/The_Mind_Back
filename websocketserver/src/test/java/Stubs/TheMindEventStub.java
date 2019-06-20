package Stubs;

import themindwebsocketevent.ITheMindEvent;

import javax.websocket.CloseReason;
import javax.websocket.Session;
import java.util.ArrayList;

public class TheMindEventStub implements ITheMindEvent {

    private String message;
    private String sessionid;

    private ArrayList<String> sessionlist;

    public String getMessage() {
        return message;
    }

    public String getSessionid() {
        return sessionid;
    }


    public ArrayList<String> getSessionlist() {
        return sessionlist;
    }

    @Override
    public void onConnect(Session session) {

    }

    @Override
    public void onText(String message, Session session) {

    }

    @Override
    public void onClose(CloseReason reason, Session session) {

    }

    @Override
    public void onError(Throwable cause, Session session) {

    }

    @Override
    public void sendMessage(String message, String sessionId) {
        this.message=message;
        this.sessionid=sessionId;
    }

    @Override
    public void sendMessageToSendGroup(String message, ArrayList<String> sessionIds) {
        this.message=message;
        this.sessionlist=sessionIds;
    }

    @Override
    public void sendMessageToSendToAll(String message) {
        this.message=message;
    }
}
