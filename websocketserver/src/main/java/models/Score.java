package models;

public class Score {
    String playerId;
    int playerScore;

    public Score(String name, int playerScore) {
        this.playerId = name;
        this.playerScore = playerScore;

    }

    public String getPlayerId() {
        return playerId;
    }

    public int getPlayerScore() {
        return playerScore;
    }

}
