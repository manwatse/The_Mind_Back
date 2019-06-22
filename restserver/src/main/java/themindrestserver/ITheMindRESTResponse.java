package themindrestserver;

import shared.PlayerScoreDTO;

import javax.ws.rs.core.Response;

public interface ITheMindRESTResponse {

    Response getPlayerScore(String data);

    Response setPlayerScore(String data);

    Response getHighscores();

    Response createPlayerScore(String data);

}
