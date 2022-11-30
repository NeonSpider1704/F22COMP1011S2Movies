package com.example.f22comp1011s2movies;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
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
    public static APIResponse getMoviesFromOMDB(String searchTerm) throws IOException, InterruptedException {
        //RegEx = Regular Expressions - looking for a pattern of characters
        searchTerm = searchTerm.replaceAll(" ","%20");

        //This is the same search http String that you used in your browser
        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&s="+searchTerm;

        //configure the environment to make a HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //send the httpRequest and save the result in a file called "movies.json"
//        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse
//                                                    .BodyHandlers
//                                                    .ofFile(Paths.get("movies.json")));

        HttpResponse<String> response = client.send(httpRequest, HttpResponse
                                                .BodyHandlers.ofString());

        //parse the JSON object and return it as a Java object
        Gson gson = new Gson();
        return gson.fromJson(response.body(),APIResponse.class);
    }

    /**
     * This method will call the OMDB API with the imdbID for a movie and return
     * the movie details
     * @param imdbID
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static MovieInfo getMovieDetails(String imdbID) throws IOException, InterruptedException {

        //This is the same search http String that you used in your browser
        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&i="+imdbID;

        //configure the environment to make a HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //send the httpRequest and save the result in a file called "movies.json"
//        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse
//                                                    .BodyHandlers
//                                                    .ofFile(Paths.get("movies.json")));
        HttpResponse<String> response = client.send(httpRequest, HttpResponse
                .BodyHandlers.ofString());

        //parse the JSON object and return it as a Java object
        Gson gson = new Gson();
        return gson.fromJson(response.body(),MovieInfo.class);
    }


    /**
     * This method will read from "movies.json" and create an APIResponse object
     */
    public static APIResponse getMoviesFromFile()
    {
        //Create a GSON object.  GSON is the Google library that can read and write
        //JSON
        //in order to use this library, we need to update the pom.xml and module-info.java
        //files.  Don't forget to reload the Maven dependencies
        Gson gson = new Gson();

        APIResponse apiResponse = null;

        //open the file and pass it into the the Gson object to covert JSON objects
        //to Java objects
        try(
                FileReader fileReader = new FileReader("movies.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return apiResponse;
    }
}
