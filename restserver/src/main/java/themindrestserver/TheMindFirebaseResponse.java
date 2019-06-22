package themindrestserver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import models.PlayerScore;
import shared.PlayerScoreDTO;

import java.util.ArrayList;

@Path("/themind")
public class TheMindFirebaseResponse implements ITheMindRESTResponse {
    private static ITheMindRESTLogic restLogic;
    private static Gson gson = new Gson();


    public static void setRestLogic(ITheMindRESTLogic restLogic){
        TheMindFirebaseResponse.restLogic=restLogic;
    }

    @POST
    @Path("/player/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlayerScore(String data) {
        PlayerScoreDTO playerScoreDTO = gson.fromJson(data, PlayerScoreDTO.class);
        if (data == null) {
            return Response.status(400).entity(ResponseHelper.getErrorResponse()).build();
        }

        PlayerScore createPlayerscore=restLogic.createPlayerScore(playerScoreDTO.getName());
        return Response.status(200).entity(ResponseHelper.getPLayerScoreResponse(createPlayerscore)).build();
    }
    @PUT
    @Path("/score/setScore")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setPlayerScore(String data) {
        PlayerScoreDTO playerScoreDTO = gson.fromJson(data, PlayerScoreDTO.class);
        if (data ==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponse()).build();
        }
        try {
            restLogic.setPlayerScore(playerScoreDTO.getName(), playerScoreDTO.getScore());
            return Response.status(200).entity(ResponseHelper.getSuccesReponse()).build();
        }
        catch (Exception e){
            System.out.println(e);
            return Response.status(400).entity(ResponseHelper.getErrorResponse()).build();
        }

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
    @Path("/score/all")
    @Produces("application/json")
    public Response getHighscores() {

        ArrayList<PlayerScore> list = restLogic.getHighscores();
        if (list==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponse()).build();
        }
        return Response.status(200).entity(ResponseHelper.getHighScoresResponse(ResponseHelper.getPlayerscoreDTOList(list))).build();
    }
}
