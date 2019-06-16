package themindwebsocketlogic;

import models.Player;
import models.Score;
import themindmessagemodelhelper.TheMindMessageModelHelper;
import themindwebsocketmessagecreator.ITheMindWebsocketMessageCreator;
import themindwebsocketmessagecreator.TheMindWebsocketMessageCreator;
import themindwebsocketevent.ITheMindEvent;
import themindwebsocketgamelogic.ITheMindWebsocketGameLogic;
import themindwebsocketgamelogic.TheMindWebsocketGameLogic;
import themindwebsocketmessageprocessor.ITheMindWebsocketMessageProcessor;
import restapi.ITheMindRestHandler;

import java.util.ArrayList;

public class TheMindWebsocketLogic implements ITheMindWebsocketLogic {

    int gameId;
    int numberOfPlayers;
    ITheMindRestHandler rest;
    ITheMindWebsocketMessageCreator messageCreator;
    ITheMindEvent event;
    ITheMindWebsocketMessageProcessor messageProcessor;
    ArrayList<TheMindWebsocketGameLogic> games= new ArrayList<TheMindWebsocketGameLogic>();
    ArrayList<Score> scores= new ArrayList<>();

    public TheMindWebsocketLogic(ITheMindRestHandler rest) {
        this.rest = rest;
        gameId = 0;


    }

    @Override
    public void setEventSockets(ITheMindEvent eventSockets) {
        this.event = eventSockets;
        messageCreator = new TheMindWebsocketMessageCreator(eventSockets);
    }

    @Override
    public void PlayerReady(String id, String sessionId) {
        if (games.isEmpty()) {
            CreateGame(gameId);
            JoinGame(id, sessionId);
        } else {
            JoinGame(id, sessionId);

        }
        messageCreator.MessageCreator("Joined Queue", TheMindMessageModelHelper.playerReady(), sessionId);
    }


    @Override
    public void CreateGame(int gameId) {
        gameId++;
        TheMindWebsocketGameLogic g = new TheMindWebsocketGameLogic(gameId);
        games.add(g);
    }

    @Override
    public void JoinGame(String userid, String sessionId) {
        TheMindWebsocketGameLogic last = games.get(games.size() - 1);
        Player newPlayer = new Player(userid, sessionId);

        for (TheMindWebsocketGameLogic g : games) {
            if (g.gameStarted() == false) {
                if (g.getPlayers().contains(newPlayer) == false) {
                    g.join(newPlayer);
                    this.numberOfPlayers = g.getPlayers().size();
                    UpdateQueue(g.getPlayers().size(),g.getSessionIds());
                    if (g.gameStarted()==true){
                        messageCreator.MessageCreatorAll("Game Started",TheMindMessageModelHelper.GameStarted
                                (g.getGameId(),g.getLifePoints(),g.getVotes(),g.getPlayers()),g.getSessionIds());
                    }
                }

            } else if (last.gameStarted()) {
                CreateGame(gameId);
                TheMindWebsocketGameLogic finalLast = games.get(games.size() - 1);
                finalLast.join(new Player(sessionId, userid));

            }
        }
    }


    @Override
    public void UpdateQueue(int numberOfPlayers,ArrayList<String> sessionIds) {

        messageCreator.MessageCreatorAll("More players", TheMindMessageModelHelper.UpdateQueue(numberOfPlayers), sessionIds);
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
            if (gameId == g.getGameId()) {
                games.remove(g);
            }
        }

    }

    @Override
    public void RemovePlayer(String sessionid) {
        for (TheMindWebsocketGameLogic g : games) {
            g.removePlayer(sessionid);
            if (g.getPlayers().size()==0){
                games.remove(g);
            }
        }
    }

    @Override
    public ITheMindWebsocketGameLogic getGame(int gameId) {

        for (TheMindWebsocketGameLogic g : games) {
            if (gameId == g.getGameId()) {
                return g;
            }
        }
        return null;
    }

    @Override
    public void UpdatePlayerScore(String playerId, int score, String sessionId) {

    }

    @Override
    public void GetPlayerScore(String playerid, String sessionId) {

    }

    @Override
    public void SetPlayerScore(String playerid, String sessionId) {

    }
}
