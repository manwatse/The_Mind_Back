package models;

import shared.PlayerScoreDTO;

public class PlayerScore {
    private String PlayerId;
    private int score;

    public PlayerScore(String playerid,int score){
        this.PlayerId=playerid;
        this.score = score;
    }

    public PlayerScore() {
    }

    public void setPlayerId(String playerId) {
        PlayerId = playerId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerId() {
        return PlayerId;
    }

    public int getScore() {
        return score;
    }

    public PlayerScoreDTO createDTO () {
        return new PlayerScoreDTO(PlayerId,score);
    }
}
