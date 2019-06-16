package themindrestserver;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import dto.CreatePlayerScoreRequestDto;
import dto.GetPlayerScoreDto;
import dto.HighscoreResultDto;
import dto.SetPlayerScoreDto;
import models.PlayerScore;

import java.util.ArrayList;

@Path("/TheMind")
public class TheMindFirebaseResponse implements ITheMindRESTResponse {
    private static ITheMindRESTLogic restLogic;

    public static void setRestLogic(ITheMindRESTLogic restLogic){
        TheMindFirebaseResponse.restLogic=restLogic;
    }


    @GET
    @Path("/player/SignIn")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getPlayerScore(String data) {
        Gson gson = new Gson();
        GetPlayerScoreDto getPlayerScoreDto= gson.fromJson(data,GetPlayerScoreDto.class);
        if (getPlayerScoreDto==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }
        getPlayerScoreDto.setScore(restLogic.getPlayerScore(getPlayerScoreDto.getName()));
        return Response.status(200).entity(ResponseHelper.getPLayerScoreResultDtoString(getPlayerScoreDto)).build();

    }
    @PUT
    @Path("/player/SignIn")
    @Consumes("application/json")
    @Produces("application/json")
    public Response setPlayerScore(String data) {
        Gson gson = new Gson();
        SetPlayerScoreDto setPlayerScoreDto = gson.fromJson(data, SetPlayerScoreDto.class);
        if (setPlayerScoreDto ==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }
        boolean setScore= restLogic.setPlayerScore(setPlayerScoreDto.getName(), setPlayerScoreDto.getScore());
        return Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(setScore)).build();
    }
    @GET
    @Path("/player/SignIn")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getHighscores(String data) {
        Gson gson = new Gson();
        HighscoreResultDto highscoreResultDto=gson.fromJson(data,HighscoreResultDto.class);
        if (highscoreResultDto==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }
        ArrayList<PlayerScore> list = restLogic.getHighscores();
        return Response.status(200).entity(ResponseHelper.getHighscoresResultDtcString(list)).build();
    }

    @POST
    @Path("/player/SignIn")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createPlayerScore(String data) {
        Gson gson = new Gson();
        CreatePlayerScoreRequestDto createPlayerScoreRequestDto= gson.fromJson(data,CreatePlayerScoreRequestDto.class);
        if (createPlayerScoreRequestDto == null) {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        Boolean createPlayerscore=restLogic.createPlayerScore(createPlayerScoreRequestDto.getPlayerId());
        return Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(createPlayerscore)).build();
    }
}
