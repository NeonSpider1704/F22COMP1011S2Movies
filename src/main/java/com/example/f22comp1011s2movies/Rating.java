package com.example.f22comp1011s2movies;

import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("Source")
    private String source;

    @SerializedName("Value")
    private String value;

    public String toString()
    {
        return source +"-" +value;
    }
}
