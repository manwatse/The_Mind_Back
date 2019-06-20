package shared;

import java.util.List;

public class PlayerScoreResponse {

    private List<PlayerScoreDTO> scores;
    private boolean success;

    public PlayerScoreResponse() {

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PlayerScoreDTO> getScores() {
        return scores;
    }

    public void setScores(List<PlayerScoreDTO> scores) {
        this.scores = scores;
    }
}
