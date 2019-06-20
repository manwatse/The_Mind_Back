package shared;

public class EmojiMessage {

    private String playerId;
    private String emoji;

    public EmojiMessage(String playerId, String emoji) {
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
