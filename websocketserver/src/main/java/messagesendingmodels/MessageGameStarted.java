package messagesendingmodels;

import models.Player;

import java.util.ArrayList;

public class MessageGameStarted {

    private int gameId;
    private int lifePoints;
    private int votes;
    private ArrayList<Player> players;

    public MessageGameStarted(int gameId, int lifePoints, int votes, ArrayList<Player> players) {
        this.gameId = gameId;
        this.lifePoints = lifePoints;
        this.votes = votes;
        this.players = players;
    }
}
