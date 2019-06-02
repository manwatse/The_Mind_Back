package themindwebsocketlogic;

import themindwebsocketevent.ITheMindEvent;
import themindwebsocketgamelogic.ITheMindWebsocketGameLogic;

public interface ITheMindWebsocketLogic {

    void setEventSockets(ITheMindEvent eventSockets);

    void PlayerReady(String playerId,String sessionId);

    void CreateGame(String gametype, String userId, String sessionId);

    void JoinGame(int gameId, String userId, String sessionId);

    void EndGameMessage(String sessionID, String winner);

    void UpdateGame();

    void RemoveGame(ITheMindWebsocketGameLogic game);

    ITheMindWebsocketGameLogic getGame(String sessionId);

    void UploadScores(String name, int score, String gameType);

    void UpdatePlayerScore(int player, int score, String sessionId);

}
