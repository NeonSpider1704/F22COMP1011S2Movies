package com.example.f22comp1011s2movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private ListView<Movie> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private HBox resultsBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    void getDetails(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) throws IOException, InterruptedException {
        //if the search is pushed, call the API with whatever is in the search text field
        APIResponse apiResponse = APIUtility.getMoviesFromOMDB(searchTextField.getText());

        //update the listview with the movies returned by the API
        resultsBox.setVisible(true);
        listView.getItems().addAll(apiResponse.getMovies());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultsBox.setVisible(false);
        msgLabel.setVisible(false);
    }
}
