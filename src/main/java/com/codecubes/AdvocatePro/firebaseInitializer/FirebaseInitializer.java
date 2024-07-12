package com.codecubes.AdvocatePro.firebaseInitializer;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

import java.io.IOException;
@Service
public class FirebaseInitializer {
    @PostConstruct
    public void initializer() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("./serviceKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://advocatepro-bc901-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }
}
