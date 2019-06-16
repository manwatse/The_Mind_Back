package models;

import javax.mail.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player {

    String id;
    String sessionId;
    ArrayList<Integer> cards = new ArrayList<Integer>();
    Comparator c = Collections.reverseOrder();


    public Player( String id,String sessionId){
        this.id=id;
        this.sessionId=sessionId;
    }

    public void sortCards(){
        Collections.sort(cards,c);
    }

    public void removeCard(int card){

        cards.remove(Integer.valueOf(card));
    }

    public void removeLastCard(){

    cards.remove(cards.size()-1);

    }

    public void getLastCard(){
        cards.get(cards.size()-1);
    }

    public String getId() {
        return id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public ArrayList<Integer> getCards() {
        return cards;
    }

    public void addCard(int card) {
        this.cards.add(card);
        sortCards();
    }
}
