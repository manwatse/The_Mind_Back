package messagesreceivingmodels;

public class MessagePlayerJoinQueue {

    String playerId;
    String PlayerNamer;


    public MessagePlayerJoinQueue(String playerId) {
        this.playerId = playerId;

    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerNamer() {
        return PlayerNamer;
    }

}
