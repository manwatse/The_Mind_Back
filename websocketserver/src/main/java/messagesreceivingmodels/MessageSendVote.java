package messagesreceivingmodels;

public class MessageSendVote {

    private String playerId;
    private int gameId;

    public MessageSendVote(String playerId, int gameId) {
        this.playerId = playerId;
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getGameId() {
        return gameId;
    }
}
