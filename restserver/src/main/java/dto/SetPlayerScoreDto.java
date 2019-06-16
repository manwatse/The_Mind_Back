package dto;

public class SetPlayerScoreDto {
    private String name;
    private int score;

    public SetPlayerScoreDto(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
