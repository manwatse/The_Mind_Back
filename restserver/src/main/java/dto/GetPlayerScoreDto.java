package dto;

public class GetPlayerScoreDto extends BaseResultDto {

    private String name;
    private int score;

    public GetPlayerScoreDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
