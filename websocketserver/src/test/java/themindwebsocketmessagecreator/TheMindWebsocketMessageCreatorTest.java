package themindwebsocketmessagecreator;

import Stubs.TheMindEventStub;
import com.google.gson.Gson;

import org.junit.Assert;
import org.junit.Test;
import shared.EncapsulatingMessage;

import java.util.ArrayList;

public class TheMindWebsocketMessageCreatorTest {

    TheMindEventStub stub = new TheMindEventStub();
    Gson gen = new Gson();

    @Test
    public void messageCreator() {
        EncapsulatingMessage test = new EncapsulatingMessage("sentToUser","object");
        String sessionId="session-1";

        stub.sendMessage(gen.toJson(test),sessionId);

        String expectedSessionId="session-1";
        EncapsulatingMessage expected = new EncapsulatingMessage("sentToUser","object");


        Assert.assertEquals(expectedSessionId,stub.getSessionid());
        Assert.assertEquals(gen.toJson(expected),stub.getMessage());

    }

    @Test
    public void messageCreatorGroup() {
        EncapsulatingMessage test = new EncapsulatingMessage("sentToGroup","object");
        ArrayList<String> testSessionList= new ArrayList<>();
        testSessionList.add("session-1");

        stub.sendMessageToSendGroup(gen.toJson(test),testSessionList);

        EncapsulatingMessage expected = new EncapsulatingMessage("sentToGroup","object");
        String expectedSession="session-1";

        Assert.assertEquals(expectedSession,stub.getSessionlist().get(0));
        Assert.assertEquals(gen.toJson(expected),stub.getMessage());

    }
    @Test
    public void MessageCreatorAll() {

        EncapsulatingMessage test = new EncapsulatingMessage("broadcast","object");

        stub.sendMessageToSendToAll(gen.toJson(test));

        EncapsulatingMessage expected = new EncapsulatingMessage("broadcast","object");
        Assert.assertEquals(gen.toJson(expected),stub.getMessage());
    }
}