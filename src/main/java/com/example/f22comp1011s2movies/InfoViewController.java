package com.example.f22comp1011s2movies;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoViewController implements Initializable {

    @FXML
    private Label movieInfoLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * This method will call the OMDB API with the IMDBID for a movie
     * @param imdbID
     */
    public void getMovieInfo(String imdbID)
    {
        movieInfoLabel.setText("IMDB ID: "+imdbID);
    }

}
