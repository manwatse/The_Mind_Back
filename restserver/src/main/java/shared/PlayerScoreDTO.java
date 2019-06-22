package shared;

public class PlayerScoreDTO {

    private String playerId;
    private int score;

    public PlayerScoreDTO() {
    }

    public PlayerScoreDTO(String playerId) {
        this.playerId = playerId;
    }


    public PlayerScoreDTO(String playerId, int score) {
        this.playerId = playerId;
        this.score = score;
    }

    public String getName() {
        return playerId;
    }

    public int getScore() {
        return score;
    }
}
