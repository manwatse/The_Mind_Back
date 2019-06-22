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


import java.util.ArrayList;

public class TheMindWebsocketLogic implements ITheMindWebsocketLogic {

    int gameId;
    int numberOfPlayers;

    ITheMindWebsocketMessageCreator messageCreator;
    ITheMindEvent event;
    ITheMindWebsocketMessageProcessor messageProcessor;
    ArrayList<TheMindWebsocketGameLogic> games= new ArrayList<TheMindWebsocketGameLogic>();
    ArrayList<Score> scores= new ArrayList<>();

    public TheMindWebsocketLogic() {

        gameId = 0;
        scores.add(new Score("Mzn08P68YyT4ecysSjWg1sgBVcP2",0));
        scores.add(new Score("PM3ZVK5wPafXyZAoPBxOuhupJXa2",0));

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
    public void vote(String playerId, int gameId) {
        for (TheMindWebsocketGameLogic g:games) {
            if (gameId==g.getGameId()){
                g.vote();

            }
        }
    }


    @Override
    public void playCard(String playerId, int playedCard,String sessionId) {
        for (TheMindWebsocketGameLogic g:games) {
            if (g.searchForPlayer(sessionId)){
                g.Cardplayed(playedCard);
                messageCreator.MessageCreatorGroup("UpdateGame",TheMindMessageModelHelper.updateGame
                        (g.getPlayers(),playerId,g.getLastPlayedCard(),g.getLevel(),g.getGameId(),g.getVotes(),g.getLifePoints(),g.isGameWon()),g.getSessionIds());
                System.out.println("last played card "+ g.getLastPlayedCard() );
            }
        }


    }

    @Override
    public void GetScores(String sessionId) {
        messageCreator.MessageCreator("scores",TheMindMessageModelHelper.GetScore(this.scores),sessionId);

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
    public void emoji(String playerId, String emoji, String sessionId) {

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


    public void CreateGame(int gameId) {
        gameId++;
        TheMindWebsocketGameLogic g = new TheMindWebsocketGameLogic(gameId);
        games.add(g);
    }


    private void JoinGame(String userid, String sessionId) {
        TheMindWebsocketGameLogic last = games.get(games.size() - 1);
        Player newPlayer = new Player(userid, sessionId);

        for (TheMindWebsocketGameLogic g : games) {
            if (g.gameStarted() == false) {
                if (g.getPlayers().contains(newPlayer) == false) {
                    g.join(newPlayer);
                    this.numberOfPlayers = g.getPlayers().size();
                    UpdateQueue(g.getPlayers().size(),g.getSessionIds());
                    if (g.gameStarted()==true){
                        messageCreator.MessageCreatorGroup("Game Started",TheMindMessageModelHelper.GameStarted
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



    private void UpdateQueue(int numberOfPlayers,ArrayList<String> sessionIds) {

        messageCreator.MessageCreatorGroup("More players", TheMindMessageModelHelper.UpdateQueue(numberOfPlayers), sessionIds);
    }

    private void RemoveGame(int gameId) {

        for (TheMindWebsocketGameLogic g : games) {
            if (gameId == g.getGameId()) {
                games.remove(g);
            }
        }

    }


    public void UpdatePlayerScore(String playerId, int score, String sessionId) {

    }


    public void GetPlayerScore(String playerid, String sessionId) {

    }


    public void SetPlayerScore(String playerid, String sessionId) {

    }


}
