package themindwebsocketlogic;

import themindwebsocketevent.ITheMindEvent;
import themindwebsocketgamelogic.ITheMindWebsocketGameLogic;

import java.util.ArrayList;

public interface ITheMindWebsocketLogic {

    void setEventSockets(ITheMindEvent eventSockets);

    void PlayerReady(String id ,String sessionId);

    void vote(String playerId,int gameId);

    void playCard(String playerId, int playedCard,String sessionId);

    void RemovePlayer(String sessionid);

    void emoji(String playerId,String emoji,String sessionId);

    ITheMindWebsocketGameLogic getGame(int gameId);

    public void GetScores(String sessionId);




}
