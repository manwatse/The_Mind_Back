package themindwebsocketmessageprocessor;

import themindmessagehandlers.*;
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


        switch (messageType) {
            default:
                System.out.println("Unknown action");
                break;
            case "MessagePlayerJoinQueue":
                ReadyHandler readyHandler = new ReadyHandler(logic);
                readyHandler.PlayerReady(messageObject.getObject(),sessionId);
                break;
            case "MessageCardPlayed":
                System.out.println("card played");
                CardPlayedHandler cardPlayedHandler = new CardPlayedHandler(logic);
                cardPlayedHandler.cardPlayed(messageObject.getObject(),sessionId);
                break;
            case "MessageGetScores":
                ScoreHandler scoreHandler = new ScoreHandler(logic);
                scoreHandler.getScores(messageObject.getObject(),sessionId);

                break;
            case "Vote":
                VoteGameHandler voteGameHandler = new VoteGameHandler(logic);
                voteGameHandler.playerVote(messageObject.getObject(),sessionId);
                break;
            case "emoji":
                EmojiHandler emojiHandler= new EmojiHandler(logic);
                emojiHandler.sendEmoji(messageObject.getObject(),sessionId);
                break;
        }
    }
}
