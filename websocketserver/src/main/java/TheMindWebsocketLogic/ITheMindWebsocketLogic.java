package TheMindWebsocketLogic;

import TheMindWebsocketEvent.ITheMindEvent;
import TheMindWebsocketGameLogic.ITheMindWebsocketGameLogic;

public interface ITheMindWebsocketLogic {

    void setEventSockets(ITheMindEvent eventSockets);

    void CreateGame(String gametype, String userId, String sessionId);

    void JoinGame(int gameId, String userId, String sessionId);

    void EndGameMessage(String sessionID, String winner);

    void UpdateGame();

    void RemoveGame(ITheMindWebsocketGameLogic game);

    ITheMindWebsocketGameLogic getGame(String sessionId);

    void UploadScores(String name, int score, String gameType);

    void UpdatePlayerScore(int player, int score, String sessionId);
}
