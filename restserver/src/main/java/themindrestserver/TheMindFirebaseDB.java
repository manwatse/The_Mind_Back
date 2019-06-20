package themindrestserver;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import models.PlayerScore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class TheMindFirebaseDB implements ITheMindFirebaseDB {
    private Firestore db;

    public TheMindFirebaseDB() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream serviceAccount = classloader.getResourceAsStream("the-mindfront-firebase-adminsdk-78das-8677ba4aeb.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://the-mindfront.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            this.db = FirestoreClient.getFirestore();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PlayerScore createPlayerScore(String PlayerId) {

        DocumentReference docRef = db.collection("PlayerScore").document(PlayerId);
        Map<String, Object> data = new HashMap<>();
        data.put("playerId", PlayerId);
        data.put("score", 0);

        try {
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Update time : " + result.get().getUpdateTime());
        } catch (Exception e){
            System.out.println(e);
        }
        return null;

    }


    public PlayerScore getPlayerScore(String playerid) {

        ApiFuture<QuerySnapshot> query = db.collection("PlayerScore").select("playerId",playerid).get();

        try {
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                PlayerScore playerScore =document.toObject(PlayerScore.class);
                System.out.println("Playerscore retrieved");
                return playerScore;
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public boolean setPlayerScore(String playerId, int score) {

        Map<String, Object> docData = new HashMap<>();
        docData.put("playerId", playerId);
        docData.put("score", score);


        try {
            ApiFuture<WriteResult> future = db.collection("PlayerScore").document(playerId).set(docData);
            System.out.println("Score updated");
            return true;
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }



    public ArrayList<PlayerScore> getHighscores() {
        ArrayList<PlayerScore> list = new ArrayList<>();
        ApiFuture<QuerySnapshot> query = db.collection("PlayerScore").get();

        try {
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                PlayerScore playerScore =document.toObject(PlayerScore.class);
                list.add(playerScore);
                System.out.println(document.getId());
                return list;
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
