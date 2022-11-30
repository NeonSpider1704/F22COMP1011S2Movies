package com.example.f22comp1011s2movies;

import java.io.IOException;

public interface MovieInfoControllers {
    public void getMovieInfo(String imdbID) throws IOException, InterruptedException;
}
