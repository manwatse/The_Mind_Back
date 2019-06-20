package themindwebsocketgamelogic;

import models.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TheMindWebsocketGameLogic implements ITheMindWebsocketGameLogic {

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Integer> cards = new ArrayList<Integer>();

    private int votes;
    private int lifePoints = 10;
    private int gameId;
    private int level;
    private int lastPlayedCard;
    private Boolean gameStarted = false;
    private ArrayList<String> sessionIds = new ArrayList<String>();

    public TheMindWebsocketGameLogic(int gameId) {

        resetDeck();
        Collections.shuffle(cards);
        this.gameId = gameId;

    }

    @Override
    public void join(Player player) {
        players.add(player);

        if (players.size() == 2) {
            StartGame();
        }


    }

    @Override
    public void StartGame() {
        gameStarted = true;
        level = 1;
        dealCards();
    }

    @Override
    public void nextLevel() {
        votes = 0;
        level++;
        resetDeck();
        dealCards();

    }

    @Override
    public void dealCards() {
        Collections.shuffle(cards);
        for (Player p : players) {
            for (int temp = 1; temp <= level; temp++) {

                p.addCard(cards.get(cards.size() - 1));
                cards.remove(cards.size() - 1);
            }

        }

    }

    @Override
    public void leave(String sessionId) {
        for (Player p : players) {
            if (p.getSessionId().equals(sessionId)) {
                players.remove(p);
            }
        }

    }

    @Override
    public void endGame() {
        if (lifePoints == 0) {
            //todo message gameover + remove game session
        } else if (level == 26 && players.size() == 4) {
            //todo message victory + remove game session
        } else if (level == 34 && players.size() == 3) {
            //todo message victory + remove game session
        } else if (level == 51 && players.size() == 2) {
            //todo message victory + remove game session
        }

    }

    @Override
    public void Cardplayed(int card) {


        votes = 0;
        lastPlayedCard = card;
        for (Player p : players) {
            for (int i=0;i<p.getCards().size();i++){

                if (card >p.getCards().get(i)) {
                    lifePoints--;
                    endGame();
                    System.out.println("lost life");

                    p.removeCard(i);
                }
                if (card == i) {
                    System.out.println("correct");

                    p.removeLastCard();
                }
            }

        }
        if (checkCards()) {
            nextLevel();
        }


    }

    @Override
    public void vote() {
        if (players.size() == 3 && votes == 3) {
            removeLastCardFromPlayers(players);
        } else if (players.size() == 2 && votes == 2) {
            removeLastCardFromPlayers(players);
        }


    }

    @Override
    public Boolean checkCards() {
        Boolean empty = false;
        for (int i=0;i<players.size();i++){
            if (players.get(i).getCards().size() == 0) {
                empty = true;
            } else {
                empty= false;
            }
        }
        for (Player p : players) {

        }
        return empty;
    }

    @Override
    public void resetDeck() {
        this.cards.add(1);
        this.cards.clear();
        for (int i = 1; i <= 100; i++) {
            this.cards.add(i);
        }
    }

    @Override
    public void removeLastCardFromPlayers(ArrayList<Player> players) {

        for (Player p : players) {
            p.getLastCard();
            //todo send message vote succesfull
            p.removeLastCard();
        }

    }

    @Override
    public void removePlayer(String sessionId) {
        for (Player p : players) {
            if (p.getSessionId().equals(sessionId)) {
                players.remove(p);
            }
        }
    }

    @Override
    public ArrayList<String> getSessionIds() {
        sessionIds.clear();
        for (Player p : players) {
            sessionIds.add(p.getSessionId());
        }
        return sessionIds;
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public Boolean gameStarted() {
        return gameStarted;
    }


    public int getGameId() {
        return gameId;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getVotes() {
        return votes;
    }

    public int getLastPlayedCard() {
        return lastPlayedCard;
    }

    public int getLevel() {
        return level;
    }

    public Boolean getGameStarted() {
        return gameStarted;
    }

    public boolean searchForPlayer(String sessionId) {


        if(Arrays.asList(sessionIds).contains(sessionIds)){
            return true;
        }
        else {
            return false;
        }

    }
}
