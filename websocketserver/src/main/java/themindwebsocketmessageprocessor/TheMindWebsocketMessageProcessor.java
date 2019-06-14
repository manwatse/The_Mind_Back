package themindwebsocketmessageprocessor;

import themindmessagehandlers.ReadyHandler;
import themindwebsocketlogic.ITheMindWebsocketLogic;
import com.google.gson.Gson;
import shared.EncapsulatingMessage;

public class TheMindWebsocketMessageProcessor implements  ITheMindWebsocketMessageProcessor {

    ITheMindWebsocketLogic logic;
    public  TheMindWebsocketMessageProcessor(ITheMindWebsocketLogic logic){this.logic=logic;}


    @Override
    public void processMessage(String msg, String sessionId) {
        Gson gson = new Gson();
        EncapsulatingMessage messageObject = gson.fromJson(msg,EncapsulatingMessage.class);
        String messageType=messageObject.getMessage();

        //todo add handlers

        switch (messageType) {
            default:
                System.out.println("Unknown action");
                break;
            case "MessagePlayerJoinQueue":
                ReadyHandler readyHandler = new ReadyHandler(logic);
                readyHandler.PlayerReady(messageObject.getObject(),sessionId);
                break;
            case "UpdateGame":

                break;
            case "Vote":

                break;
            case "emoji":

                break;
        }
    }
}
