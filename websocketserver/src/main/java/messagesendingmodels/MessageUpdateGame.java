package messagesendingmodels;

import models.Player;

import java.util.ArrayList;

public class MessageUpdateGame {

    private ArrayList<Player> players;
    private String actor;
    private int lastPlayed;
    private int level;
    private int gameid;
    private int votes;
    private int lifepoints;

    public MessageUpdateGame(ArrayList<Player> players, String actor, int lastPlayed, int level, int gameid, int votes, int lifepoints) {
        this.players = players;
        this.actor = actor;
        this.lastPlayed = lastPlayed;
        this.level = level;
        this.gameid = gameid;
        this.votes = votes;
        this.lifepoints = lifepoints;
    }
}
