package themindrestserver;

import shared.PlayerScoreDTO;

import javax.ws.rs.core.Response;

public interface ITheMindRESTResponse {

    Response getPlayerScore(String data);

    Response setPlayerScore(PlayerScoreDTO data);

    Response getHighscores();

    Response createPlayerScore(PlayerScoreDTO data);

}
