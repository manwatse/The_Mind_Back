package TheMindWebsocketGameLogic;

import models.Player;

public interface ITheMindWebsocketGameLogic {


    void StartGame();


    //todo  card played
    void Cardplayed();

    void AddPlayer(Player player2);

    boolean checkSessionID(String sessionID);

    int getGameId();

    String getPlayer1Name();

    String getPlayer2Name();

    String getPlayer1SessionID();

    boolean checkAvailability();

    Player getPlayer2();

    Player[][] getField();
}
