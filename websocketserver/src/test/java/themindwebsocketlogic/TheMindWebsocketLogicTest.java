package themindwebsocketlogic;

import Stubs.TheMindWebsocketGameLogicStub;
import junit.framework.Assert;
import models.Player;
import org.junit.Before;
import org.junit.Test;
import themindwebsocketgamelogic.TheMindWebsocketGameLogic;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TheMindWebsocketLogicTest {

    TheMindWebsocketGameLogicStub stub = new TheMindWebsocketGameLogicStub();
    ArrayList<TheMindWebsocketGameLogic> games = new ArrayList<>();

    @Before
    public  void initialize() {
        games.add(new TheMindWebsocketGameLogic(1));
        games.get(0).join(new Player("playerid1","session1"));
        games.get(0).join(new Player("playerid2","session2"));

    }

    @Test
    public void createGame() {
        games.add(new TheMindWebsocketGameLogic(1));

        Assert.assertEquals(2,games.size());
    }

    @Test
    public void joinGame() {
        stub.join(new Player("playerid2","session2"));

        Assert.assertEquals(2,stub.getPlayers().size());
    }

    @Test
    public void updateQueue() {
        int expected=2;
        Assert.assertEquals(expected,games.get(0).getPlayers().size());

    }

    @Test
    public void playCard() {
        stub.Cardplayed(5);

        Assert.assertEquals(5,stub.getLastPlayedCard());
    }

    @Test
    public void removeGame() {
        Assert.assertEquals(1,this.games.size());
        this.games.remove(0);
        Assert.assertEquals(0,this.games.size());
    }

    @Test
    public void removePlayer() {
        Assert.assertEquals(1,stub.getPlayers().size());

        stub.removePlayer("session-1");
        Assert.assertEquals(0,stub.getPlayers().size());

    }

    @Test
    public void getGame() {
        TheMindWebsocketGameLogic expected=new TheMindWebsocketGameLogic(1);

        Assert.assertEquals(expected.getGameId(),this.games.get(0).getGameId());
    }

}