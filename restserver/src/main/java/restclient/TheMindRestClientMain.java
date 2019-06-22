package restclient;

import shared.PlayerScoreDTO;

import java.util.List;

public class TheMindRestClientMain {
    private  static  TheMindRestClient restClient;

    public   static void main(String[] args)throws Exception{

        restClient=new TheMindRestClient();
        getAllScores();


    }

    private static void getAllScores(){
        List<PlayerScoreDTO> scores = restClient.getAllScores();
        if (scores.size()>0){
            System.out.println("Scores:");
            for (PlayerScoreDTO p:scores) {
                System.out.println(p);
            }
        }
    }
}
