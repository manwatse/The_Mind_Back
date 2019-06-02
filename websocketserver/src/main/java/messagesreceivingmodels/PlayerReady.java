package messagesreceivingmodels;

public class PlayerReady {

    String playerId;
    String PlayerNamer;
    String sessionId;

    public PlayerReady(String playerId, String playerNamer, String sessionId) {
        this.playerId = playerId;
        PlayerNamer = playerNamer;
        this.sessionId = sessionId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerNamer() {
        return PlayerNamer;
    }

    public String getSessionId() {
        return sessionId;
    }
}
