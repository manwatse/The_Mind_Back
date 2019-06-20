package themindwebsocketgamelogic;

import models.Player;

import java.util.ArrayList;

public interface ITheMindWebsocketGameLogic {

    void join(Player player);

    void StartGame();

    void nextLevel();

    void dealCards();

    void leave(String sessionId);

    void endGame();

    void Cardplayed( int card);

    void vote();

    void resetDeck();

    void removeLastCardFromPlayers(ArrayList<Player> players);

    void removePlayer(String sessionId);

    int getGameId();

    ArrayList<Player> getPlayers();

    ArrayList<String> getSessionIds();

    Boolean checkCards();

    Boolean gameStarted();

}
