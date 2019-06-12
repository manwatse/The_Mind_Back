package themindwebsocketlogic;

import themindwebsocketevent.ITheMindEvent;
import themindwebsocketgamelogic.ITheMindWebsocketGameLogic;

public interface ITheMindWebsocketLogic {

    void setEventSockets(ITheMindEvent eventSockets);

    void PlayerReady(String id ,String sessionId);

    void CreateGame(int gameId);

    void JoinGame(String userid, String sessionId);

    void EndGameMessage(String sessionID, String winner);

    void UpdateGame();

    void RemoveGame(int gameId);

    void RemovePlayer(String sessionid);

    ITheMindWebsocketGameLogic getGame(int gameId);

    void UpdatePlayerScore(String playerid, int score, String sessionId);




}
