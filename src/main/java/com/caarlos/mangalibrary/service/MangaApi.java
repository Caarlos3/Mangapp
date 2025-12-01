package com.caarlos.mangalibrary.service;

import com.caarlos.mangalibrary.model.Manga;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class MangaApi {

    private static final String BASE_URL = "https://api.jikan.moe/v4";
    private HttpClient httpClient;
    private Gson gson;
    
    public MangaApi() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }
    
    public void searchManga(String query) throws Exception{
        String url = BASE_URL + "?q=" + query;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("Failed : HTTP error code : " + response.statusCode());
        }
        
        String responseBody = response.body();
        JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonArray dataArray = json.getAsJsonArray("data");
        
        ArrayList<Object> mangas = new ArrayList<>();
        
        for (int i = 0; i < dataArray.size(); i++) {
            JsonObject mangaJson = dataArray.get(i).getAsJsonObject();
            
            Manga manga = new Manga();

        }
        
    }
}
