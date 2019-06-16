package themindwebsocketlogic;

import themindwebsocketevent.ITheMindEvent;
import themindwebsocketgamelogic.ITheMindWebsocketGameLogic;

import java.util.ArrayList;

public interface ITheMindWebsocketLogic {

    void setEventSockets(ITheMindEvent eventSockets);

    void PlayerReady(String id ,String sessionId);

    void CreateGame(int gameId);

    void JoinGame(String userid, String sessionId);

    void UpdateQueue(int numberOfPlayers, ArrayList<String> sessionIds);

    void EndGameMessage(String sessionID, String winner);

    void UpdateGame();

    void RemoveGame(int gameId);

    void RemovePlayer(String sessionid);

    ITheMindWebsocketGameLogic getGame(int gameId);

    void UpdatePlayerScore(String playerid, int score, String sessionId);

    void GetPlayerScore(String playerid,String sessionId);

    void SetPlayerScore(String playerid,String sessionId);




}
