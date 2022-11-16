package com.example.f22comp1011s2movies;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * This method will create a JSON file with the search results for
     * a movie from OMDB
     */
    public static void getMoviesFromOMDB(String searchTerm) throws IOException, InterruptedException {
        //This is the same search http String that you used in your browser
        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&s=john%20wick";

        //configure the environment to make a HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //send the httpRequest and save the result in a file called "movies.json"
        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse
                                                    .BodyHandlers
                                                    .ofFile(Paths.get("movies.json")));

    }
}
