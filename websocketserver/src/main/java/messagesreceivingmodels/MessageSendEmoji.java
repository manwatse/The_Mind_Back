package messagesreceivingmodels;

public class MessageSendEmoji {

    private  String playerId;
    private String emoji;

    public MessageSendEmoji(String playerId, String emoji) {
        this.playerId = playerId;
        this.emoji = emoji;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getEmoji() {
        return emoji;
    }
}
