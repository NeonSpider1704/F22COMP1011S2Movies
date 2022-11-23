package com.example.f22comp1011s2movies;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class MovieInfo {
    @SerializedName("Title")
    private String title;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Year")
    private String year;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("Language")
    private String language;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Ratings")
    private Rating[] ratings;

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRated() {
        return rated;
    }

    public String getYear() {
        return year;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getPoster() {
        return poster;
    }

    public List<Rating> getRatings() {
        return Arrays.asList(ratings);
    }
}
