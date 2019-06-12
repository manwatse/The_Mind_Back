package themindwebsocketlogic;

import models.Player;
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
    public void PlayerReady(String id,String sessionId) {
        if (games.isEmpty())
        {
            CreateGame(gameId);
        }
        else {
            JoinGame(id,sessionId);

        }

        messageCreator.MessageCreator("ReadyRecieved", TheMindMessageModelHelper.playerReady(),sessionId);
    }

    //todo game logic
    @Override
    public void CreateGame(int gameId) {
        gameId++;
        TheMindWebsocketGameLogic g = new TheMindWebsocketGameLogic(gameId);
        games.add(g);
    }

    @Override
    public void JoinGame(String userid, String sessionId) {
        TheMindWebsocketGameLogic last = games.get(games.size()-1);

        for (TheMindWebsocketGameLogic g:games) {
            if(g.gameStarted()==false){
                g.join(new Player(sessionId,userid));
            }
            else if(last.gameStarted()){
                CreateGame(gameId);
                TheMindWebsocketGameLogic finalLast = games.get(games.size()-1);
                finalLast.join(new Player(sessionId,userid));

            }
        }
    }

    @Override
    public void EndGameMessage(String sessionID, String winner) {

    }

    @Override
    public void UpdateGame() {

    }

    @Override
    public void RemoveGame(int gameId) {
        for (TheMindWebsocketGameLogic g : games) {
            if (gameId==g.getGameId()){
                games.remove(g);
            }
        }

    }

    @Override
    public ITheMindWebsocketGameLogic getGame(int gameId) {

        for (TheMindWebsocketGameLogic g : games) {
            if (gameId==g.getGameId()){
                return g;
            }
        }
        return null;
    }



    @Override
    public void UpdatePlayerScore(String playerId, int score, String sessionId) {

    }
}
