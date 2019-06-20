package themindwebsocketgamelogic;

import models.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TheMindWebsocketGameLogicTest {

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Integer> cards = new ArrayList<Integer>();

    private int votes;
    private int lifePoints = 10;
    private int gameId;
    private int level;
    private int lastPlayedCard;
    private Boolean gameStarted;
    private ArrayList<String> sessionIds = new ArrayList<java.lang.String>();


    @Before
    public void initialize() {
        gameStarted = false;
        gameId=1;
        level = 0;
        sessionIds.add("session1");
        sessionIds.add("session2");
        for (int i = 1; i <= 3; i++) {
            Player p = new Player("Player" + Integer.toString(i), "sessionId" + Integer.toString(i));
            players.add(p);
        }
        for (int i = 1; i <= 100; i++) {
            cards.add(i);
        }

    }

    @Test
    public void join() {
        Player p = new Player("Player1Id", "sessionId");
        players.add(p);

        Assert.assertEquals(4, players.size());
    }

    @Test
    public void startGame() {
        Assert.assertEquals(false, this.gameStarted);
        this.gameStarted = true;
        assertEquals(true, this.gameStarted);

    }

    @Test
    public void nextLevel() {
        Assert.assertEquals(0, this.level);
        this.level++;
        Assert.assertEquals(1, this.level);
    }

    @Test
    public void dealCards() {
        Player p = players.get(1);
        p.addCard(5);
        cards.remove(6);
        Assert.assertEquals(5, p.getCards().get(0));

    }

    @Test
    public void leave() {
        int playerid = 1;
        Assert.assertEquals(3, this.players.size());

        this.players.remove(playerid);
        Assert.assertEquals(2, players.size());
    }


    @Test
    public void endGame() {
        this.level = 25;

        Assert.assertEquals(25, this.level);
    }

    @Test
    public void cardplayed() {
        int playedCard = 2;
        this.lastPlayedCard = playedCard;
        Assert.assertEquals(2, lastPlayedCard);
    }

    @Test
    public void vote() {
        this.votes++;
        Assert.assertEquals(1, this.votes);
    }

    @Test
    public void checkCards() {
        Assert.assertEquals(0, players.get(0).getCards().size());
    }

    @Test
    public void resetDeck() {

        cards.clear();
        for (int i = 1; i <= 100; i++) {
            cards.add(i);
        }
        Assert.assertEquals(100, this.cards.size());
    }

    @Test
    public void removeLastCardFromPlayers() {
    }

    @Test
    public void removePlayer() {
        players.remove(1);
        Assert.assertEquals(2, players.size());
    }

    @Test
    public void getSessionIds() {
        int counter=0;
        java.lang.String expected="session";

        for (java.lang.String s:sessionIds) {
            counter++;
            Assert.assertEquals(expected+Integer.toString(counter),s);
        }

    }

    @Test
    public void getPlayers() {
        int counter=0;

        for (Player p:players) {
            counter++;
            Player expected = new Player("Player" + Integer.toString(counter), "sessionId" + Integer.toString(counter));

            Assert.assertEquals(expected.getId(),p.getId());
            Assert.assertEquals(expected.getSessionId(),p.getSessionId());

        }

    }

    @Test
    public void gameStarted() {
        Assert.assertEquals(false,this.gameStarted);
    }

    @Test
    public void getGameId() {
        Assert.assertEquals(1,this.gameId);
    }

    @Test
    public void getLifePoints() {
        Assert.assertEquals(10,this.lifePoints);
    }

    @Test
    public void getVotes() {
        Assert.assertEquals(0,this.votes);
    }
}