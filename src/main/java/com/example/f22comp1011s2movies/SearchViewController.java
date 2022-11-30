package com.example.f22comp1011s2movies;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
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
    private ProgressBar progressBar;

    @FXML
    void getDetails(ActionEvent event) throws IOException, InterruptedException {
        Movie movieSelected = listView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event,"info-view.fxml",movieSelected.getImdbID());
    }

    @FXML
    void search(ActionEvent event) throws IOException, InterruptedException {

        progressBar.setVisible(true);

        //simulate that the API took 3 seconds to return
        Thread searchThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (double progress=.1; progress<=1 ; progress+=0.1)
                {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    final double progressAmount = progress;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (progressAmount>=0.92)
                                progressBar.setVisible(false);
                            else
                                progressBar.setProgress(progressAmount);
                        }
                    });
                }
            }
        });
        searchThread.start();



        //if the search is pushed, call the API with whatever is in the search text field
        APIResponse apiResponse = APIUtility.getMoviesFromOMDB(searchTextField.getText());

        if (apiResponse.resultsReturned())
        {
            //update the listview with the movies returned by the API
            resultsBox.setVisible(true);
            msgLabel.setVisible(false);
            listView.getItems().clear();
            listView.getItems().addAll(apiResponse.getMovies());
            Collections.sort(listView.getItems());
        }
        else
        {
            resultsBox.setVisible(false);
            msgLabel.setVisible(true);
            msgLabel.setText(apiResponse.getError());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultsBox.setVisible(false);
        msgLabel.setVisible(false);
        progressBar.setVisible(false);

        //configure a listener so that when a movie is selected from the listview
        //it displays the poster art
       listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, old, movieSelected) -> {
                    if (movieSelected!=null)
                    {
                        selectedVBox.setVisible(true);
                        try {
                            posterImageView.setImage(new Image(movieSelected.getPoster()));
                        } catch (IllegalArgumentException e) {
                            posterImageView.setImage(new Image(Main.class
                                    .getResourceAsStream("images/default_poster.png")));

                        }
                    }
                    else
                    {
                        selectedVBox.setVisible(false);
                    }
                });
    }
}
