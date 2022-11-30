package com.example.f22comp1011s2movies;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class InfoViewController {

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

}
