package com.example.f22comp1011s2movies;

import com.google.gson.annotations.SerializedName;

public class APIResponse {

    //in the JSON object, it is called Search and in the Java object it is called search
    @SerializedName("Search")
    private Movie[] search;

    private String totalResults;

    @SerializedName("Response")
    private String response;
}
