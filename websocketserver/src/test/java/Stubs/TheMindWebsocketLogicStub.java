package Stubs;

import models.Player;
import models.Score;
import themindwebsocketevent.ITheMindEvent;
import themindwebsocketgamelogic.ITheMindWebsocketGameLogic;
import themindwebsocketlogic.ITheMindWebsocketLogic;

import java.util.ArrayList;

public class TheMindWebsocketLogicStub  implements ITheMindWebsocketLogic {

    private String id;
    private int votes;
    private int playedCard;
    private String emoji;
    private ArrayList<Score> scores = new ArrayList<>();

    private ArrayList<Player> players= new ArrayList<>();

    private String playerJoinedQueue="Player Joined";

    public int getPlayedCard() {
        return playedCard;
    }

    public String getPlayerJoinedQueue() {
        return playerJoinedQueue;
    }

    public int GetVote(){
        return this.votes;
    }

    public String getEmoji() {
        return emoji;
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    @Override
    public void setEventSockets(ITheMindEvent eventSockets) {

    }

    @Override
    public void PlayerReady(String id, String sessionId) {


    }


    public void CreateGame(int gameId) {

    }


    public void JoinGame(String userid, String sessionId) {

    }


    public void UpdateQueue(int numberOfPlayers, ArrayList<String> sessionIds) {

    }

    @Override
    public void vote(String playerId, int gameId) {
        votes++;

    }

    @Override
    public void playCard(String playerId, int playedCard, String sessionId) {
        this.playedCard= playedCard;

    }


    public void RemoveGame(int gameId) {

    }

    @Override
    public void RemovePlayer(String sessionid) {

    }

    @Override
    public void emoji(String playerId, String emoji, String sessionId) {
        this.emoji=emoji;
    }

    @Override
    public ITheMindWebsocketGameLogic getGame(int gameId) {
        return null;
    }


    public void UpdatePlayerScore(String playerid, int score, String sessionId) {

    }


    public void GetPlayerScore(String playerid, String sessionId) {

    }


    public void SetPlayerScore(String playerid, String sessionId) {

    }

    @Override
    public void GetScores(String sessionId) {
        this.scores.add(new Score("player1",1));
    }
}
