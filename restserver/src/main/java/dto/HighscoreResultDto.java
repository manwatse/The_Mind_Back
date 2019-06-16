package dto;

import models.PlayerScore;

import java.util.List;

public class HighscoreResultDto extends BaseResultDto {

    List<PlayerScore> highscores;

    public HighscoreResultDto(List<PlayerScore> highscores){
        this.highscores = highscores;
    }

    public List<PlayerScore> getHighscores() {
        return highscores;
    }
}
