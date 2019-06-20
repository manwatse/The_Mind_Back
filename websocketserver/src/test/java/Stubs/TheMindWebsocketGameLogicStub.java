package Stubs;

import models.Player;
import themindwebsocketgamelogic.ITheMindWebsocketGameLogic;

import java.util.ArrayList;

public class TheMindWebsocketGameLogicStub  {
    private ArrayList<Player> players= new ArrayList<>();

    public TheMindWebsocketGameLogicStub(){
        players.add(new Player("playerId1","Session-1"));
    }

    private int lastPlayedCard;




    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getLastPlayedCard() {
        return lastPlayedCard;
    }

    public void join(Player player) {
        this.players.add(player);
    }


    public void StartGame() {

    }


    public void nextLevel() {

    }


    public void dealCards() {

    }


    public void leave(String sessionId) {

    }


    public void endGame() {

    }


    public void Cardplayed(int card) {
        this.lastPlayedCard=card;

    }


    public void vote() {

    }


    public void resetDeck() {

    }


    public void removeLastCardFromPlayers(ArrayList<Player> players) {

    }


    public void removePlayer(String sessionId) {
        this.players.remove(0);
    }


    public int getGameId() {
        return 0;
    }





    public ArrayList<String> getSessionIds() {
        return null;
    }


    public Boolean checkCards() {
        return null;
    }


    public Boolean gameStarted() {
        return null;
    }
}
