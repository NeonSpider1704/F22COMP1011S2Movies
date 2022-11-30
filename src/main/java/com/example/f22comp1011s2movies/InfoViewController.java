package com.example.f22comp1011s2movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class InfoViewController implements MovieInfoControllers {

    @FXML
    private Label genreLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label languageLabel;

    @FXML
    private Label plotLabel;

    @FXML
    private Label ratedLabel;

    @FXML
    private ListView<Rating> ratingsListView;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;

    @Override
    public void getMovieInfo(String imdbID) throws IOException, InterruptedException {
        MovieInfo movie = APIUtility.getMovieDetails(imdbID);
        genreLabel.setText(movie.getGenre());
        languageLabel.setText(movie.getLanguage());
        plotLabel.setText(movie.getPlot());
        ratedLabel.setText(movie.getRated());
        titleLabel.setText(movie.getTitle());
        yearLabel.setText(movie.getYear());
        ratingsListView.getItems().addAll(movie.getRatings());
        try {
            imageView.setImage(new Image(movie.getPoster()));
        }catch (IllegalArgumentException e)
        {
            imageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.png")));
        }
    }

    /**
     * Return to the search-view if the back button is pushed
     */
    @FXML
    private void goToSearchView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"search-view.fxml");
    }
}
