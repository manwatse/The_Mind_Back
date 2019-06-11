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

    //todo  card played
    void Cardplayed( int card);


    int getGameId();

    void vote();

    Boolean checkCards();

    ArrayList<Player> getPlayers();

    void resetDeck();

    void removeLastCardFromPlayers(ArrayList<Player> players);

}
