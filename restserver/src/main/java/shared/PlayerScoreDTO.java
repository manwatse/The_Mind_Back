package shared;

public class PlayerScoreDTO {

    private String Playerid;
    private int score;

    public PlayerScoreDTO() {
    }

    public PlayerScoreDTO(String playerid, int score) {
        Playerid = playerid;
        this.score = score;
    }

    public PlayerScoreDTO(String playerid) {
        Playerid = playerid;
    }

    public String getName() {
        return Playerid;
    }

    public int getScore() {
        return score;
    }
}
