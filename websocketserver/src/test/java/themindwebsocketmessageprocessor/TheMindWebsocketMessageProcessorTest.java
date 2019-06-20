package themindwebsocketmessageprocessor;

import Stubs.TheMindWebsocketLogicStub;
import com.google.gson.Gson;
import junit.framework.Assert;
import messagesreceivingmodels.MessageCardPlayed;
import messagesreceivingmodels.MessageGetScores;
import messagesreceivingmodels.MessagePlayerJoinQueue;
import messagesreceivingmodels.MessageSendVote;
import models.Player;
import models.Score;
import org.junit.Test;
import shared.EmojiMessage;
import shared.EncapsulatingMessage;

import static org.junit.Assert.*;

public class TheMindWebsocketMessageProcessorTest {

    TheMindWebsocketLogicStub logicStub = new TheMindWebsocketLogicStub();
    ITheMindWebsocketMessageProcessor messageProcessor = new TheMindWebsocketMessageProcessor(logicStub);
    Gson gson = new Gson();

    @Test
    public void processMessageJoinQueue() {
    String object = gson.toJson(new MessagePlayerJoinQueue("player1"));
    String message = gson.toJson(new EncapsulatingMessage("MessagePlayerJoinQueue",object));

    messageProcessor.processMessage(message,"Session-1");

    Assert.assertEquals("Player Joined", logicStub.getPlayerJoinedQueue());

    }
    @Test
    public void processMessageVote() {
        String object = gson.toJson(new MessageSendVote("playerId1",1));
        String message = gson.toJson(new EncapsulatingMessage("Vote",object));

        messageProcessor.processMessage(message,"session-1");

        Assert.assertEquals(1,logicStub.GetVote());
    }
    @Test
    public void processMessageEmoji() {
        String object =gson.toJson(new EmojiMessage("playerID1","smile"));
        String message = gson.toJson(new EncapsulatingMessage("emoji",object));

        messageProcessor.processMessage(message,"session-1");

        Assert.assertEquals("smile",logicStub.getEmoji());


    }
    @Test
    public void processMessageCardPlayed() {
        String object = gson.toJson(new MessageCardPlayed("playerId1",26));
        String message =gson.toJson(new EncapsulatingMessage("MessageCardPlayed",object));

        messageProcessor.processMessage(message,"session-1");

        Assert.assertEquals(26,logicStub.getPlayedCard());

    }
    @Test
    public void processMessageGetScore(){
        String object = gson.toJson(new MessageGetScores());
        String message = gson.toJson(new EncapsulatingMessage("MessageGetScores",object));

        messageProcessor.processMessage(message,"Session-1");

        Assert.assertEquals("player1",logicStub.getScores().get(0).getPlayerId());
        Assert.assertEquals(1,logicStub.getScores().get(0).getPlayerScore());

    }
}