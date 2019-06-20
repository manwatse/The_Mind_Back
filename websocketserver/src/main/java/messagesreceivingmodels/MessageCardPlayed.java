package messagesreceivingmodels;

public class MessageCardPlayed {

    String playerId;
    int cardPlayed;

    public MessageCardPlayed(String playerId, int playedCard) {
        this.playerId = playerId;
        this.cardPlayed = playedCard;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getPlayedCard() {
        return cardPlayed;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setPlayedCard(int playedCard) {
        this.cardPlayed = playedCard;
    }
}
