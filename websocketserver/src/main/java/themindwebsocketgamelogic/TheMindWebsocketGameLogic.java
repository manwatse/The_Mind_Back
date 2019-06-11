package themindwebsocketgamelogic;

import models.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TheMindWebsocketGameLogic implements ITheMindWebsocketGameLogic{

    ArrayList<Player> players;
    ArrayList<Integer> cards;
    int votes;
    int lifePoints;
    int gameId;
    int level;
    int lastPlayedCard;

    public  TheMindWebsocketGameLogic(){
        resetDeck();
        Collections.shuffle(cards);
    }

    @Override
    public void join(Player player) {

        if (players.size()==4){
            StartGame();
        }
        else {
            players.add(player);
        }

    }

    @Override
    public void StartGame() {
        level=1;
        dealCards();
    }

    @Override
    public void nextLevel() {
        level++;
        resetDeck();
        dealCards();

    }

    @Override
    public void dealCards() {
        Collections.shuffle(cards);
        for (Player p:players) {
            for (int temp =level;temp==0;temp--){

                p.addCard(cards.get(cards.size()-1));
                cards.remove(cards.size()-1);
            }

        }

    }

    @Override
    public void leave(String sessionId) {
        for (Player p:players) {
            if (p.getSessionId()==sessionId){
                players.remove(p);
            }
        }

    }

    @Override
    public void endGame() {
        if(lifePoints==0){
            //todo message gameover + remove game session
        }
        else if (level==26&&players.size()==4) {
            //todo message victory + remove game session
        }
        else  if(level==34&& players.size()==3){
            //todo message victory + remove game session
        }
        else if (level==51&& players.size()==2){
            //todo message victory + remove game session
        }

    }

    @Override
    public void Cardplayed(int card) {


        if (checkCards()){
            nextLevel();
        }
        else {
            lastPlayedCard=card;
            for (Player p : players) {

                for (Integer i :p.getCards()) {
                    if (card>i){
                        lifePoints--;
                        endGame();
                        //todo message lost cards
                        p.removeCard(i);
                    }
                    if (card==i){
                        //todo message card played.
                        p.removeLastCard();
                    }
                }
            }
        }

    }



    @Override
    public int getGameId() {
        return gameId;
    }

    @Override
    public void vote() {
        if (players.size()==3&&votes==3){
            removeLastCardFromPlayers(players);
        }
        else if (players.size()==2&&votes==2){
            removeLastCardFromPlayers(players);
        }


    }

    @Override
    public Boolean checkCards() {
        Boolean empty=false;
        for (Player p:players) {
            if (players.size()==0){
                empty= true;
            }
            else {
                return  false;
            }
        }
        return empty;
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public void resetDeck() {
        cards.clear();
        for (int i =1;i==100;i++){
            cards.add(i);
        }
    }

    @Override
    public void removeLastCardFromPlayers(ArrayList<Player> players) {

        for (Player p: players) {
            p.getLastCard();
            //todo send message vote succesfull
            p.removeLastCard();
        }

    }
}
