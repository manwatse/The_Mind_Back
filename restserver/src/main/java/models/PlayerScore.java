package models;

public class PlayerScore {
    private String PlayerId;
    private int Highscore;

    public PlayerScore(String playerid,int Highscore){
        this.PlayerId=playerid;
        this.Highscore=Highscore;
    }

    public String getPlayerId() {
        return PlayerId;
    }

    public int getHighscore() {
        return Highscore;
    }
}
