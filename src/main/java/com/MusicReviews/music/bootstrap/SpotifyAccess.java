
package com.MusicReviews.music.bootstrap;

import com.MusicReviews.music.Domain.Album;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpotifyAccess {
    HttpURLConnection connection = null;
    private static final String clientId = "382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc";
    private static final String clientSecret = "zudknyqbh3wunbhcvg9uyvo7uwzeu6nne";
    private static final URL url = new URL("https://api.spotify.com/v1/albums");
    private static final String token = "BQC2c24aXaMZ7WkF5KEaSXZazSmLqnkiY9KGODHYQbvIqf5wiB0CJpibtMXdD7149Hizigi9ODe6MpF3VttnupySyR1N_Kv7bQ7Hj_NW9Iy1iPtql0hzlmwkoXVpIqWBE2ceBO3ixU2NO3ChUXf663IzNGK9hg";


    try {
        URL url = new URL("https://api.spotify.com/v1/albums");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);

        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder response = new StringBuilder();
        String line = null;
        while (line=reader.readLine()!=null) {
            response.append(line);
            response.append("\r");
        }
        reader.close();
        String result = response.toString();
        JSONObject object = new JSONObject("Items");

        String id = object.getString("imDbId");
        String title = object.getString("title");
        String date = object.get("releaseDate");
        String artist = object.get("artist");

        Album aAlbum = new Album(title,artist,date);

    }
    catch (Exception e) {
        e.printStackTrace();
    }


}
