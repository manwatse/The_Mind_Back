package themindrestserver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.PlayerScore;
import shared.PlayerScoreDTO;

import java.util.ArrayList;

@Path("/TheMind")
public class TheMindFirebaseResponse implements ITheMindRESTResponse {
    private static ITheMindRESTLogic restLogic;

    public static void setRestLogic(ITheMindRESTLogic restLogic){
        TheMindFirebaseResponse.restLogic=restLogic;
    }

    @POST
    @Path("/player/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlayerScore(PlayerScoreDTO data) {
//        Gson gson = new Gson();
//        CreatePlayerScoreRequestDto createPlayerScoreRequestDto= gson.fromJson(data,CreatePlayerScoreRequestDto.class);

        if (data == null) {
            return Response.status(400).entity(ResponseHelper.getErrorResponse()).build();
        }

        PlayerScore createPlayerscore=restLogic.createPlayerScore(data.getName());
        return Response.status(200).entity(ResponseHelper.getPLayerScoreResponse(createPlayerscore)).build();
    }
    @PUT
    @Path("/score/playerid")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setPlayerScore(PlayerScoreDTO data) {
//        Gson gson = new Gson();
//        SetPlayerScoreDto setPlayerScoreDto = gson.fromJson(data, SetPlayerScoreDto.class);
        if (data ==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponse()).build();
        }
        boolean setScore= restLogic.setPlayerScore(data.getName(), data.getScore());
        return Response.status(200).entity(ResponseHelper.getSuccesReponse()).build();
    }

    @GET
    @Path("/score/findByID/{playerid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerScore(@PathParam("playerid")String playerIdAsString) {

        if (playerIdAsString==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponse()).build();
        }
        PlayerScore playerScore = restLogic.getPlayerScore(playerIdAsString);
        return Response.status(200).entity(ResponseHelper.getPLayerScoreResponse(playerScore)).build();

    }

    @GET
    @Path("/score")
    @Produces("application/json")
    public Response getHighscores() {

        ArrayList<PlayerScore> list = restLogic.getHighscores();
        if (list==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponse()).build();
        }
        return Response.status(200).entity(ResponseHelper.getHighScoresResponse(ResponseHelper.getPlayerscoreDTOList(list))).build();
    }
}
