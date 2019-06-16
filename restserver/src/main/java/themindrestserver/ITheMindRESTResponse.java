package themindrestserver;

import javax.ws.rs.core.Response;

public interface ITheMindRESTResponse {

    Response getPlayerScore(String data);

    Response setPlayerScore(String data);

    Response getHighscores(String data);

    Response createPlayerScore(String data);

}
