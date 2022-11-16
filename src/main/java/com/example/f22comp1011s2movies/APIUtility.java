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
    public static void getMoviesFromOMDB(String searchTerm) throws IOException, InterruptedException {
        //RegEx = Regular Expressions - looking for a pattern of characters
        System.out.printf("Before: '%s'%n",searchTerm);
        searchTerm = searchTerm.replaceAll(" ","%20");
        System.out.printf("After: '%s'%n",searchTerm);

        //This is the same search http String that you used in your browser
        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&s="+searchTerm;

        //configure the environment to make a HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //send the httpRequest and save the result in a file called "movies.json"
        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse
                                                    .BodyHandlers
                                                    .ofFile(Paths.get("movies.json")));
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
