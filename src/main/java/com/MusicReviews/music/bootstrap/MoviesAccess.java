package com.MusicReviews.music.bootstrap;


import com.MusicReviews.music.Domain.Movie;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//Access to IMDB in theathers movies
public class MoviesAccess {
    HttpURLConnection connection = null;
    final String myKey ="k_12345678";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();
    private static final AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
            .build();

    try {
        URL url = new URL("https://imdb-api.com/en/API/InTheaters/k_12345678");
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

        String title = object.getString("Name");
        String directors = object.get("Artist");

        Movie aMovie = new Movie(title,directors);

    }
    catch (Exception e) {
        e.printStackTrace();
    }

}
