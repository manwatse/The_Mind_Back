package dto;

public class CreatePlayerScoreRequestDto extends BaseResultDto {

    private String playerId;

    public CreatePlayerScoreRequestDto(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }
}
