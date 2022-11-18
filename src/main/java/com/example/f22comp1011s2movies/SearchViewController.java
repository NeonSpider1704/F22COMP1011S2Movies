package com.example.f22comp1011s2movies;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SearchViewController {

    @FXML
    private ListView<Movie> movieListView;

    @FXML
    private TextField searchTextField;

    @FXML
    private void search() throws IOException, InterruptedException {
        APIUtility.getMoviesFromOMDB(searchTextField.getText());
        APIResponse apiResponse = APIUtility.getMoviesFromFile();
        movieListView.getItems().addAll(apiResponse.getSearch());
    }


}

