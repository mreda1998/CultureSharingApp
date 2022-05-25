package com.MusicReviews.music.bootstrap;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SpotifyAccess {
    @Test
    public void whenGetRequest_thenCorrect() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://spotify-top50.p.rapidapi.com/50?day=14&month=2&year=2022&reg=GL")
                .get()
                .addHeader("X-RapidAPI-Host", "spotify-top50.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
                .build();

        Response response = client.newCall(request).execute();
    }

}
