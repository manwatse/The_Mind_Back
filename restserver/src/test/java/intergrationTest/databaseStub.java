package intergrationTest;

import models.PlayerScore;
import themindrestserver.ITheMindFirebaseDB;

import java.util.ArrayList;
import java.util.List;

public class databaseStub implements ITheMindFirebaseDB {
private ArrayList<PlayerScore> playerlist= new ArrayList<>();

    public databaseStub(){
        playerlist.add(new PlayerScore("player1",0));
        playerlist.add(new PlayerScore("player2",0));
        playerlist.add(new PlayerScore("player3",0));
        playerlist.add(new PlayerScore("player4",0));
        playerlist.add(new PlayerScore("player5",0));
    }

    @Override
    public ArrayList<PlayerScore> getHighscores() {
        return playerlist;
    }

    @Override
    public boolean setPlayerScore(String playerId, int score) {
        for (int i=0;i<playerlist.size();i++){
            if (playerlist.get(i).getPlayerId()==playerId){
                playerlist.get(i).setScore(score);
                return true;
            }

        }
        return false;
    }

    @Override
    public PlayerScore getPlayerScore(String PlayerId) {

        PlayerScore found = new PlayerScore();
        for (int i=0;i<playerlist.size();i++){
            if (playerlist.get(i).getPlayerId()==PlayerId){
                found=playerlist.get(i);
                return found;
            }
        }
        return found;
    }

    @Override
    public PlayerScore createPlayerScore(String PlayerId) {
        playerlist.add(new PlayerScore(PlayerId,0));
        return playerlist.get(playerlist.size()-1);
    }

    @Override
    public boolean checkIfPlayerExist(String playerId) {
        return false;
    }
}
