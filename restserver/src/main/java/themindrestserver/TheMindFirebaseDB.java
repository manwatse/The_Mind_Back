package themindrestserver;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.List;
import models.PlayerScore;

import java.io.FileInputStream;
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
            InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream("the-mindfront-869495d72690.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();

            FirebaseApp.initializeApp(options);

             db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<PlayerScore> getHighscores() {
        ArrayList<PlayerScore> list = new ArrayList<>();

        ApiFuture<QuerySnapshot> future = db.collection("Highscores").get();
        List<QueryDocumentSnapshot> documents = null;
        try {
            documents = future.get().getDocuments();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (QueryDocumentSnapshot document : documents) {
            System.out.println(document.getId() + " => " + document.toObject(PlayerScore.class));
            list.add(document.toObject(PlayerScore.class));
        }
        return list;
    }

    public boolean setPlayerScore(String playerId, int score) {
        Map<String, Object> update = new HashMap<>();
        update.put("score", score);

        ApiFuture<WriteResult> writeResult = db
                        .collection("users")
                        .document(playerId)
                        .set(update, SetOptions.merge());
        try {
            System.out.println("Update time : " + writeResult.get().getUpdateTime());
            return  true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }

    }

    public int getPlayerScore(String playerid) {
        DocumentReference docRef = db.collection("users").document(playerid);

        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = null;
        try {
            document = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (document.exists()) {
            PlayerScore playerScore=document.toObject(PlayerScore.class);
            return playerScore.getHighscore();
        } else {
            System.out.println("No such document!");
            return -1;
        }
    }

    public boolean createPlayerScore(String PlayerId) {

        DocumentReference docRef = db.collection("Playerscore").document(PlayerId);

        Map<String, Object> data = new HashMap<>();
        data.put("playerid", PlayerId);
        data.put("Highscore", 0);
        ApiFuture<WriteResult> result = docRef.set(data);

        try {
            System.out.println("Update time : " + result.get().getUpdateTime());
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }

    }
}
