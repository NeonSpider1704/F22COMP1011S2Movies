package com.example.f22comp1011s2movies;

import com.google.gson.annotations.SerializedName;

public class Movie implements Comparable<Movie>{
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    private String imdbID;

    @SerializedName("Type")
    private String type;

    @SerializedName("Poster")
    private String poster;

    public String toString()
    {
        return String.format("%s-%s",title,year);
    }

    @Override
    public int compareTo(Movie otherMovie) {
        if (this.year.compareTo(otherMovie.year)==0)
        {
            return this.title.compareTo(otherMovie.title);
        }
        else
            return -(this.year.compareTo(otherMovie.year));
    }
}
