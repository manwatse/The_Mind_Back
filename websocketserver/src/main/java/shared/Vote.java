package shared;

public class Vote {

    private String emoji;
    private int gameID;
    private String playerId;

    public Vote(String emoji, int gameID, String playerId) {
        this.emoji = emoji;
        this.gameID = gameID;
        this.playerId = playerId;
    }

    public String getEmoji() {
        return emoji;
    }

    public int getGameID() {
        return gameID;
    }

    public String getPlayerId() {
        return playerId;
    }
}
