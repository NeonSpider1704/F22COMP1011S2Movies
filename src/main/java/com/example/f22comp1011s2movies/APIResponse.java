package com.example.f22comp1011s2movies;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class APIResponse {

    //in the JSON object, it is called Search and in the Java object it is called search
    @SerializedName("Search")
    private Movie[] search;

    private String totalResults;

    @SerializedName("Response")
    private String response;

    @SerializedName("Error")
    private String error;

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public String getError() {
        return error;
    }

    public Movie[] getSearch() {
        return search;
    }

    public List<Movie> getMovies()
    {
        return Arrays.asList(search);
    }

    /**
     * This method returns true if the JSON data had a value of "True"
     */
    public boolean resultsReturned()
    {
        return response.equalsIgnoreCase("True");
    }
}
