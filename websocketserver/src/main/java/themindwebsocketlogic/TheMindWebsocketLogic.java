package themindwebsocketlogic;

import themindmessagemodelhelper.TheMindMessageModelHelper;
import themindwebsocketmessagecreator.ITheMindWebsocketMessageCreator;
import themindwebsocketmessagecreator.TheMindWebsocketMessageCreator;
import themindwebsocketevent.ITheMindEvent;
import themindwebsocketgamelogic.ITheMindWebsocketGameLogic;
import themindwebsocketgamelogic.TheMindWebsocketGameLogic;
import themindwebsocketmessageprocessor.ITheMindWebsocketMessageProcessor;
import restapi.ITheMindRestHandler;

import java.util.ArrayList;

public class TheMindWebsocketLogic implements  ITheMindWebsocketLogic {

    int gameId;
    ITheMindRestHandler rest;
    ITheMindWebsocketMessageCreator messageCreator;
    ITheMindEvent event;
    ITheMindWebsocketMessageProcessor messageProcessor;
    ArrayList<TheMindWebsocketGameLogic> games;

    public  TheMindWebsocketLogic(ITheMindRestHandler rest){
        this.rest = rest;
        gameId = 0;
        games = new ArrayList<>();

    }

    @Override
    public void setEventSockets(ITheMindEvent eventSockets) {
        this.event = eventSockets;
        messageCreator = new TheMindWebsocketMessageCreator(eventSockets);
    }

    @Override
    public void PlayerReady(String playerId,String sessionId) {
        messageCreator.MessageCreator("ReadyRecieved", TheMindMessageModelHelper.playerReady(),sessionId);
    }

    //todo game logic
    @Override
    public void CreateGame(String gametype, String userId, String sessionId) {

    }

    @Override
    public void JoinGame(int gameId, String userId, String sessionId) {

    }

    @Override
    public void EndGameMessage(String sessionID, String winner) {

    }

    @Override
    public void UpdateGame() {

    }

    @Override
    public void RemoveGame(ITheMindWebsocketGameLogic game) {
        games.remove(game);

    }

    @Override
    public ITheMindWebsocketGameLogic getGame(String sessionId) {
        return null;
    }

    @Override
    public void UploadScores(String name, int score, String gameType) {

    }

    @Override
    public void UpdatePlayerScore(int player, int score, String sessionId) {

    }
}
