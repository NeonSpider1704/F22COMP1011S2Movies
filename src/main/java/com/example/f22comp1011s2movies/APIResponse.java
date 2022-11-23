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

    public Movie[] getSearch() {
        return search;
    }

    public List<Movie> getMovies()
    {
        return Arrays.asList(search);
    }
}
